/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ecomclientlourdadmin;

import entity.BeverageEntity;
import entity.CocktailEntity;
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
            EcomClientLourdAdmin.addBeverage();
            EcomClientLourdAdmin.addCocktail();
        } catch (IOException | NamingException ex) {
            Logger.getLogger(EcomClientLourdAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static public void addCocktail() {
        CocktailEntity cocktail = new CocktailEntity();
        cocktail.setName("Cocktail Jamaïca");
        cocktail.setPrice(new Float(2.5));
        cocktail.setRecipe("Recette secrête de Mama Coffee...");
        cocktail.setFlavor(CocktailFlavorEnum.FRUITY);
        cocktail.setPower(CocktailPowerEnum.SOFT);
        List<Deliverable> deliverables = new ArrayList<>();
        deliverables.add((Deliverable) adminFacade.getAllBeverages().get(0));
        cocktail.setDeliverables(deliverables);
        System.out.println("Adding cocktail : " + cocktail);
        adminFacade.addCocktail(cocktail);
        System.out.println("Done");
    }

    static public void addBeverage() {
        BeverageEntity b = new BeverageEntity();
        b.setAlcoholicDegree(99);
        b.setName("Gnole de bach");
        b.setPrice(new Float(1));
        b.setCapacity(1000000);
        b.setQuantity(0);
        adminFacade.addBeverage(b);
        List<BeverageEntity> list = adminFacade.getAllBeverages();
        for (BeverageEntity dr : list) {
            System.out.println(dr.getName() + " : \n Degré d'alcool : " + dr.getAlcoholicDegree() + " \n Prix : " + dr.getPrice() + "€");
        }
    }
}
