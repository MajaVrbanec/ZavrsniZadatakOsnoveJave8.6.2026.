import java.io.*;
import java.util.ArrayList;

public class EvidencijaVozila {

    // kreiramo listu "listaVozila"
    ArrayList<Vozilo> listaVozila = new ArrayList<Vozilo>();

    // metoda za dodavanje vozila
    public void dodajVozilo(Vozilo vozilo) {
        listaVozila.add(vozilo);
    }

    // metoda za spremanje podataka o vozilima u tekstualnu datoteku
    public void spremiPodatkeUDatoteku(String datoteka) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(datoteka))) { // try with resources blok da kad otvorimo PrintWriter i FileWriter, Java ih kasnije sama zatvori
            // PrintWriter out --> alat koji tekst pretvara u zapis za datoteku
            // new FileWriter(datoteka) --> alat koji otvara samu datoteku na disku

            for (Vozilo v : listaVozila) { // za svaki objekt v koji je tipa Vozilo a nalazi se u listaVozila...

                // print jer pišemo i istom redu, getClass().getSimpleName() jer se pišu zajedno i trebaju nam da napišemo ime klase tj. da napišemo tip vozila
                out.print(v.getClass().getSimpleName() + "," + v.getRegistarskiBroj() + "," + v.getMarka() + "," + v.getGodinaProizvodnje());
                if (v instanceof Automobil) { // pitamo je li ovo vozilo v zapravo tipa Automobil
                    Automobil a = (Automobil) v; // pretvorba(casting) objekta tipa Vozilo u objekt tipa Automobil da bi dohvatili i specifičan atribut te klase
                    out.println("," + a.getBrojVrata()); // dohvaća i zapisuje i varijablu brojVrata
                } else if (v instanceof Motocikl) { // ako je vozilo v tipa motocikl
                    Motocikl m = (Motocikl) v; // onda radimo casting iz tipa Vozilo u tip Motocikl da možemo dohvatiti varijablu tip motora
                    out.println("," + m.getTipMotora()); // dohvaća i zapisuje i varijablu tipMotora
                } else {
                    out.println(); // ako nije ni jedno ni drugo (npr. samo obična klasa Vozilo) onda samo prelazi u novi red.
                }
            }
        }
    }

    // metoda koja učitava podatke o vozilima iz tekstualne datoteke
    public void ucitajPodatkeIzDatoteke(String datoteka) throws IOException {
        listaVozila.clear(); // da obriše staru listu ako postoji prije nego doda nove podatke koje smo unijeli kroz konzolu, spremili ih u listu i datoteku pa ih učita iz datoteke (te nove podatke)

        // BufferedReader reader je alat za čitanje tekstualnih podataka (bajtova) iz datoteke i slaže ih u tekstualne linije (Stringove)
        // new FileReader(datoteka) je alat(klasa) koji tu datoteku otvara kao tok bajtova kako bi se mogla pročitati
        // new BufferedReader(...) je alat koji omotava taj FileReader kako bi se podatci čitali red po red (metoda readLine)!
        try (BufferedReader reader = new BufferedReader(new FileReader(datoteka))) { // koristimo try with resources kako bi Java kasnije zatvorila sve što smo otvorili
            String linija; // ovdje spremamo svaki red teksta koji reader pročita iz datoteke
            while ((linija = reader.readLine()) != null) { // uvjet je da reader čita datoteku red po red i svaki red sprema kao String u varijablu linija sve dok ima redova u datoteci
                // kad dođe do kraja i nema više redova, vraća null što označava kraj datoteke i petlja onda staje!

                // zatim moramo koristiti metodu klase String koja se zove split(",") - ona je kao "škare",razbija/reže
                // pročitani red (tamo gdje vidi zarez!!!) - prekida String i te pojedinačne dijelove (Stringove) sprema
                // u polje tipa String na određeni indeks (npr. 0 je Automobil, 1 je registracija, 2 je marka, 3 je
                // godina proizvodnje).
                // to radimo da bismo mogli te podatke(Stringove) koristiti za stvaranje objekata
                // zbog toga kreiramo polje(niz) kako bi točno spremili svaki podatak na odgovarajući indeks (0 je tip vozila, 1 je registracija, itd.)
                String[] dijelovi =  linija.split(","); // tu režemo String linija na svakom zarezu tj. cijeli red na dijelove

                // pišemo if naredbu da bi provjerili o kojem tipu vozila se radi prema indeksu 0 kako bi na temelkju toga stvorili novi objekt i spremili ga u listu listaVozila
                if (dijelovi[0].equals("Automobil")) {
                    try {
                        Automobil a = new Automobil(dijelovi[1], dijelovi[2], Integer.parseInt(dijelovi[3]), Integer.parseInt(dijelovi[4]));
                        // dijevoli[3] je tekst("2020"), a konstruktor traži int-Integer.parseInt uzima taj tekst i pretvara ga u broj, isto i za dijelovi[4]
                        listaVozila.add(a); // tu dodajemo taj objekt(s podatcima iz zagrade koji mu pripadaju) u našu listu
                    } catch (Exception e) {
                        System.out.println("Greška: " + e.getMessage());
                    }
                } else if (dijelovi[0].equals("Motocikl")) {
                    try {
                        Motocikl m = new Motocikl(dijelovi[1], dijelovi[2], Integer.parseInt(dijelovi[3]), dijelovi[4]);
                        listaVozila.add(m);
                    } catch (Exception e) {
                        System.out.println("Greška: " + e.getMessage());
                    }
                }

            }

        }

    }
    // metoda za prikaz svih objekata - vozila spremljenih u listu i u datoteku kako bismo mogli pozvati ovu metodu kod učitavanja da se ona ispišu i u konzolu
    public void prikazSvihVozila() {
        for (Vozilo v : listaVozila) {
            v.prikaziPodatke();
        }
    }

}
