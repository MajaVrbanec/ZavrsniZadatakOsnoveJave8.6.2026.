public class Automobil extends Vozilo {

    private int brojVrata;

    // konstruktor - kasnije dodajemo iznimku za broj vrata
    public Automobil(String registarskiBroj, String marka, int godinaProizvodnje, int brojVrata) throws  Exception {
        super(registarskiBroj, marka, godinaProizvodnje);
        if (brojVrata <= 0) {
            throw new NeispravniPodaciException("Broj vrata mora biti pozitivan broj!");
        }
        this.brojVrata = brojVrata;
    }

    //getter - metoda za dohvaćanje podataka
    public int getBrojVrata() {
        return brojVrata;
    }

    //setter - metoda za postavljanje podataka
    public void setBrojVrata(int brojVrata) {
        this.brojVrata = brojVrata;
    }

    // metoda prikaziPodatke za ispis informacija o vozilu i broja vrata
    @Override
    public void prikaziPodatke() {
        super.prikaziPodatke();
        System.out.println("Broj vrata: " + brojVrata);
    }
}
