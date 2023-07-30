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

        int N = Integer.parseInt(br.readLine());

        if (N % 4 == 0 && N % 100 != 0) {
            System.out.println("1");
            System.exit(0);
        }
        if (N % 4 == 0 && N % 400 == 0) {
            System.out.println("1");
            System.exit(0);
        }
        System.out.println("0");
    }
}
