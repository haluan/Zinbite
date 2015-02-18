/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zinbite;

import EM.Manager;
import zinbite.View.Main;
import zinbite.model.Produk;

/**
 *
 * @author Haluan
 */
public class Zinbite {

    /**
     * @param args the command line arguments
     */
    public static Manager man;
    public static void main(String[] args) {
        // TODO code application logic here
        man = new Manager();
        Produk prod = new Produk();
        prod.setName("AKAMBING");
        man.persist(prod);
        for (Produk proda : man.getAllProduk()){
            System.out.println(""+proda.getName());
        }
        new Main().show();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                 man.save();
                 man.end();
            }
        }));
        
        
    }
    
}
