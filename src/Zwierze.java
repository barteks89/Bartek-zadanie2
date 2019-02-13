public class Zwierze {
    private String rodzaj; //enkapsulacja
    private String gatunek;
    private double cena;
    public Zwierze(String rodzaj, String gatunek, double cena){
        this.rodzaj = rodzaj;
        this.gatunek = gatunek;
        this.cena = cena;    }
    public String getRodzaj (){
        return rodzaj;  }
    public String getGatunek() {
        return gatunek;    }
    public double getCena() {
        return cena;    }
    public void setRodzaj(String rodzaj){
        this.rodzaj = rodzaj;    }
    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;    }
    public void setCena(double cena) {
        this.cena = cena;    }
    @Override
    public String toString() {
        return "Zwierzę o " +
                "rodzaju='" + rodzaj + '\'' +
                ", gatunku='" + gatunek + '\'' +
                " i cenie=" + cena +
                '}'; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zwierze zwierze = (Zwierze) o;
        if (Double.compare(zwierze.cena, cena) != 0) return false;
        if (!rodzaj.equals(zwierze.rodzaj)) return false;
        return gatunek.equals(zwierze.gatunek); }
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = rodzaj.hashCode();
        result = 31 * result + gatunek.hashCode();
        temp = Double.doubleToLongBits(cena);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

