/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ecomclientlourdadmin;

import entity.AddressEntity;
import entity.BeverageEntity;
import entity.CocktailEntity;
import entity.OrderEntity;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import pojo.CocktailFlavorEnum;
import pojo.CocktailPowerEnum;
import pojo.Deliverable;
import pojo.OrderStateEnum;
import session.interfaces.AdminFacadeRemoteItf;

/**
 *
 * @author yann
 */
public class EcomClientLourdAdmin {

    static private AdminFacadeRemoteItf adminFacade;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("jndi.properties"));
            InitialContext ctx = new InitialContext(props);
            adminFacade = (AdminFacadeRemoteItf) ctx.lookup("java:global/Ecom/Ecom-ejb/AdminFacadeBean!session.interfaces.AdminFacadeRemoteItf");
           /*Adding */
            EcomClientLourdAdmin.addBeverage("whisky", new Float(19), new Integer(40), new Integer(100), new Integer(20));
            EcomClientLourdAdmin.addBeverage("vodka", new Float(17), new Integer(40), new Integer(100), new Integer(20));
            EcomClientLourdAdmin.addBeverage("coca", new Float(3), new Integer(0), new Integer(200), new Integer(20));
            EcomClientLourdAdmin.addBeverage("orange", new Float(2), new Integer(0), new Integer(150), new Integer(20));
            EcomClientLourdAdmin.addBeverage("gin", new Float(21), new Integer(40), new Integer(100), new Integer(20));
           /*Adding cocktails*/
            List<Deliverable> deliverables = new ArrayList<>();
            deliverables.add((Deliverable) adminFacade.getAllBeverages().get(0));
            deliverables.add((Deliverable) adminFacade.getAllBeverages().get(2));
            EcomClientLourdAdmin.addCocktail("whisky coca",new Float(8), "Inconnu",CocktailFlavorEnum.FRUITY,CocktailPowerEnum.SOFT,"911.png",deliverables);
            deliverables.clear();
            deliverables.add((Deliverable) adminFacade.getAllBeverages().get(3));
            deliverables.add((Deliverable) adminFacade.getAllBeverages().get(2));
            EcomClientLourdAdmin.addCocktail("orange coca (lol)",new Float(8), "Inconnu",CocktailFlavorEnum.FRUITY,CocktailPowerEnum.SOFT,"77e_ciel.png",deliverables);
            EcomClientLourdAdmin.addCocktail("coca orange (lol)",new Float(8), "Inconnu",CocktailFlavorEnum.FRUITY,CocktailPowerEnum.SOFT,"911.png",deliverables);
            deliverables.clear();
            deliverables.add((Deliverable) adminFacade.getAllBeverages().get(0));
            deliverables.add((Deliverable) adminFacade.getAllBeverages().get(3));
            EcomClientLourdAdmin.addCocktail("whisky orange",new Float(8), "Inconnu",CocktailFlavorEnum.FRUITY,CocktailPowerEnum.SOFT,"americano.png",deliverables);
            deliverables.clear();
            deliverables.add((Deliverable) adminFacade.getAllBeverages().get(1));
            deliverables.add((Deliverable) adminFacade.getAllBeverages().get(2));
            EcomClientLourdAdmin.addCocktail("vodka coca",new Float(8), "Inconnu",CocktailFlavorEnum.FRUITY,CocktailPowerEnum.SOFT,"amarante.png",deliverables);
            /*Adding addresses */
             EcomClientLourdAdmin.addAddress();
             /*Adding orders*/
            List<AddressEntity> addresses= new ArrayList<>();
            addresses.add((AddressEntity)adminFacade.getAllAddresses().get(0));
            List<CocktailEntity> cocktails= new ArrayList<>();
            cocktails.add((CocktailEntity)adminFacade.getAllCocktails().get(0));
            EcomClientLourdAdmin.addOrder(addresses,cocktails,OrderStateEnum.SENT);
            cocktails.add((CocktailEntity)adminFacade.getAllCocktails().get(1));
            EcomClientLourdAdmin.addOrder(addresses,cocktails,OrderStateEnum.SENT);
            cocktails.add((CocktailEntity)adminFacade.getAllCocktails().get(2));
            EcomClientLourdAdmin.addOrder(addresses,cocktails,OrderStateEnum.SENT);
        } catch (IOException | NamingException ex) {
            Logger.getLogger(EcomClientLourdAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static public void addCocktail(String nom, Float price, String recipe, CocktailFlavorEnum flavor, CocktailPowerEnum power, String urlPhoto, List<Deliverable> list) {
        CocktailEntity cocktail = new CocktailEntity();
        cocktail.setName(nom);
        cocktail.setPrice(price);
        cocktail.setRecipe(recipe);
        cocktail.setFlavor(flavor);
        cocktail.setPower(power);
        cocktail.setPhotoURI(urlPhoto);
        cocktail.setDeliverables(list);
        adminFacade.addCocktail(cocktail);
    }

    static public void addBeverage(String name, Float price, Integer degree, Integer capacity, Integer quantity ) {
        BeverageEntity b = new BeverageEntity();
        b.setAlcoholicDegree(degree);
        b.setName(name);
        b.setPrice(price);
        b.setCapacity(capacity);
        b.setQuantity(quantity);
        adminFacade.addBeverage(b);
    }
    
    static public void addOrder(List<AddressEntity> addresses, List<CocktailEntity> cocktails,OrderStateEnum state) {
        OrderEntity o = new OrderEntity();
        o.setStatus(state);
        o.setAddresses(addresses);
        o.setCocktails(cocktails);
        adminFacade.addOrder(o);
    }
    
    static public void addAddress() {
       AddressEntity a = new AddressEntity();
       a.setCity("Grenoble");
        adminFacade.addAddress(a);
         AddressEntity b = new AddressEntity();
       b.setCity("Lyon");
        adminFacade.addAddress(b);
    }
    
}


