package ohtu.kivipaperisakset;

// "Muistava tekoäly"
public class TekoalyParannettu implements TekoalyRajapinta {

    private String[] muisti;
    private int vapaaMuistiIndeksi;

    public TekoalyParannettu(int muistinKoko) {
        muisti = new String[muistinKoko];
        vapaaMuistiIndeksi = 0;
    }

    @Override
    public void asetaSiirto(String siirto) {
        onkoMuistiTaynna();

        muisti[vapaaMuistiIndeksi] = siirto;
        vapaaMuistiIndeksi++;
    }

    private void onkoMuistiTaynna() {
        if (vapaaMuistiIndeksi == muisti.length) {
            for (int i = 1; i < muisti.length; i++) {
                muisti[i - 1] = muisti[i];
            }
            vapaaMuistiIndeksi--;
        }
    }

    @Override
    public String annaSiirto() {
        if (vapaaMuistiIndeksi == 0 || vapaaMuistiIndeksi == 1) {
            return "k";
        }

        return valittuSiirto();
    }
    
    private String valittuSiirto() {
        int k = kivienMaara();
        int p = paperienMaara();
        int s = saksienMaara();

        if (k > p && k > s) {
            return "p";
        } else if (p > k && p > s) {
            return "s";
        } else {
            return "k";
        }
    }

    private int kivienMaara() {
        return siirronMaara("k");
    }

    private int paperienMaara() {
        return siirronMaara("p");
    }

    private int saksienMaara() {
        return siirronMaara("s");
    }

    private int siirronMaara(String siirto) {
        int maara = 0;
        for (int i = 0; i < vapaaMuistiIndeksi - 1; i++) {
            if (siirto.equals(muisti[i])) {
                maara++;
            }
        }
        return maara;
    }
}
