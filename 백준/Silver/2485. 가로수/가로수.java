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
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int gcd = 0;
        for (int i = 0; i < N - 1; i++) {
            int dist = arr[i + 1] - arr[i];
            gcd = gcd(dist, gcd);
        }

        System.out.println((arr[N - 1] - arr[0]) / gcd + 1 - (arr.length));

    }

    public static int gcd(int dist, int gcd) {
        if (gcd == 0)
            return dist;
        return gcd(gcd, dist % gcd);
    }

}