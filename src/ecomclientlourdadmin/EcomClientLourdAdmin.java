/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ecomclientlourdadmin;

import entity.BeverageEntity;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import session.interfaces.AdminFacadeRemoteItf;

/**
 *
 * @author yann
 */
public class EcomClientLourdAdmin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("jndi.properties"));
            InitialContext ctx = new InitialContext(props);
            AdminFacadeRemoteItf beverageFacade = (AdminFacadeRemoteItf) ctx.lookup("java:global/Ecom/Ecom-ejb/AdminFacadeBean!session.interfaces.AdminFacadeRemoteItf");
            System.out.println("message = " + beverageFacade.toString());
            BeverageEntity b = new BeverageEntity();
            b.setAlcoholicDegree(99);
            b.setName("Gnole de bach");
            b.setPrice(new Float(1));
            b.setCapacity(1000000);
            beverageFacade.addBeverage(b);
            List<BeverageEntity> list = beverageFacade.getAllBeverages();
            for (BeverageEntity dr : list) {
                System.out.println(dr.getName() + " : \n Degré d'alcool : " + dr.getAlcoholicDegree() + " \n Prix : " + dr.getPrice() + "€");
            }
        } catch (IOException ex) {
            Logger.getLogger(EcomClientLourdAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(EcomClientLourdAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
