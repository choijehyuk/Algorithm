import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[1000001];

        for (int i = 0; i < prime.length; i++) {
            if (isPrime(i)) prime[i] = true;
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int ans = 0;

            for (int j = 2; j <= N / 2; j++) {
                if (prime[j] && prime[N - j]) ans++;
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
