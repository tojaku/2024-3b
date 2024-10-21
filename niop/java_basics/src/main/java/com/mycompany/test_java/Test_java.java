package com.mycompany.test_java;

import java.util.Random;
import javax.swing.JOptionPane;

public class Test_java {

    public static void main(String[] args) {
        /*String ime = JOptionPane.showInputDialog("Unesite svoje ime");
        System.out.println("Dobar dan, " + ime);*/
        
        //*String broj = JOptionPane.showInputDialog("Unesite jedan broj");
        //int praviBroj = Integer.parseInt(broj);
        /*double praviBroj = Double.parseDouble(broj);
        System.out.println("Vaš broj + 10, " + (praviBroj + 10));*/
        
        /*for(int i = 1; i <= 31; i++) {
            System.out.println(i + ". siječanj 2024.");
        }*/
        
        Random generator = new Random();
        int zamisljeniBroj = generator.nextInt(10) + 1;
        
        int pogodjeniBroj = Integer.parseInt(JOptionPane.showInputDialog("Unesite broj"));
        while (pogodjeniBroj != zamisljeniBroj) {
            System.out.println("Niste pogodili, pokušajte ponovno!");
            pogodjeniBroj = Integer.parseInt(JOptionPane.showInputDialog("Unesite broj"));
        }
        System.out.println("Bravo! Pogodili ste broj!");
        
        
        
        /*int povratnaVrijednost = JOptionPane.showConfirmDialog(null, "Potvrdi me");
        System.out.println("Povratna vrijednost: " + povratnaVrijednost);
        if (povratnaVrijednost == 0) {
            System.out.println("Yey");
        } else if (povratnaVrijednost == 1) {
            System.out.println("Booo");
        } else {
            System.out.println("Pokušajte ponovno");
        }*/

        /*Cetverokut pero = new Cetverokut(); // pero je objekt klase Cetverokut, tj. instanca klase Cetverokut
        System.out.println("Površina je " + String.format("%.2f", pero.povrsina()));
        System.out.println("Opseg je " + String.format("%.2f", pero.opseg()));*/
    }
}
