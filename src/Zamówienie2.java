public class Zamówienie2 {
    final Zwierze zwierze; //czy to bez konstruktora?
    final int ilosc;

    public Zamówienie2(Zwierze zwierze, int ilosc) {
        this.zwierze = zwierze;
        this.ilosc = ilosc;
    }
    public Zwierze getZwierze() {
        return zwierze;
    }
    public int getIlosc() {
        return ilosc;
    }
    @Override
    public String toString() {
        return "\n"+"Zamówienie2{" +
                "zwierze=" + zwierze +
                ", ilosc=" + ilosc +
                '}';
    }
}
