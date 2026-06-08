public class Vozilo {

    private String registarskiBroj;
    private String marka;
    private int godinaProizvodnje;

    // konstruktor - u njega smo kasnije dodali iznimku!!!
    public Vozilo(String registarskiBroj, String marka, int godinaProizvodnje) throws Exception {
        if (godinaProizvodnje < 1886) {
            throw new NeispravniPodaciException("Godina proizvodnje ne može biti manja od 1886!");
        }
        this.registarskiBroj = registarskiBroj;
        this.marka = marka;
        this.godinaProizvodnje = godinaProizvodnje;
    }

    // getter
    public String getRegistarskiBroj() {
        return registarskiBroj;
    }

    public String getMarka() {
        return marka;
    }

    public int getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    // setter
    public void setRegistarskiBroj(String registarskiBroj) {
        this.registarskiBroj = registarskiBroj;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setGodinaProizvodnje(int godinaProizvodnje) {
        this.godinaProizvodnje = godinaProizvodnje;
    }

    // metoda za učitavanje podataka - postavlja i dohvaća podatke o vozilu
    public void ucitajPodatke(String registarskiBroj, String marka, int godinaProizvodnje) {
        this.registarskiBroj = registarskiBroj;
        this.marka = marka;
        this.godinaProizvodnje = godinaProizvodnje;
    }

    // metoda za prikaz podataka - ispisuje informacije o vozilu
    public void prikaziPodatke() {
        System.out.println("Registarski broj vozila: " + registarskiBroj);
        System.out.println("Marka vozila: " + marka);
        System.out.println("Godina proizvodnje vozila: " + godinaProizvodnje);
    }
}
