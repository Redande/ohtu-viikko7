package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Lukija lukija = new Lukija();

    public static void main(String[] args) {

        while (true) {
            vaihtoehdot();

            String vastaus = lukija.lueSyote();
            if (vastaus.endsWith("a")) {
                ohjeet();
                KPSPeli kaksinpeli = KPSPeli.luoKPSPelaajaVsPelaaja(lukija);
                kaksinpeli.pelaa();
            } else if (vastaus.endsWith("b")) {
                ohjeet();
                KPSPeli yksinpeli = KPSPeli.luoKPSTekoaly(lukija);
                yksinpeli.pelaa();
            } else if (vastaus.endsWith("c")) {
                ohjeet();
                KPSPeli pahaYksinpeli = KPSPeli.luoKPSParempiTekoaly(lukija);
                pahaYksinpeli.pelaa();
            } else {
                break;
            }

        }

    }
    
    private static void vaihtoehdot() {
        lukija.tulosta("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");
    }
    
    private static void ohjeet() {
        lukija.tulosta("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
    }
}
