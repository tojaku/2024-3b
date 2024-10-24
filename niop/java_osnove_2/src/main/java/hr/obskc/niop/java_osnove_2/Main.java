package hr.obskc.niop.java_osnove_2;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String test1 = "Dobar dan"; // hash: 823z9uzhfdio8aw4z5oihgfoa
        String test2 = new String("Dobar dan"); // hash: 823z9uzhfdio8aw4z5oihgfoa
        test2 = "Nije dobar dan";

        System.out.println("Dužina: " + test2.length());
        System.out.println("Traži: " + test2.indexOf("dan"));
        System.out.println("Traži: " + test2.charAt(6));
        System.out.println("Traži: " + test2.substring(11, 11 + 2));
        double slucajni = Math.random();
        System.out.println("Slučajni broj: " + slucajni);
        double slucajni2 = Math.round(slucajni * 100);
        System.out.println("Slučajni dvozn. broj: " + slucajni2);
        Scanner s = new Scanner(System.in);

        int suma = 0;
        int broj = s.nextInt();
        while (broj != -1) {
            suma += broj;
            broj = s.nextInt();
        }
        System.out.println("Rezultat: " + suma);
        int a = 1, b = 2, c = 3;
        boolean test3 = (c == a + b);
        System.out.println("Test3: " + test3);

        String sA = "a", sB = "b", sC = "AB";
        boolean test4 = (sC == sA + sB);
        System.out.println("Test4: " + test4);
        boolean test5 = (sC.equalsIgnoreCase(sA + sB));
        System.out.println("Test5: " + test5);
        int[] brojevi;

        brojevi = new int[20];
        brojevi[0] = 10;

        int brojevi2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println("Veličina niza 2: " + brojevi2.length);

        for (int i = 0; i < brojevi2.length; i++) {
            System.out.println("EL[" + i + "]: " + brojevi2[i]);
        }

        for (int br : brojevi2) {
            System.out.println("Broj: " + br);
        }
        
        ArrayList<String> rijeci = new ArrayList<String>();
        rijeci.add("Dobar");
        rijeci.add("dan");
        rijeci.add("pinokio");
        rijeci.add("svijete");
        System.out.println("Veličina: " + rijeci.size());
        System.out.println("Sadržaj: " + rijeci.toString());

        int indeksPinokia = rijeci.indexOf("pinokio");
        System.out.println("Traži: " + indeksPinokia);
        rijeci.remove(indeksPinokia);
        System.out.println("Sadržaj: " + rijeci.toString());
        rijeci.set(1, "večer");
        System.out.println("Sadržaj: " + rijeci.toString());

        for (String rijec : rijeci) {
            System.out.println("Riječ: " + rijec);
        }

        ListIterator<String> iterator = rijeci.listIterator();
        while (iterator.hasNext()) {
            System.out.println("Sljedeći: " + iterator.next());
        }

    }

}
