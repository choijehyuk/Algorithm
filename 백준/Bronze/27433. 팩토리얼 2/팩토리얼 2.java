import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        long answer = 1;

        if (N == 0) {
            System.out.println("1");
            System.exit(0);
        } else {
            for (int i = 1; i <= N; i++) {
                answer *= i;
            }
        }
        System.out.println(answer);
    }
}