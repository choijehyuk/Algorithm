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

        int sum = 0;

        for (int i = 0; i < 5; i++) {
            int N = Integer.parseInt(br.readLine());
            if (N < 40) {
                N = 40;
            }
            sum += N;
        }
        System.out.println(sum / 5);
    }

}
