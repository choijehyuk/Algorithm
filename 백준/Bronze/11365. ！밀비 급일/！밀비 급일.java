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

        while (true) {
            String s = br.readLine();

            if (s.equals("END")) {
                System.out.println(sb);
                System.exit(0);
            }
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(s.length() - i - 1));
            }
            sb.append("\n");
        }
    }

}
