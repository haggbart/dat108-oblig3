package helper;

public class Utils {

    public static int tryParse(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException ignored) {
            return -1;
        }
    }
}
