package pl.edu.uksw.si.se.edytafraszczak;

import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) throws FileNotFoundException {

        try {

            BazaWiedzy bazaWiedzy = BazaWiedzyNarzedzia.odczytajBazeWiedzy("baza_wiedzy.json");
            GuiNarzedzia.pokazDialog("Witaj w systemie eksperckim, załadowana baza wiedzy dotyczy:  " + bazaWiedzy.getOpis());
            SesjaZUzytkownikiem sesja = new SesjaZUzytkownikiem();
            sesja.setBazaWiedzy(bazaWiedzy);
            Odpowiedz obecnaOdpowiedz = null;
            boolean czySkonczone = false;
            while (!czySkonczone) {
                obecnaOdpowiedz = BazaWiedzyNarzedzia.przetwurzRegule(sesja, BazaWiedzyNarzedzia.dajReguleONajwyzszymPoziomieUfnosci(sesja));
                if (obecnaOdpowiedz == null) {
                    GuiNarzedzia.pokazDialog("Skonczono przetwrzanie, nie udało się zdiagnozować systemu ");
                    czySkonczone = true;
                }
                if (obecnaOdpowiedz.getWartosc().equalsIgnoreCase("true")) {
                    GuiNarzedzia.pokazDialog("Skonczono przetwrzanie, diagnoza : " + obecnaOdpowiedz.getRegula().getCel());
                    czySkonczone = true;
                }
            }
        } catch (RuntimeException ex) {
            //blad gdy user wybierze w dialogu cancel
        } catch (Exception ex) {
            GuiNarzedzia.pokazDialog("Wystapil blad w programie: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            GuiNarzedzia.pokazDialog("Dziekujemy za skozystanie z systemu, dziękuje");
            System.exit(0);
        }


    }
}
