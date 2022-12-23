public class Universite {

    private String univercity;
    private String bolum;
    private int ogrSayisi;
    private double notOrt;

    //parametresiz constructor
    public Universite() {
    }

    //parametreli consturoctor
    public Universite(String univercity, String bolum, int ogrSayisi, double notOrt) {
        this.univercity = univercity;
        this.bolum = bolum;
        this.ogrSayisi = ogrSayisi;
        this.notOrt = notOrt;
    }

    public String getUnivercity() {
        return univercity;
    }

    //GETTER SETTER
    public void setUnivercity(String univercity) {
        this.univercity = univercity;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getOgrSayisi() {
        return ogrSayisi;
    }

    public void setOgrSayisi(int ogrSayisi) {
        this.ogrSayisi = ogrSayisi;
    }

    public double getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(double notOrt) {
        this.notOrt = notOrt;
    }

    @Override
    public String toString() {
        return "Universite{" +
                "univercity='" + univercity + '\'' +
                ", bolum='" + bolum + '\'' +
                ", ogrSayisi=" + ogrSayisi +
                ", notOrt=" + notOrt +
                '}';
    }
}
