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

        String a = br.readLine();
        String b = br.readLine();

        if (a.length() >= b.length()) {
            System.out.println("go");
        } else {
            System.out.println("no");
        }
    }
}
