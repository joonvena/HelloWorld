import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {


        // Tulostetaan listasta viikonpaivat jotka alkaa t kirjaimella.

        String[] vkpaivat = {"maanantai", "tiistai", "keskiviikko", "torstai", "perjantai"};

        for(String s : vkpaivat) {
            if(s.substring(0, 1).contains("t")) {
                System.out.println(s);
            }
        }

        // "t" kirjaimella alkavien elementtien poisto listasta Iteraattoria käyttäen.

        List<String> viikonpaivat = new LinkedList<>();

        viikonpaivat.add("maantai");
        viikonpaivat.add("tiistai");
        viikonpaivat.add("torstai");
        viikonpaivat.add("perjantai");
        viikonpaivat.add("ää");

        Iterator<String> iteraattori = viikonpaivat.iterator();

        while(iteraattori.hasNext()) {
            String vkpaiva = iteraattori.next();

            if(vkpaiva.substring(0, 1).contains("t")) {
                iteraattori.remove();
            }
        }


        System.out.println(viikonpaivat);

        // Sorttaa viikonpäivät aakkosjärjestykseen

        Collections.sort(viikonpaivat);

        // Sorttaa viikonpäivät käänteiseen aakkosjärjestykseen

        Collections.sort(viikonpaivat, Collections.reverseOrder());

        System.out.println(viikonpaivat);
        System.out.println(hexToDec("1a10FF"));


    }

    public static int hexToDec(final String hexString) {
        String hex = "a";
        int decimal = Integer.parseInt(hexString, 16);
        return decimal;
    }

}
