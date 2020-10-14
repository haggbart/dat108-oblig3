package no.hvl.dat108.handleliste.helper;

public class Utilities {

    public static int tryParse(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException ignored) {
            return -1;
        }
    }
}
