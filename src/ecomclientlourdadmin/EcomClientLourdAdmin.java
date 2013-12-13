/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ecomclientlourdadmin;

import entity.AddressEntity;
import entity.BeverageEntity;
import entity.ClientAccountEntity;
import entity.CocktailEntity;
import entity.DecorationEntity;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.HEAD;
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
            if (args.length > 0 && args[0].equalsIgnoreCase("delete")) {
                System.out.println("Deleting all datas...");
                EcomClientLourdAdmin.scriptDelete();
            } else {
                System.out.println("Adding some datas...");
                EcomClientLourdAdmin.scriptCreate();
            }
            System.out.println("Done !");
        } catch (IOException | NamingException ex) {
            Logger.getLogger(EcomClientLourdAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void scriptDelete() {
        /* Remove Deliverables ==> remove all cocktails. */
        List<BeverageEntity> beverages = (List<BeverageEntity>) adminFacade.getAllBeverages();
        for (int i = 0; i < beverages.size(); i++) {
            System.out.println("delete : " + beverages.get(i));
            adminFacade.removeBeverage(beverages.get(i));
        }
        List<DecorationEntity> decos = (List<DecorationEntity>) adminFacade.getAllDecorations();
        for (int i = 0; i < decos.size(); i++) {
            System.out.println("delete : " + decos.get(i));
            adminFacade.removeDecoration(decos.get(i));
        }

        /* Check that there isn't any other cocktails, and delete remaining */
        List<CocktailEntity> cocktails = (List<CocktailEntity>) adminFacade.getAllCocktails();
        if (cocktails.size() > 0) {
            System.err.println("Les cocktails n'ont pas été tous supprimés... "
                    + cocktails.size() + " cocktails restants :");
        }
        for (int i = 0; i < cocktails.size(); i++) {
            CocktailEntity cocktail = adminFacade.getCocktailFull(cocktails.get(i));
            System.err.println(cocktail.getName() + " : "
                    + cocktail.getDeliverables());
            adminFacade.removeCocktail(cocktail);
        }

        /* Remove client accounts */
        List<ClientAccountEntity> clients = (List<ClientAccountEntity>) adminFacade.getAllClients();
        for (int i = 0; i < clients.size(); i++) {
            adminFacade.removeClient(clients.get(i));
        }

        /* Remove addresses */
        List<AddressEntity> addresses = (List<AddressEntity>) adminFacade.getAllAddresses();
        for (int i = 0; i < addresses.size(); i++) {
            adminFacade.removeAddress(addresses.get(i));
        }

        /* TODO :
         * * Remove orders
         */
    }

    public static void scriptCreate() {
        /* Add deliverable */
        BeverageEntity whisky = EcomClientLourdAdmin.addBeverage(
                "Whisky",
                new Float(19),
                new Integer(40),
                new Integer(100),
                new Integer(20));
        BeverageEntity vodka = EcomClientLourdAdmin.addBeverage(
                "Vodka",
                new Float(17),
                new Integer(40),
                new Integer(100),
                new Integer(20));
        BeverageEntity coca = EcomClientLourdAdmin.addBeverage(
                "Coca-Cola - 2L",
                new Float(3),
                new Integer(0),
                new Integer(200),
                new Integer(20));
        BeverageEntity orange = EcomClientLourdAdmin.addBeverage(
                "Jus d'orange - 1.5L",
                new Float(2),
                new Integer(0),
                new Integer(150),
                new Integer(20));
        BeverageEntity gin = EcomClientLourdAdmin.addBeverage(
                "Gin",
                new Float(21),
                new Integer(40),
                new Integer(100),
                new Integer(20));

        DecorationEntity ombrelle = EcomClientLourdAdmin.addDecoration(
                "Ombrelle",
                new Float(3),
                new Integer(100));
        DecorationEntity citron = EcomClientLourdAdmin.addDecoration(
                "Citron",
                new Float(5),
                new Integer(10));

        /*Adding cocktails*/
        List<Deliverable> deliverables = new ArrayList<>();

        deliverables.add(whisky);
        deliverables.add(coca);
        CocktailEntity cocktail = EcomClientLourdAdmin.addCocktail(
                "Whisky Coca",
                "50% Whisky"
                + "50% Coca"
                + "Directement dans un verre.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.SOFT,
                "whisky_coca.png",
                deliverables);

        deliverables.clear();
        deliverables.add(coca);
        deliverables.add(orange);
        deliverables.add(ombrelle);
        EcomClientLourdAdmin.addCocktail(
                "Orange Coca",
                "Trop dégueulasse pour avoir une recette."
                + "Fait bien comme tu le sens, avec beaucoup de glaçons !",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.SOFT,
                "coca_orange.png",
                deliverables);
        EcomClientLourdAdmin.addCocktail(
                "Coca Orange",
                "Trop dégueulasse pour avoir une recette."
                + "Fait bien comme tu le sens, avec beaucoup de glaçons !",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.SOFT,
                "coca_orange.png",
                deliverables);

        deliverables.clear();
        deliverables.add(whisky);
        deliverables.add(orange);
        EcomClientLourdAdmin.addCocktail(
                "Whisky Orange",
                "Pas bien compliqué...\n"
                + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent arcu nulla, varius non malesuada id, tristique in quam. Vestibulum risus purus, porta non sapien nec, luctus facilisis nunc. Duis sollicitudin convallis venenatis. Mauris at eros vel enim ullamcorper feugiat sed in odio. Praesent leo odio, tristique vel dui eget, laoreet accumsan est. Suspendisse interdum nulla orci, a mollis magna tristique eget. Phasellus metus massa, feugiat sed tristique in, porta sed orci. Integer posuere ligula ante, vel condimentum sapien pretium sed.\n"
                + "\n"
                + "Quisque mattis massa et turpis aliquam pellentesque. Suspendisse velit urna, condimentum aliquet vulputate sit amet, sagittis sit amet velit. Maecenas sed posuere urna. Mauris fermentum est massa. Cras ut felis tortor. Donec enim massa, congue sed dictum et, imperdiet quis ante. Pellentesque tristique ipsum quis dolor laoreet euismod. Sed adipiscing nisl a vulputate luctus. Nullam molestie, tellus in eleifend rhoncus, leo sapien facilisis eros, in semper nulla lorem sed velit. Vivamus eget massa ante. Quisque lacinia augue sed nibh varius posuere. Aliquam erat volutpat.\n"
                + "\n"
                + "Maecenas imperdiet lorem ligula, quis consequat dolor feugiat sed. Sed vitae nisi venenatis, porttitor nulla eget, suscipit libero. Morbi venenatis facilisis facilisis. Phasellus quis sapien nisl. In consequat arcu eu nulla placerat, et sagittis dui eleifend. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Praesent placerat vel enim nec elementum. Phasellus consectetur arcu nulla, quis lacinia sapien malesuada ac. In sit amet gravida ante. Etiam ac tincidunt felis. Phasellus in mauris pretium, cursus risus ac, dignissim ante.\n"
                + "\n"
                + "Nunc ut justo iaculis, malesuada enim et, accumsan sapien. Integer lorem elit, egestas vitae viverra vel, scelerisque at ligula. Sed tincidunt est non ligula suscipit ornare. Maecenas fermentum vulputate massa, tincidunt fringilla sapien rutrum eget. Praesent a tempor quam, a vehicula risus. Fusce sed varius justo, sit amet posuere lorem. Donec molestie lorem ac sem vehicula bibendum.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.SOFT,
                "whisky_orange.png",
                deliverables);

        deliverables.clear();
        deliverables.add(vodka);
        deliverables.add(coca);
        deliverables.add(citron);
        EcomClientLourdAdmin.addCocktail(
                "Vodka Coca",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam a diam sit amet risus porttitor aliquam ut in est. Morbi ut fermentum ligula, eget sodales risus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Praesent sit amet blandit velit, nec interdum ipsum. Donec cursus iaculis tortor ut posuere. Curabitur tempor egestas ipsum ut consectetur. Integer ligula orci, vulputate non leo ac, aliquet bibendum ipsum. Vivamus laoreet semper nisl vestibulum pellentesque. Duis volutpat bibendum ipsum ut rhoncus. Cras et nunc augue. Nulla tincidunt aliquam dapibus. Nullam sit amet metus quis nisi vehicula aliquam. Sed suscipit dignissim fringilla. Aliquam iaculis elit eu mauris pharetra, in viverra augue aliquet. Morbi dictum nulla in pellentesque interdum.\n",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.SOFT,
                "vodka_coca.png",
                deliverables);

        /* Add a client */
        /* This client need an address. */
        AddressEntity address = EcomClientLourdAdmin.addAddress(
                "Alexis",
                "BRENON",
                "1 Rue de la Ré",
                "69001",
                "Lyon 1er",
                "France");
        ClientAccountEntity alexis = EcomClientLourdAdmin.addClient(
                "alexis",
                "alexis",
                address);

        /* Add a new cocktail proposed by a client */
        deliverables.clear();
        deliverables.add(gin);
        deliverables.add(ombrelle);
        EcomClientLourdAdmin.addCocktail(
                "Gin Sec",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tristique nullam.",
                CocktailFlavorEnum.BITTER,
                CocktailPowerEnum.STRONG,
                "gin_sec.png",
                deliverables,
                alexis);

        EcomClientLourdAdmin.adminFacade.terminateTransactions();
    }

    static public ClientAccountEntity addClient(
            String login,
            String password,
            AddressEntity address) {
        ClientAccountEntity client = new ClientAccountEntity();
        client.setLogin(login);
        client.setPassword(password);
        client.setDelivery_address(address);
        client = adminFacade.addClient(client);
        return client;
    }

    static public CocktailEntity addCocktail(
            String nom,
            String recipe,
            CocktailFlavorEnum flavor,
            CocktailPowerEnum power,
            String urlPhoto,
            List<Deliverable> list) {
        return addCocktail(nom, recipe, flavor, power, urlPhoto, list, null);
    }

    static public CocktailEntity addCocktail(
            String nom,
            String recipe,
            CocktailFlavorEnum flavor,
            CocktailPowerEnum power,
            String urlPhoto,
            List<Deliverable> list,
            ClientAccountEntity client) {
        CocktailEntity cocktail = new CocktailEntity();
        cocktail.setName(nom);
        cocktail.setRecipe(recipe);
        cocktail.setFlavor(flavor);
        cocktail.setPower(power);
        cocktail.setPhotoURI(urlPhoto);
        cocktail.setDeliverables(new ArrayList<>(list));
        cocktail.setClient(client);

        cocktail = adminFacade.addCocktail(cocktail);
        Iterator<Deliverable> it = list.iterator();
        while (it.hasNext()) {
            Deliverable d = it.next();
            if (d instanceof BeverageEntity) {
                BeverageEntity bev = (BeverageEntity) d;
                bev.setCocktails(adminFacade.getBeverage(d.getID()).getCocktails());
            } else if (d instanceof DecorationEntity) {
                DecorationEntity deco = (DecorationEntity) d;
                deco.setCocktails(adminFacade.getDecoration(d.getID()).getCocktails());
            }
        }

        return cocktail;
    }

    static public BeverageEntity addBeverage(
            String name,
            Float price,
            Integer degree,
            Integer capacity,
            Integer quantity) {
        BeverageEntity b = new BeverageEntity();
        b.setAlcoholicDegree(degree);
        b.setName(name);
        b.setPrice(price);
        b.setCapacity(capacity);
        b.setQuantity(quantity);
        b = adminFacade.addBeverage(b);

        return b;
    }

    static public DecorationEntity addDecoration(
            String name,
            Float price,
            Integer quantity) {
        DecorationEntity deco = new DecorationEntity();
        deco.setName(name);
        deco.setPrice(price);
        deco.setQuantity(quantity);
        deco = adminFacade.addDecoration(deco);

        return deco;
    }

    static public AddressEntity addAddress(
            String firstName,
            String lastName,
            String street,
            String ZIPCode,
            String city,
            String country) {
        AddressEntity address = new AddressEntity();
        address.setFirst_name(firstName);
        address.setSurname(lastName);
        address.setStreet(street);
        address.setPostal_code(ZIPCode);
        address.setCity(city);
        address.setCountry(country);
        address = adminFacade.addAddress(address);

        return address;
    }
}
