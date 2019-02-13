/*Zadanie.
   1. Stwórz klasę Zwierzę -> pola: rodzaj(ssak, płaz, gad...), gatunek(pies, żaba...), cena
   2. Stwórz klasę Sklep zoologiczny -> pole lista wszystkich zwierząt obecnych w sklepie
   pole katalog dostepnych w sklepie zwierzat (set)

   metoda -> dodajZwierze
   metoda -> kupionoZwierze
   metoda -> znajdzRodzaj (z listy)
   metoda -> znajdzGatunek (z listy)
   metoda -> wypiszZKataloguZwierzatDostepneZwierzetaOproczGatunku <- np. jeśli ktoś nie byłby zdecydowany na to jakie zwierzę chce mieć,
   ale wie, że na pewno nie chce węża (z seta)
   metoda -> znajdzLiczbeDostepnychWSklepieZwierzat(String gatunek)

   3. Stworz klasę Zamówienie: pole -> zwierzę, ilość
   pole -> lista zamówień
   Wróć do klasy Sklep zoologiczny i stwórz metodę -> obliczSumeZamowienia()
   Przetestuj w mainie. Pamiętaj, że jak usuwasz/dodajesz zwierzę to musisz to zrobić i w liście i w secie.*/

import java.util.*;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class SklepZoologiczny {
    public List<Zwierze> listaZwierzat = new ArrayList<>();
    public Set<Zwierze>setZwierzat = new HashSet<>();

    public void dodajZwierze(Zwierze zwierze){
        listaZwierzat.add(zwierze);
        setZwierzat.add(zwierze);
    }
    public void kupionoZwierze(Zwierze zwierze){
        listaZwierzat.remove(zwierze);
        setZwierzat.remove(zwierze);
        System.out.println("Kupiono: "+zwierze);
    }
    public Zwierze znajdzRodzaj(String rodzaj){
        for(Zwierze zwierze:listaZwierzat){
            if(zwierze.getRodzaj().equalsIgnoreCase(rodzaj)){
                System.out.println("Zwierzęta o rodzaju "+rodzaj+ ": "+zwierze);
                //return zwierze; //return powoduje wyrzucenie do pamięci, wydruk jest osobno powyżej
                //ten return tutaj powodował nie wydrukowanie drugiego gada
            }
        }
        //System.out.println("Nie ma zwierzęcia o podanym rodzaju.");//JAK DODAC TEN KOMUNIKAT GDY NIE ZNALEZIONO ZADNEGO ZWIERZECIA o RODZAJU X
        return null;
    }
    public Zwierze znajdzGatunek(String gatunek){
        for(Zwierze zwierze:listaZwierzat){
            if(zwierze.getGatunek().equalsIgnoreCase(gatunek)){
                System.out.println("Zwierzęta o gatunku "+gatunek+ ": "+zwierze);
            }
        }
        //System.out.println("Nie ma zwierzęcia o podanym gatunku");
        return null;
    }
    public Zwierze wypiszZwierzetaOproczGatunku(String gatunek){
        System.out.println("Zwierzęta oprócz gatunku "+gatunek+" to:");
        for (Zwierze zwierze:listaZwierzat) {
            if(zwierze.getGatunek().equalsIgnoreCase(gatunek)){
                continue;
            }else {
                System.out.println(zwierze);
            }
        }
        return null;
    }
    public Zwierze ileDostepnychZwierzat(String gatunek){
        int liczbaDostepnychZwierzat=0;
        for(Zwierze zwierze:listaZwierzat){
            if(zwierze.getGatunek().equalsIgnoreCase(gatunek)){
                liczbaDostepnychZwierzat+=1;
            }
        }
        System.out.println("W sklepie są: "+liczbaDostepnychZwierzat+" zwierzęta o gatunku: "+gatunek);
        return null;
    }
    public Zwierze wypiszListeZwierzat(){
        System.out.println("W sklepie jest lista zwierząt:");
        for(Zwierze zwierze:listaZwierzat){
            System.out.println(zwierze);
        }
        return null;
    }
    public Zwierze wypiszSetaZwierzat(){
        System.out.println("Katalog zwierząt to:");
        for(Zwierze zwierze:setZwierzat){
            System.out.println(zwierze);
        }
        return null;
    }

    Queue<Zamówienie2> kolejkaZamowien = new ArrayDeque<>();

    public void dodajDoZamowienia(Zwierze zwierze, int ilosc){
        kolejkaZamowien.offer(new Zamówienie2(zwierze, ilosc));  //jak tu wtedy zwierze bez new?
    }
    public void obliczZamowienie () {
        Zamówienie2 zamówienie2;
        double wartoscZamowienia=0;
        while ((zamówienie2 = kolejkaZamowien.poll()) != null) {
            wartoscZamowienia+=(zamówienie2.getZwierze().getCena()*zamówienie2.getIlosc());

        /*while(kolejkaZamowien.peek()!=null){ //wyswietlam go czy nie jest nullem, podgladam//jezeli kolejka nie jest pusta to zrob ponizsze
            System.out.println("W zamówieniu był: "+kolejkaZamowien.poll());
            System.out.println("Wartość zamówienia to");
            kolejkaZamowien.ge

        }*/
        }
        System.out.println("Wartość zamówienia to: "+wartoscZamowienia);
    }

    public static void main(String[] args) {

        Zwierze pies1 = new Zwierze("ssak", "pies",130);
        Zwierze malpa1 = new Zwierze("ssak", "malpa",330);
        Zwierze zaba1 = new Zwierze("płaz", "żaba",5);
        Zwierze jaszczurka1 = new Zwierze("płaz", "jaszczurka",50);
        Zwierze krokodyl1 = new Zwierze("gad", "krokodyl",3000);
        Zwierze waz1 = new Zwierze("gad", "waz",450);

        SklepZoologiczny sklep = new SklepZoologiczny();
        sklep.dodajZwierze(pies1);
        sklep.dodajZwierze(pies1);
        sklep.dodajZwierze(malpa1);
        sklep.dodajZwierze(malpa1);
        sklep.dodajZwierze(zaba1);
        sklep.dodajZwierze(jaszczurka1);
        sklep.dodajZwierze(krokodyl1);
        sklep.dodajZwierze(waz1);
        System.out.println("");

        sklep.wypiszListeZwierzat();
        System.out.println("");
        sklep.kupionoZwierze(pies1);
        System.out.println("");
        System.out.println("");

        sklep.znajdzRodzaj("GAD");
        sklep.znajdzGatunek("malpa");
        System.out.println("");

        sklep.wypiszZwierzetaOproczGatunku("waz");
        System.out.println("");

        sklep.ileDostepnychZwierzat("malpa");
        System.out.println("");

        sklep.wypiszSetaZwierzat();
        System.out.println("");

        System.out.println("Złożone zamówienie to:");
        sklep.dodajDoZamowienia(pies1,1);
        sklep.dodajDoZamowienia(zaba1,2);
        sklep.dodajDoZamowienia(krokodyl1,3);

        System.out.println(sklep.kolejkaZamowien);
        sklep.obliczZamowienie();

    }

}
