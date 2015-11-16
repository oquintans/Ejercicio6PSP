/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6psp;

/**
 *
 * @author oquintansocampo
 */
public class Ejercicio6PSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConPro p = new ConPro("Productor");
        ConPro c = new ConPro("Consumidor");

        p.start();
        c.start();
    }

}
