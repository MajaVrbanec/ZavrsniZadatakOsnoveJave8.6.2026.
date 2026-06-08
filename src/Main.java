import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        EvidencijaVozila ev = new EvidencijaVozila(); // stvaramo novi objekt ev klase EvidencijaVozila kako bismo mogli koristiti njene metode
        Scanner sc = new Scanner(System.in); // inicijaliziramo Scanner
        String izbor; // Ovdje čuvamo izbor korisnika

        // do-while se izvrši barem jednom, pa tek onda provjerava uvjet
        do {
            System.out.println("\n--- IZBORNIK ---");
            System.out.println("1. Dodaj automobil:");
            System.out.println("2. Dodaj motocikl:");
            System.out.println("3. Spremi u datoteku:");
            System.out.println("4. Učitaj iz datoteke:");
            System.out.println("5. Izlaz");
            System.out.print("Odabir: ");

            izbor = sc.nextLine(); // Učitavamo izbor

            switch (izbor) {
                case "1": // ukoliko se odabere opcija dodaj automobil
                    try { // koristimo try-catch blok za iznimku NeispravniPodaciException!!!
                        System.out.print("Registarska oznaka vozila: ");
                        String regA = sc.nextLine();
                        System.out.print("Marka vozila: ");
                        String markaA = sc.nextLine();
                        System.out.print("Godina prizvodnje vozila: ");
                        int godA = Integer.parseInt(sc.nextLine());
                        System.out.print("Broj vrata na vozilu: ");
                        int vrata = Integer.parseInt(sc.nextLine());
                        ev.dodajVozilo(new Automobil(regA, markaA, godA, vrata));
                    } catch (NeispravniPodaciException e) {
                        System.out.println("Greška: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Greška: " + e.getMessage());
                    }
                    break;
                case "2": // ukoliko se odabere opcija dodaj motocikl
                    try {
                        System.out.print("Registarska oznaka vozila: ");
                        String regM = sc.nextLine();
                        System.out.print("Marka vozila: ");
                        String markaM = sc.nextLine();
                        System.out.print("Godina proizvodnje vozila: ");
                        int godM = Integer.parseInt(sc.nextLine());
                        System.out.print("Tip motora vozila: ");
                        String tip = sc.nextLine();
                        ev.dodajVozilo(new Motocikl(regM, markaM, godM, tip));
                    } catch (NeispravniPodaciException e) {
                        System.out.println("Greška: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Greška: " + e.getMessage());
                    }
                    break;
                case "3": // spremamo podatke u datoteku
                    try { ev.spremiPodatkeUDatoteku("vozila.txt"); }
                    catch (IOException e) { System.out.println("Greška: " + e.getMessage()); }
                    break;
                case "4": // učitavamo podatke iz datoteke
                    try { ev.ucitajPodatkeIzDatoteke("vozila.txt"); }
                    catch (Exception e) { System.out.println("Greška: " + e.getMessage()); }
                    break;
            }
            // Uvjet petlje: vrti se dokle god korisnik nije unio "5"
        } while (!izbor.equals("5"));

        sc.close(); // zatvaramo scanner
    }
}