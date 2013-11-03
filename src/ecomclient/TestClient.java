/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ecomclient;

import entity.Drink;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import session.DrinkFacadeRemote;

/**
 *
 * @author yann
 */
public class TestClient {
    public static void main(String [] args){
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("jndi.properties"));
            InitialContext ctx = new InitialContext(props);
            DrinkFacadeRemote bean = (DrinkFacadeRemote)ctx.lookup("java:global/Ecom/Ecom-ejb/Drink!session.DrinkFacadeRemote");
            System.out.println("message = " + bean.toString());
            Drink d = new Drink();
            d.setDegre_alcool(40);
            d.setLibelle("Rhum");
            d.setPrix(23);
            d.setQuantite(5);
            bean.create(d);
            List<Drink> list = bean.findAllRemote();
            for(Drink dr : list){
                System.out.println(dr.getLibelle()+" : \n Degré d'alcool : "+dr.getDegre_alcool()+" \n Prix : "+dr.getPrix()+"€");
            }
        } catch (IOException ex) {
            Logger.getLogger(TestClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(TestClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
