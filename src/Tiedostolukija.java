import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;
import java.util.stream.Stream;
import java.util.Scanner;

public class Tiedostolukija {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // Luetaan tiedosto
        System.out.println("Tiedostolukija: \n");
        System.out.println("[Lue] tiedosto :: Komento ei lopettaa");
        String tiedostonLukija = lukija.nextLine();

        while (true) {
            if (tiedostonLukija.equalsIgnoreCase("lopeta")) {
                break;
            }

            if (tiedostonLukija.equalsIgnoreCase("lue")) {
                System.out.println("Anna polku:");
                String tiedostonNimi = lukija.nextLine();
                lueHakemistot(tiedostonNimi);

                System.out.println("Mikä tiedosto luetaan?");
                String tiedostonValinta = lukija.nextLine();

                lueTiedostot(tiedostonNimi + "\\" + tiedostonValinta);

            }


            System.out.println("Luetaanko vielä?");
            String valinta = lukija.nextLine();
            if (valinta.equalsIgnoreCase("ei")) {
                break;
            }
        }

    }

    // Hello
    private static void lueHakemistot(String hakemisto) {

        try {
            Path kansio = Paths.get(hakemisto);
            Stream<Path> virta = Files.list(kansio);
            virta.filter(Files::isRegularFile)
                    .map(p -> p.getFileName())
                    .forEach(System.out::println);
            System.out.println("--------------------");
        } catch (IOException e) {
            System.out.println("Virhe! " + e.fillInStackTrace());
        }

    }

    private static void lueTiedostot(String tiedosto) {
        String tulos = null;
        try
                (FileReader fr = new FileReader(tiedosto);
                 BufferedReader in = new BufferedReader(fr)){
            StringBuilder teksti = new StringBuilder();
            String rivi;
            while ((rivi = in.readLine()) != null) {
                teksti.append(rivi).append("\n");
            }
            tulos = teksti.toString();
            System.out.println(tulos);
        } catch (FileNotFoundException ex) {
            System.out.println("Virhe: tiedostoa ei löytynyt " + ex.getLocalizedMessage());
        } catch (IOException ex) {
            System.out.println("Muu virhe!");
        }
    }

}

