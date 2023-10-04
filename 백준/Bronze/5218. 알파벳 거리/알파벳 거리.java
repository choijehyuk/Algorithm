import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String first = st.nextToken();
            String second = st.nextToken();
            sb.append("Distances: ");
            for (int j = 0; j < first.length(); j++) {
                if (second.charAt(j) - first.charAt(j) < 0) {
                    sb.append((second.charAt(j) - first.charAt(j) + 26) + " ");
                } else {
                    sb.append(second.charAt(j) - first.charAt(j) + " ");
                }
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }

}