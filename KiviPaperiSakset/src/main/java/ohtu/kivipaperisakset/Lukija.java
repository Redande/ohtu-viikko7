package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Lukija {
    Scanner scanner;
    
    public Lukija() {
        this.scanner = new Scanner(System.in);
    }
    
    public String lueSyote() {
        return scanner.nextLine();
    }
    
    public void tulosta(Object tulostettava) {
        System.out.println(tulostettava);
    }
    
    public void tyhjaRivi() {
        System.out.println("");
    }
}
