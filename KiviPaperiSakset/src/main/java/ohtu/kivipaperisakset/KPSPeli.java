package ohtu.kivipaperisakset;

public class KPSPeli {

    private Lukija lukija;
    private TekoalyRajapinta tekoaly;

    protected KPSPeli(Lukija lukija, TekoalyRajapinta tekoaly) {
        this.lukija = lukija;
        this.tekoaly = tekoaly;
    }
    
    public static KPSPeli luoKPSPelaajaVsPelaaja(Lukija lukija) {
        return new KPSPeli(lukija, null);
    }
    
    public static KPSPeli luoKPSTekoaly(Lukija lukija) {
        return new KPSPeli(lukija, new Tekoaly());
    }
    
    public static KPSPeli luoKPSParempiTekoaly(Lukija lukija) {
        return new KPSPeli(lukija, new TekoalyParannettu(20));
    }

    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        String ekanSiirto = pyydaEkanSiirto();
        String tokanSiirto = pyydaTokanSiirto(ekanSiirto);

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            lukija.tulosta(tuomari);
            lukija.tyhjaRivi();

            ekanSiirto = pyydaEkanSiirto();
            tokanSiirto = pyydaTokanSiirto(ekanSiirto);
        }
        
        lopetus(tuomari);
    }

    private String pyydaEkanSiirto() {
        lukija.tulosta("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = lukija.lueSyote();
        return ekanSiirto;
    }
    
    private String pyydaTokanSiirto(String ekanSiirto) {
        String tokanSiirto;
        
        if (tekoaly == null) {
            lukija.tulosta("Toisen pelaajan siirto: ");
            tokanSiirto = lukija.lueSyote();
        } else {
            tokanSiirto = tekoaly.annaSiirto();
            lukija.tulosta("Tietokone valitsi: " + tokanSiirto);
            tekoaly.asetaSiirto(ekanSiirto);
        }
        
        return tokanSiirto;
    }
    
    private void lopetus(Tuomari tuomari) {
        lukija.tyhjaRivi();
        lukija.tulosta("Kiitos!");
        lukija.tulosta(tuomari);
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
