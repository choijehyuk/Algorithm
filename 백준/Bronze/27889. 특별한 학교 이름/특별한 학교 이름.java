import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        String s = br.readLine();

        if (s.equals("NLCS")) {
            System.out.println("North London Collegiate School");
        } else if (s.equals("BHA")) {
            System.out.println("Branksome Hall Asia");
        } else if (s.equals("KIS")) {
            System.out.println("Korea International School");
        } else if (s.equals("SJA")) {
            System.out.println("St. Johnsbury Academy");
        }
    }
}
