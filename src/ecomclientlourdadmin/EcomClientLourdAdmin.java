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
        BeverageEntity grenade = EcomClientLourdAdmin.addBeverage(
                "Jus de grenade - 1L",
                new Float(3),
                new Integer(0),
                new Integer(100),
                new Integer(20));
        BeverageEntity brandy = EcomClientLourdAdmin.addBeverage(
                "Brandy",
                new Float(20),
                new Integer(30),
                new Integer(100),
                new Integer(20));
        BeverageEntity tequila = EcomClientLourdAdmin.addBeverage(
                "Tequila",
                new Float(20),
                new Integer(40),
                new Integer(100),
                new Integer(20));
        BeverageEntity rum = EcomClientLourdAdmin.addBeverage(
                "Rhum",
                new Float(18),
                new Integer(25),
                new Integer(100),
                new Integer(20));
        BeverageEntity martini = EcomClientLourdAdmin.addBeverage(
                "Martini",
                new Float(25),
                new Integer(40),
                new Integer(100),
                new Integer(20));
        BeverageEntity citron_lime = EcomClientLourdAdmin.addBeverage(
                "Sirop de citron-lime - 1L",
                new Float(5),
                new Integer(0),
                new Integer(100),
                new Integer(20));
        BeverageEntity coco = EcomClientLourdAdmin.addBeverage(
                "Sirop de coco - 1.5L",
                new Float(6),
                new Integer(0),
                new Integer(150),
                new Integer(20));
        BeverageEntity coffee = EcomClientLourdAdmin.addBeverage(
                "Sirop de café - 1L",
                new Float(5),
                new Integer(0),
                new Integer(100),
                new Integer(20));
        BeverageEntity cream = EcomClientLourdAdmin.addBeverage(
                "Crème - 0.5L",
                new Float(6),
                new Integer(0),
                new Integer(50),
                new Integer(20));
        BeverageEntity chocolate = EcomClientLourdAdmin.addBeverage(
                "Sirop de chocolat - 1.5L",
                new Float(8),
                new Integer(0),
                new Integer(150),
                new Integer(20));
        BeverageEntity lychee = EcomClientLourdAdmin.addBeverage(
                "Sirop lychee - 1.5L",
                new Float(10),
                new Integer(0),
                new Integer(150),
                new Integer(20));
        BeverageEntity soda = EcomClientLourdAdmin.addBeverage(
                "Soda - 2L",
                new Float(3),
                new Integer(0),
                new Integer(200),
                new Integer(20));
        BeverageEntity sirop_fraise = EcomClientLourdAdmin.addBeverage(
                "Sirop de fraise - 1L",
                new Float(5),
                new Integer(0),
                new Integer(100),
                new Integer(20));
        BeverageEntity ananas = EcomClientLourdAdmin.addBeverage(
                "Jus d'ananas - 1L",
                new Float(5),
                new Integer(0),
                new Integer(100),
                new Integer(20));
        BeverageEntity cocomilk = EcomClientLourdAdmin.addBeverage(
                "Lait du coco - 1L",
                new Float(6),
                new Integer(0),
                new Integer(100),
                new Integer(20));
        BeverageEntity sirop_mentre = EcomClientLourdAdmin.addBeverage(
                "Sirop de mentre - 1L",
                new Float(4),
                new Integer(0),
                new Integer(100),
                new Integer(20));
        BeverageEntity banana = EcomClientLourdAdmin.addBeverage(
                "Jus de banana - 1.5L",
                new Float(5),
                new Integer(0),
                new Integer(150),
                new Integer(20));

        DecorationEntity ombrelle = EcomClientLourdAdmin.addDecoration(
                "Ombrelle",
                new Float(3),
                new Integer(100));
        DecorationEntity citron = EcomClientLourdAdmin.addDecoration(
                "Citron",
                new Float(5),
                new Integer(10));
        DecorationEntity pamplemousse = EcomClientLourdAdmin.addDecoration(
                "Pamplemousse",
                new Float(7),
                new Integer(10));
        DecorationEntity myrtille = EcomClientLourdAdmin.addDecoration(
                "Mytyille",
                new Float(2),
                new Integer(15));
        DecorationEntity mentre = EcomClientLourdAdmin.addDecoration(
                "Mentre",
                new Float(2),
                new Integer(30));
        DecorationEntity cerise = EcomClientLourdAdmin.addDecoration(
                "Cerise",
                new Float(2),
                new Integer(30));
        DecorationEntity fraise = EcomClientLourdAdmin.addDecoration(
                "Fraise",
                new Float(2),
                new Integer(30));
        DecorationEntity chili = EcomClientLourdAdmin.addDecoration(
                "Chili",
                new Float(3),
                new Integer(100));
        DecorationEntity paille = EcomClientLourdAdmin.addDecoration(
                "Paille",
                new Float(1),
                new Integer(100));
        DecorationEntity old_fashioned_glasse = EcomClientLourdAdmin.addDecoration(
                "Old fashioned glasse",
                new Float(10),
                new Integer(30));
        DecorationEntity martini_glasse = EcomClientLourdAdmin.addDecoration(
                "Martini glasse",
                new Float(10),
                new Integer(30));
        

        /*Adding cocktails*/
        List<Deliverable> deliverables = new ArrayList<>();
        deliverables.add(coca);
        deliverables.add(orange);
        deliverables.add(ombrelle);
        deliverables.add(mentre);
        EcomClientLourdAdmin.addCocktail(
                "Coca Orange",
                "Trop dégueulasse pour avoir une recette."
                + "Fait bien comme tu le sens, avec beaucoup de glaçons !",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.SOFT,
                "coca_orange.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(martini);
        deliverables.add(citron_lime);
        EcomClientLourdAdmin.addCocktail(
                "Sake martini",
                "1. Combine the dry gin, sake and ginger slice in a shaker filled with ice cubes.\n"
                + "\n"
                + "2. Shake vigorously for 8 to 10 seconds.\n"
                + "\n"
                + "3. Strain into a highball glass using an ice strainer with lemon lime.\n"
                + "\n"
                + "4. Garnish with an olive on a pick.",
                CocktailFlavorEnum.BITTER,
                CocktailPowerEnum.STRONG,
                "sake_martini.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(orange);
        deliverables.add(citron_lime);
        deliverables.add(martini_glasse);
        deliverables.add(citron);
        EcomClientLourdAdmin.addCocktail(
                "Rise sun",
                "1. Combine all, sake and ginger slice in a shaker filled with ice cubes.\n"
                + "\n"
                + "2. Shake vigorously for 8 to 10 seconds.\n"
                + "\n"
                + "3. Strain into a highball glass using an ice strainer with lemon lime.\n"
                + "\n"
                + "4. Garnish with an orange or lemon on a pick.",
                CocktailFlavorEnum.BITTER,
                CocktailPowerEnum.SOFT,
                "rise_sun.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(vodka);
        deliverables.add(chocolate);
        deliverables.add(cream);
        deliverables.add(coffee);
        deliverables.add(martini_glasse);
        EcomClientLourdAdmin.addCocktail(
                "The Irishman",
                "1. Combine the Irish cream liqueur, vodka, chilled coffee and cream in a pitcher and add the ice cubes.\n"
                + "\n"
                + "2. Stir with a mixing spoon.\n"
                + "\n"
                + "3. Serve in martini glasses and garnish with the chocolate shavings.",
                CocktailFlavorEnum.BITTER,
                CocktailPowerEnum.MEDIUM,
                "l_irlandais.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(rum);
        deliverables.add(chocolate);
        deliverables.add(orange);
        deliverables.add(old_fashioned_glasse);
        EcomClientLourdAdmin.addCocktail(
                "Downhill",
                "1. In a old-fashioned glass containing a few ices cubes, pour the rum and pomegranate juice.\n"
                + "\n"
                + "2. Top up with the beer, to get a good head of foam.\n"
                + "\n"
                + "3. Garnish with an orange twist.",
                CocktailFlavorEnum.BITTER,
                CocktailPowerEnum.MEDIUM,
                "descente.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(citron);
        deliverables.add(orange);
        deliverables.add(chili);
        deliverables.add(citron_lime);
        deliverables.add(old_fashioned_glasse);
        EcomClientLourdAdmin.addCocktail(
                "Punch-Chihuahua",
                "1. Combine all the ingredients in a punch bowl.\n"
                + "\n"
                + "2. Stir with a mixing spoon.\n"
                + "\n"
                + "3. Serve in old-fashioned glasses containing a few ice cubes and some fruit from the bowl.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.SOFT,
                "chiwawa_punch.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(citron_lime);
        deliverables.add(rum);
        deliverables.add(chili);
        EcomClientLourdAdmin.addCocktail(
                "Zombie",
                "1. Combine ingredients and ice cubes in a shaker.\n"
                + "\n"
                + "2. Shake vigorously for 8 to 10 seconds.\n"
                + "\n"
                + "3. Strain into a highball glass using an ice strainer.",
                CocktailFlavorEnum.BITTER,
                CocktailPowerEnum.STRONG,
                "zombie.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(vodka);
        deliverables.add(citron_lime);
        deliverables.add(soda);
        EcomClientLourdAdmin.addCocktail(
                "French kiss",
                "1. Combine the citrus liqueur and vodka in a shaker filled with ice.\n"
                + "\n"
                + "2. Shake vigorously for 8 to 10 seconds.\n"
                + "\n"
                + "3. Top up with club soda.",
                CocktailFlavorEnum.BITTER,
                CocktailPowerEnum.MEDIUM,
                "french_kiss.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(sirop_mentre);
        deliverables.add(cocomilk);
        deliverables.add(cream);
        deliverables.add(citron_lime);
        EcomClientLourdAdmin.addCocktail(
                "Slushy",
                "1. Combine the dry gin, sake and ginger slicCombine all the ingredients, except for the grapefruit slice, in a blender filled with ice cubes.\n"
                + "\n"
                + "2. Blend until smooth.\n"
                + "\n"
                + "3. Pour into a highball glass.\n"
                + "\n"
                + "4. Ganish with a grapefruit slice.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.SOFT,
                "tornade_caraibes.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(sirop_fraise);
        deliverables.add(cocomilk);
        deliverables.add(cream);
        deliverables.add(fraise);
        EcomClientLourdAdmin.addCocktail(
                "Cherry_blossom",
                "1.  Combine the Irish cream liqueur, almond liqueur and chocolate milk in a shaker filled with ice cubes.\n"
                + "\n"
                + "2. Blend until smooth.\n"
                + "\n"
                + "3. Add the grenadine.\n"
                + "\n"
                + "4. Ganish with a fruit slice.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.SOFT,
                "cherry_blossom.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(cocomilk);
        deliverables.add(cream);
        deliverables.add(chocolate);
        EcomClientLourdAdmin.addCocktail(
                "Don Pedro Africain",
                "1. Combine all the ingredients in a shaker.\n"
                + "\n"
                + "2. Shake vigorously for 8 to 10 seconds.\n"
                + "\n"
                + "3. Strain into a highball glass.\n"
                + "\n"
                + "4. Garnish with chocolate syrup.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.SOFT,
                "don_pedro_africain.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(gin);
        deliverables.add(grenade);
        deliverables.add(myrtille);
        EcomClientLourdAdmin.addCocktail(
                "Mistassini",
                "1. Crush 7 blueberries in a shaker using a muddler.\n"
                + "\n"
                + "2. Fill shaker with ice.\n"
                + "\n"
                + "3. Pour in the dry gin, pomegranate juice and cane syrup.\n"
                + "\n"
                + "4. Shake vigorously for 8 to 10 seconds.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.SOFT,
                "911.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(banana);
        deliverables.add(cream);
        deliverables.add(sirop_fraise);
        EcomClientLourdAdmin.addCocktail(
                "Hakuna Banana",
                "1.  Pour the banana liqueur and maraschino-cherry syrup in a highball glass containing one ice cube.\n"
                + "\n"
                + "2. Stir using a mixing spoon.\n"
                + "\n"
                + "3. Put aside.\n"
                + "\n"
                + "4. Shake vigorously for 8 to 10 seconds.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.SOFT,
                "hakuna_banana.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(brandy);
        deliverables.add(citron_lime);
        deliverables.add(mentre);
        EcomClientLourdAdmin.addCocktail(
                "Amarante",
                "1. Combine the armagnac and lime cordial in a highball glass containing a few mint leaves.\n"
                + "\n"
                + "2. Using a muddler, gently press the mint leaves to release their flavour.\n"
                + "\n"
                + "3. Add the ice cubes.\n"
                + "\n"
                + "4. Garnish with a mint sprig.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.MEDIUM,
                "amarante.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(sirop_mentre);
        deliverables.add(citron_lime);
        deliverables.add(mentre);
        EcomClientLourdAdmin.addCocktail(
                "Ungarita",
                "1. Combine all of the thing.\n"
                + "\n"
                + "2. Using a muddler, gently press the mint leaves to release their flavour.\n"
                + "\n"
                + "3. Add the ice cubes.\n"
                + "\n"
                + "4. Garnish with a mint sprig.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.SOFT,
                "sungarita.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(vodka);
        deliverables.add(citron_lime);
        deliverables.add(orange);
        deliverables.add(old_fashioned_glasse);
        EcomClientLourdAdmin.addCocktail(
                "Uppercut",
                "1. Combine all of the thing.\n"
                + "\n"
                + "2. Pour orange juice into an old-fashioned glass.\n"
                + "\n"
                + "3. Place the shot glass inside the old-fashioned glass.\n"
                + "\n"
                + "4. Drink all at once.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.STRONG,
                "Uppercut.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(gin);
        deliverables.add(sirop_fraise);
        deliverables.add(mentre);
        EcomClientLourdAdmin.addCocktail(
                "Heaven 77th",
                "1. Combine all the ingredients, except for the sprig of mint, in a shaker ﬁlled with ice cubes.\n"
                + "\n"
                + "2. Shake vigorously for 8 to 10 seconds.\n"
                + "\n"
                + "3. Strain into a wine glass using an ice strainer.\n"
                + "\n"
                + "4. Garnish with the sprig of mint.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.STRONG,
                "77e_ciel.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(tequila);
        deliverables.add(soda);
        deliverables.add(citron_lime);
        deliverables.add(lychee);
        EcomClientLourdAdmin.addCocktail(
                "Litchi Delight",
                "1. Fill a pitcher half full with ice cubes.\n"
                + "\n"
                + "2. Add the fruit.\n"
                + "\n"
                + "3. Mix all the ingredients except for the granulated sugar.\n"
                + "\n"
                + "4. Frost the rim of five margarita glasses with granulated sugar.\n"
                + "\n"
                + "5. Pour into the margarita glasses.\n"
                + "\n"
                + "6. Garnish each glass with a star fruit slice and lychee.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.STRONG,
                "fantaisies_litchi.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(whisky);
        deliverables.add(orange);
        deliverables.add(cerise);
        deliverables.add(old_fashioned_glasse);
        EcomClientLourdAdmin.addCocktail(
                "Old fashioned",
                "1. Combine the sugar cube, Angostura bitters, orange wedge and lemon zest in an old-fashioned glass, and crush with a muddler.\n"
                + "\n"
                + "2. Add some ice cubes.\n"
                + "\n"
                + "3. Add the whiskey.\n"
                + "\n"
                + "4. Stir with a mixing spoon.\n"
                + "\n"
                + "5. Garnish with maraschino cherries.",
                CocktailFlavorEnum.BITTER,
                CocktailPowerEnum.STRONG,
                "Old_fashioned.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(gin);
        deliverables.add(mentre);
        deliverables.add(citron_lime);
        EcomClientLourdAdmin.addCocktail(
                "Jynx",
                "1.  Combine the dry gin, vodka and pineapple juice in a highball glass containing a few ice cubes.\n"
                + "\n"
                + "2. Add pepper.\n"
                + "\n"
                + "3. Stir using a mixing spoon.\n"
                + "\n"
                + "4. Gently pour the grenadine syrup over the back of a spoon to create a layered cocktail.\n"
                + "\n"
                + "5. Garnish with a pineapple slice and a raspberry on a cocktail pick.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.STRONG,
                "jynx.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(pamplemousse);
        deliverables.add(citron_lime);
        deliverables.add(sirop_mentre);
        EcomClientLourdAdmin.addCocktail(
                "Grapefruit Margarita",
                "1. Frost the rim of a margarita glass using water and salt.\n"
                + "\n"
                + "2. Combine all the ingredients, except for the grapefruit wedge, in a blender.\n"
                + "\n"
                + "3. Blend until smooth.\n"
                + "\n"
                + "4. Pour into a margarita glass.\n"
                + "\n"
                + "5. Garnish with a grapefruit wedge.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.SOFT,
                "margarita_pamplemousse.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(coco);
        deliverables.add(orange);
        deliverables.add(cerise);
        EcomClientLourdAdmin.addCocktail(
                "Africa colada",
                "1. Combine the sugar cube, Angostura bitters, orange wedge and lemon zest in an old-fashioned glass, and crush with a muddler.\n"
                + "\n"
                + "2. Add some ice cubes.\n"
                + "\n"
                + "3. Add 25 ml (3/4 oz.) coconut cream.\n"
                + "\n"
                + "4. Stir with a mixing spoon.\n"
                + "\n"
                + "5. Garnish with maraschino cherries.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.SOFT,
                "africa_colada.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(coffee);
        deliverables.add(coco);
        deliverables.add(cream);
        deliverables.add(chocolate);
        EcomClientLourdAdmin.addCocktail(
                "Café surprise",
                "1. Add 250 ml (8 oz.) hot strong filter coffee.\n"
                + "\n"
                + "2. Add some ice cubes.\n"
                + "\n"
                + "3. Add 30 ml (1 oz.) whipped cream.\n"
                + "\n"
                + "4. Add 10 small or 2 coco.\n"
                + "\n"
                + "5. Hot chocolate mix or cocoa powder.",
                CocktailFlavorEnum.BITTER,
                CocktailPowerEnum.STRONG,
                "cafe_surprise.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(vodka);
        deliverables.add(citron);
        deliverables.add(citron_lime);
        EcomClientLourdAdmin.addCocktail(
                "Blue Lagoon",
                "1. Combine all ingredients in a highball glass containing a few ice cubes, except for the lemon slice.\n"
                + "\n"
                + "2. Stir using a mixing spoon.\n"
                + "\n"
                + "3.  Garnish with a lemon slice.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.STRONG,
                "blue_lagoon.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(coffee);
        deliverables.add(whisky);
        deliverables.add(cream);
        EcomClientLourdAdmin.addCocktail(
                "Almond Coffee",
                "1. Frost the rim of a toddy glass with sugar.\n"
                + "\n"
                + "2. Combine the Canadian whisky and almond liqueur in the toddy glass.\n"
                + "\n"
                + "3.  Top up with hot coffee.\n"
                + "\n"
                + "4. Stir using a mixing spoon.\n"
                + "\n"
                + "5. Garnish with whipped cream and slivered almonds.",
                CocktailFlavorEnum.BITTER,
                CocktailPowerEnum.SOFT,
                "cafe_amandine.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(cream);
        deliverables.add(sirop_fraise);
        deliverables.add(fraise);
        deliverables.add(chocolate);
        EcomClientLourdAdmin.addCocktail(
                "Choco-passion",
                "1. Rim a toddy glass with the melted chocolate.\n"
                + "\n"
                + "2. Pour in the hot chocolate.\n"
                + "\n"
                + "3. Add the strawberry cream liqueur.\n"
                + "\n"
                + "4. Stir using a mixing spoon.\n"
                + "\n"
                + "5. Garnish with the whipped cream and strawberry.",
                CocktailFlavorEnum.BITTER,
                CocktailPowerEnum.SOFT,
                "choco_passion.png",
                deliverables);
        
        deliverables.clear();
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
