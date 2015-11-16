/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6psp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oquintansocampo
 */
public class ConPro extends Thread {

    static int dinero = 0;
    String nombre;

    public ConPro(String nombre) {
        super(nombre);
        this.nombre = nombre;
    }

    synchronized void ingresar() {
        System.out.println(getName() + " Dinero: " + dinero);
        dinero++;
        System.out.println("Productor ingresó 1 unidad.");
        notify();
    }

    synchronized void extraer() {
        System.out.println(getName() + " Dinero: " + dinero);
        if (dinero <= 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(ConPro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        dinero--;
        System.out.println("Consumidor extrajo 1 unidad.");
    }

    @Override
    public void run() {

        if (nombre == "Consumidor") {
            for (int i = 0; i < 5; i++) {
                extraer();
            }
        }

        if (nombre == "Productor") {
            for (int i = 0; i < 10; i++) {
                ingresar();
            }
        }
    }
}
