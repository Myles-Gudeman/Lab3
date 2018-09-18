import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class Main {
    /**

     */
    public static void main(String[] unused) {
        String rawtext = urlToString("http://erdani.com/tdpl/hamlet.txt");
        int princecount = 0;
        for (int x = 0; x < rawtext.length()-6; x++) {
            String temp = rawtext.substring(x,x+6);
            temp = temp.toLowerCase();
            if (temp.equals("prince")) {
                princecount++;
            }

        }
        System.out.println("The total number of times prince occurs in Hamlet is: " + princecount);
    }
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

}
