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

        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = 0;

            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    left++;
                } else if (s.charAt(j) == ')') {
                    if (right >= left) {
                        right = 10000;
                        right++;
                    } else {
                        right++;
                    }
                }
            }
            if (left == right) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}
