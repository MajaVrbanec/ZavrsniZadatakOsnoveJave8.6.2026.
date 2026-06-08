public class Motocikl extends Vozilo {

    private String tipMotora;

    // konstruktor - kasnije dodajemo iznimku za tip motora
    public Motocikl(String registarskiBroj, String marka, int godinaProizvodnje, String tipMotora) throws  Exception {
        super(registarskiBroj, marka, godinaProizvodnje);
        if (tipMotora == null) {
            throw new NeispravniPodaciException("Tip motora ne smije biti prazan!");
        }
        this.tipMotora = tipMotora;
    }

    // getter
    public String getTipMotora() {
        return tipMotora;
    }

    // setter
    public void setTipMotora(String tipMotora) {
        this.tipMotora = tipMotora;
    }

    // metoda prikaziPodatke za ispis informacija o vozilu i tipu motora
    @Override
    public void prikaziPodatke() {
        super.prikaziPodatke();
        System.out.println("Tip motora: " + tipMotora);
    }
}
