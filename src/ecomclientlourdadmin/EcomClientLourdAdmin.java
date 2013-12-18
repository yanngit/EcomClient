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
                "Coca-Cola",
                new Float(3),
                new Integer(0),
                new Integer(200),
                new Integer(20));
        BeverageEntity orange = EcomClientLourdAdmin.addBeverage(
                "Jus d'orange",
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
                "Jus de grenade",
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
                "Sirop de citron-lime",
                new Float(5),
                new Integer(0),
                new Integer(100),
                new Integer(20));
        BeverageEntity coco = EcomClientLourdAdmin.addBeverage(
                "Sirop de coco",
                new Float(6),
                new Integer(0),
                new Integer(150),
                new Integer(20));
        BeverageEntity coffee = EcomClientLourdAdmin.addBeverage(
                "Sirop de café",
                new Float(5),
                new Integer(0),
                new Integer(100),
                new Integer(20));
        BeverageEntity cream = EcomClientLourdAdmin.addBeverage(
                "Crème",
                new Float(6),
                new Integer(0),
                new Integer(50),
                new Integer(20));
        BeverageEntity chocolate = EcomClientLourdAdmin.addBeverage(
                "Sirop de chocolat",
                new Float(8),
                new Integer(0),
                new Integer(150),
                new Integer(20));
        BeverageEntity lychee = EcomClientLourdAdmin.addBeverage(
                "Jus de litchi",
                new Float(10),
                new Integer(0),
                new Integer(150),
                new Integer(20));
        BeverageEntity soda = EcomClientLourdAdmin.addBeverage(
                "Soda",
                new Float(3),
                new Integer(0),
                new Integer(200),
                new Integer(20));
        BeverageEntity limonade = EcomClientLourdAdmin.addBeverage(
                "Limonade",
                new Float(3),
                new Integer(0),
                new Integer(150),
                new Integer(20));
        BeverageEntity icetea = EcomClientLourdAdmin.addBeverage(
                "Thé glacé",
                new Float(3),
                new Integer(0),
                new Integer(150),
                new Integer(20));
        BeverageEntity sirop_fraise = EcomClientLourdAdmin.addBeverage(
                "Sirop de fraise",
                new Float(5),
                new Integer(0),
                new Integer(100),
                new Integer(20));
        BeverageEntity ananas = EcomClientLourdAdmin.addBeverage(
                "Jus d'ananas",
                new Float(5),
                new Integer(0),
                new Integer(100),
                new Integer(20));
        BeverageEntity cocomilk = EcomClientLourdAdmin.addBeverage(
                "Lait de coco",
                new Float(6),
                new Integer(0),
                new Integer(100),
                new Integer(20));
        BeverageEntity sirop_menthe = EcomClientLourdAdmin.addBeverage(
                "Sirop de menthe",
                new Float(4),
                new Integer(0),
                new Integer(100),
                new Integer(20));
        BeverageEntity banane = EcomClientLourdAdmin.addBeverage(
                "Jus de banane",
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
        DecorationEntity menthe = EcomClientLourdAdmin.addDecoration(
                "Menthe",
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
                "Verre Old fashioned",
                new Float(10),
                new Integer(30));
        DecorationEntity martini_glasse = EcomClientLourdAdmin.addDecoration(
                "Verre à martini",
                new Float(10),
                new Integer(30));
        DecorationEntity margarita_glasse = EcomClientLourdAdmin.addDecoration(
                "Verre à margarita",
                new Float(8),
                new Integer(30));  
        DecorationEntity shooter_glasse = EcomClientLourdAdmin.addDecoration(
                "Verre à shooter",
                new Float(4),
                new Integer(30));  
        DecorationEntity toddy_glasse = EcomClientLourdAdmin.addDecoration(
                "Verre toddy",
                new Float(4),
                new Integer(30));  
        DecorationEntity creme_fouettee = EcomClientLourdAdmin.addDecoration(
                "Crème fouettée",
                new Float(5),
                new Integer(20));
        

        /*Adding cocktails*/
        List<Deliverable> deliverables = new ArrayList<>();
        deliverables.add(martini);
        deliverables.add(martini_glasse);
        EcomClientLourdAdmin.addCocktail(
                "Martini saké",
                "1. Dans un shaker rempli de glaçons, ajouter le martini, le saké, et la tranche de gingembre.\n"
                + "\n"
                + "2. Agiter vivement de 8 à 10 secondes.\n"
                + "\n"
                + "3. Filtrer le contenu du shaker dans un à verre à martini, à l’aide d’une passoire à glaçons.\n"
                + "\n"
                + "4. Garnir d’une olive sur une pique.",
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
                "Sunrise",
                "1. Dans un shaker rempli de glaçons, verser le jus d’orange.\n"
                + "\n"
                + "2. Agiter vivement de 8 à 10 secondes.\n"
                + "\n"
                + "3. Filtrer le contenu du shaker dans un verre highball contenant quelques glaçons à l’aide d’une passoire à glaçons.\n"
                + "\n"
                + "4. Verser le sirop de citron-lime.",
                CocktailFlavorEnum.FRUITY,
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
                "L'Irlandais",
                "1. Dans un grand pichet contenant des glaçons, verser la vodka, le café refroidi et la crème.\n"
                + "\n"
                + "2. Remuer à l’aide d’une cuillère à mélange.\n"
                + "\n"
                + "3. Verser dans des verres à martini et garnir de copeaux de chocolat.",
                CocktailFlavorEnum.BITTER,
                CocktailPowerEnum.MEDIUM,
                "l_irlandais.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(rum);
        deliverables.add(chocolate);
        deliverables.add(grenade);
        deliverables.add(old_fashioned_glasse);
        EcomClientLourdAdmin.addCocktail(
                "Descente",
                "1. Dans un verre old-fashioned contenant quelques glaçons, verser le rhum et le jus de grenade.\n"
                + "\n"
                + "2. Allonger avec du chocolat.\n"
                + "\n"
                + "3. Garnir d’un zeste d’orange.",
                CocktailFlavorEnum.BITTER,
                CocktailPowerEnum.MEDIUM,
                "descente.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(citron);
        deliverables.add(orange);
        deliverables.add(citron_lime);
        deliverables.add(old_fashioned_glasse);
        EcomClientLourdAdmin.addCocktail(
                "Chiwawa Punch",
                "1. Dans un bol à punch, verser tous les ingrédients.\n"
                + "\n"
                + "2. Remuer à l’aide d’une cuillère à mélange.\n"
                + "\n"
                + "3. Servir dans des verres old-fashioned contenant quelques glaçons.",
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
                "1. Dans un shaker, verser tous les ingrédients sur des glaçons.\n"
                + "\n"
                + "2. Agiter vivement pendant 8 à 10 secondes.\n"
                + "\n"
                + "3.  Filtrer au-dessus d'un verre à l’aide d’une passoire à glaçons.",
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
                "1. Dans un shaker rempli de glaçons, verser la vodka et du sirop de citron-lime.\n"
                + "\n"
                + "2. Agiter vivement pendant 8 à 10 secondes..\n"
                + "\n"
                + "3. Allonger avec le soda club.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.MEDIUM,
                "french_kiss.png",
                deliverables);
       
        deliverables.clear();
        deliverables.add(grenade);
        deliverables.add(cocomilk);
        deliverables.add(cream);
        deliverables.add(cerise);
        deliverables.add(martini_glasse);
        EcomClientLourdAdmin.addCocktail(
                "Cherry_blossom",
                "1. Dans un shaker rempli de glaçons, verser la boisson à la crème, la liqueur de grenade et le lait au chocolat.\n"
                + "\n"
                + "2. Agiter vivement de 8 à 10 secondes.\n"
                + "\n"
                + "3. Filtrer le contenu du shaker dans un verre à martini à l'aide d'une passoire à glaçons.\n"
                + "\n"
                + "4. Garnir de cerises sur une pique.",
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
                "1. Dans un shaker, ajouter tous les ingrédients.\n"
                + "\n"
                + "2. Agiter vivement de 8 à 10 secondes.\n"
                + "\n"
                + "3. Verser le contenu du shaker dans un verre highball.\n"
                + "\n"
                + "4. Garnir d’un filet de chocolat.",
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
                "1. Dans un shaker, ajouter 7 bleuets et les écraser avec un pilon.\n"
                + "\n"
                + "2. Remplir le shaker de glaçons.\n"
                + "\n"
                + "3. Verser le dry gin, le jus de grenade et le sirop de myrtille.\n"
                + "\n"
                + "4. Agiter vivement pendant 8 à 10 secondes.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.SOFT,
                "911.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(banane);
        deliverables.add(cream);
        deliverables.add(sirop_fraise);
        EcomClientLourdAdmin.addCocktail(
                "Hakuna Banana",
                "1. Dans un shaker, ajouter tous les ingrédients.\n"
                + "\n"
                + "2. Secouer énergiquement pendant 8 à 10 secondes.\n"
                + "\n"
                + "3. Verser le contenu du shaker dans un verre.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.SOFT,
                "hakuna_banana.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(brandy);
        deliverables.add(citron_lime);
        deliverables.add(menthe);
        EcomClientLourdAdmin.addCocktail(
                "Amarante",
                "1. Dans un verre highball contenant quelques feuilles de menthe, verser le brandy et le cordial à la lime.\n"
                + "\n"
                + "2. À l’aide d’un pilon, écraser la menthe pour laisser s’échapper son parfum.\n"
                + "\n"
                + "3. Ajouter les glaçons.\n"
                + "\n"
                + "4. Allonger avec le soda.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.MEDIUM,
                "amarante.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(sirop_menthe);
        deliverables.add(citron_lime);
        deliverables.add(menthe);
        deliverables.add(citron);
        deliverables.add(margarita_glasse);
        EcomClientLourdAdmin.addCocktail(
                "Ungarita",
                "1. Dans un pichet, mélanger tous les ingrédients, sauf les demi-rondelles de citron..\n"
                + "\n"
                + "2. Remuer à l’aide d’une cuillère à mélange.\n"
                + "\n"
                + "3. Verser dans des verres à margarita.\n"
                + "\n"
                + "4. Garnir chaque verre d’une demi-rondelle de citron.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.SOFT,
                "sungarita.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(vodka);
        deliverables.add(citron_lime);
        deliverables.add(orange);
        deliverables.add(old_fashioned_glasse);
        deliverables.add(shooter_glasse);
        EcomClientLourdAdmin.addCocktail(
                "Uppercut",
                "1. Dans un verre à shooter, verser du sirop de citron-lime et la vodka.\n"
                + "\n"
                + "2. Dans un verre old-fashioned, verser le jus d’orange.\n"
                + "\n"
                + "3. Déposer le verre à shooter dans le verre old-fashioned.\n"
                + "\n"
                + "4. Boire d’un trait.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.STRONG,
                "Uppercut.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(gin);
        deliverables.add(sirop_fraise);
        deliverables.add(menthe);
        EcomClientLourdAdmin.addCocktail(
                "Heaven 77th",
                "1. Dans un shaker rempli de glaçons, ajouter tous les ingrédients, sauf le brin de menthe.\n"
                + "\n"
                + "2. Agiter vivement de 8 à 10 secondes.\n"
                + "\n"
                + "3. Filtrer le contenu du shaker dans un verre à vin à l’aide d’une passoire à glaçons.\n"
                + "\n"
                + "4. Garnir d’un brin de menthe.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.STRONG,
                "77e_ciel.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(tequila);
        deliverables.add(soda);
        deliverables.add(citron_lime);
        deliverables.add(lychee);
        deliverables.add(margarita_glasse);
        EcomClientLourdAdmin.addCocktail(
                "Fantaisies litchi",
                "1. Dans un pichet, déposer des glaçons jusqu'à la moitié de sa hauteur.\n"
                + "\n"
                + "2. Ajouter les fruits.\n"
                + "\n"
                + "3. Mélanger tous les ingrédients sauf le sucre granulé.\n"
                + "\n"
                + "4. Givrer le rebord de cinq verres à margarita avec le sucre granulé.\n"
                + "\n"
                + "5. Verser dans les verres à margarita.\n"
                + "\n"
                + "6. Garnir chaque verre d'une tranche de carambole ou d'un litchi.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.STRONG,
                "fantaisies_litchi.png",
                deliverables);        
        
        deliverables.clear();
        deliverables.add(gin);
        deliverables.add(vodka);
        deliverables.add(menthe);
        deliverables.add(ananas);
        deliverables.add(grenade);
        EcomClientLourdAdmin.addCocktail(
                "Jynx",
                "1. Dans un verre highball contenant quelques glaçons, verser le dry gin, la vodka et le jus d’ananas.\n"
                + "\n"
                + "2. Ajouter le poivre.\n"
                + "\n"
                + "3. Remuer à l’aide d’une cuillère à mélange.\n"
                + "\n"
                + "4. Verser lentement la grenadine sur le dos d’une cuillère pour créer un cocktail étagé.\n"
                + "\n"
                + "5. Garnir d’une tranche d’ananas sur une pique.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.STRONG,
                "jynx.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(citron_lime);
        deliverables.add(sirop_menthe);
        deliverables.add(pamplemousse);
        deliverables.add(margarita_glasse);
        EcomClientLourdAdmin.addCocktail(
                "Grapefruit Margarita",
                "1. Givrer le rebord d’un verre à margarita avec du sel.\n"
                + "\n"
                + "2. Dans un mélangeur électrique, déposer tous les ingrédients, sauf le quartier de pamplemousse.\n"
                + "\n"
                + "3. Mélanger jusqu’à ce que le contenu soit homogène.\n"
                + "\n"
                + "4. Verser le contenu du mélangeur dans un verre à margarita.\n"
                + "\n"
                + "5. Garnir d’un quartier de pamplemousse.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.SOFT,
                "margarita_pamplemousse.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(vodka);
        deliverables.add(citron_lime);
        deliverables.add(citron);
        EcomClientLourdAdmin.addCocktail(
                "Blue Lagoon",
                "1. Dans un verre highball contenant quelques glaçons, verser tous les ingrédients, sauf la rondelle de citron.\n"
                + "\n"
                + "2. Remuer à l'aide d’une cuillère à mélange.\n"
                + "\n"
                + "3. Garnir d'une rondelle de citron.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.STRONG,
                "blue_lagoon.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(coffee);
        deliverables.add(whisky);
        deliverables.add(creme_fouettee);
        deliverables.add(toddy_glasse);
        EcomClientLourdAdmin.addCocktail(
                "Almond Coffee",
                "1. Tremper le rebord d’un verre toddy dans du chocolat fondu.\n"
                + "\n"
                + "2. Dans le verre toddy, verser le whisky.\n"
                + "\n"
                + "3. Allonger avec du café.\n"
                + "\n"
                + "4. Remuer à l’aide d’une cuillère à mélange.\n"
                + "\n"
                + "5. Garnir de crème fouettée.",
                CocktailFlavorEnum.BITTER,
                CocktailPowerEnum.SOFT,
                "cafe_amandine.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(cream);
        deliverables.add(sirop_fraise);
        deliverables.add(fraise);
        deliverables.add(chocolate);
        deliverables.add(creme_fouettee);
        deliverables.add(toddy_glasse);
        EcomClientLourdAdmin.addCocktail(
                "Choco-passion",
                "1. Tremper le rebord d’un verre toddy dans du chocolat fondu.\n"
                + "\n"
                + "2. Verser le chocolat chaud.\n"
                + "\n"
                + "3. Ajouter la boisson à la crème et à la fraise.\n"
                + "\n"
                + "4. Remuer à l’aide d’une cuillère à mélange.\n"
                + "\n"
                + "5. Garnir de crème fouettée et d’une fraise.",
                CocktailFlavorEnum.BITTER,
                CocktailPowerEnum.SOFT,
                "choco_passion.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(whisky);
        deliverables.add(coca);
        CocktailEntity cocktail = EcomClientLourdAdmin.addCocktail(
                "Whisky Coca",
                "1. Dans un verre contenant quelques glaçons, verser tous les ingrédients.\n"
                + "\n"
                + "2. Remuer à l'aide d’une cuillère à mélange.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.SOFT,
                "whisky_coca.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(coffee);
        deliverables.add(coco);
        deliverables.add(cream);
        deliverables.add(chocolate);
        EcomClientLourdAdmin.addCocktail(
                "Café surprise",
                "1. Dans un shaker, ajouter tous les ingrédients.\n"
                + "\n"
                + "2. Secouer énergiquement pendant 8 à 10 secondes.\n"
                + "\n"
                + "3. Verser le contenu du shaker dans un verre.",
                CocktailFlavorEnum.BITTER,
                CocktailPowerEnum.SOFT,
                "cafe_surprise.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(whisky);
        deliverables.add(orange);
        deliverables.add(old_fashioned_glasse);
        EcomClientLourdAdmin.addCocktail(
                "Old fashioned",
                "1. Dans un verre old-fashioned, ajouter le cube de sucre, le jus d’orange, et écraser à l’aide d’un pilon.\n"
                + "\n"
                + "2. Ajouter quelques glaçons.\n"
                + "\n"
                + "3. Verser le whiskey.\n"
                + "\n"
                + "4. Remuer à l’aide d’une cuillère à mélange.\n"
                + "\n"
                + "5. Profitez-vous!",
                CocktailFlavorEnum.BITTER,
                CocktailPowerEnum.STRONG,
                "Old_fashioned.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(vodka);
        deliverables.add(coffee);
        EcomClientLourdAdmin.addCocktail(
                "Black russian",
                "1. Dans un verre contenant quelques glaçons, verser la vodka et la liqueur de café.\n"
                + "\n"
                + "2. Remuer à l'aide d'une cuillère à mélange.",
                CocktailFlavorEnum.BITTER,
                CocktailPowerEnum.STRONG,
                "black_russian.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(rum);
        deliverables.add(icetea);
        deliverables.add(limonade);
        EcomClientLourdAdmin.addCocktail(
                "Le thé du jardin",
                "1. Dans un verre highball contenant quelques glaçons, verser le rhum, le thé glacé et la limonade.\n"
                + "\n"
                + "2. Remuer à l'aide d'une cuillère à mélange.",
                CocktailFlavorEnum.BITTER,
                CocktailPowerEnum.SOFT,
                "the_jardin.png",
                deliverables);
        
        deliverables.clear();
        deliverables.add(coco);
        deliverables.add(orange);
        deliverables.add(ananas);
        EcomClientLourdAdmin.addCocktail(
                "Africa colada",
                "1. Givrer le rebord d’un verre highball avec de la cannelle.\n"
                + "\n"
                + "2. Dans un shaker rempli de glaçons, ajouter tous les ingrédients, sauf la tranche d’ananas.\n"
                + "\n"
                + "3. Agiter vivement de 8 à 10 secondes.\n"
                + "\n"
                + "4. Filtrer le contenu du shaker dans le verre contenant quelques glaçons à l’aide d’une passoire à glaçons.\n"
                + "\n"
                + "5. Garnir d’une tranche d’ananas.",
                CocktailFlavorEnum.FRUITY,
                CocktailPowerEnum.SOFT,
                "africa_colada.png",
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
        deliverables.add(soda);
        deliverables.add(menthe);
        EcomClientLourdAdmin.addCocktail(
                "Gin tonic",
                "1. Dans un verre contenant quelques glaçons, verser le gin.\n"
                + "\n"
                + "2. Allonger avec le soda tonique.\n"
                + "\n"
                + "3. Garnir de feuilles de menthe.",
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
