package com.mycompany.test_java;

import java.util.Scanner;

public class Cetverokut {

    // podatkovni članovi
    private final double stranicaA;
    private final double stranicaB;

    // konstruktori
    public Cetverokut(double a, double b) { // konstruktor za pravokutnik
        this.stranicaA = a;
        this.stranicaB = b;
    }

    public Cetverokut(double a) { // konstruktor za kvadrat
        this.stranicaA = a;
        this.stranicaB = a;
    }

    public Cetverokut() {
        try (Scanner skener = new Scanner(System.in)) {
            System.out.println("Dobar dan!");
            System.out.println("Koji geometrijski lik želite definirati?");
            System.out.println("1. Kvadrat");
            System.out.println("2. Pravokutnik");
            int izbor = skener.nextInt();
            
            switch (izbor) {
                case 1 -> {
                    System.out.print("Unesite stranicu kvadrata: ");
                    double a = skener.nextDouble();
                    this.stranicaA = this.stranicaB = a;
                }
                case 2 -> {
                    System.out.print("Unesite prvu stranicu: ");
                    double a = skener.nextDouble();
                    System.out.print("Unesite drugu stranicu: ");
                    double b = skener.nextDouble();
                    this.stranicaA = a;
                    this.stranicaB = b;
                }
                default -> {
                    System.out.println("Na žalost, ovaj izbor ne postoji!");
                    System.out.println("Doviđenja!");
                    this.stranicaA = this.stranicaB = 0; // TODO pozabavi se time kasnije
                }
            }
        }
    }

    // metode (ponašanje)
    public double povrsina() {
        return this.stranicaA * this.stranicaB;
    }

    public double opseg() {
        return (2 * this.stranicaA) + (2 * this.stranicaB);
    }

}
