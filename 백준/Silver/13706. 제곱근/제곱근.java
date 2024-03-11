import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        BigInteger N = new BigInteger(br.readLine());

        BigInteger start = new BigInteger("1");
        BigInteger mid;
        BigInteger end = N;

        int cal = 0;

        while (true) {
            mid = start.add(end);
            mid = mid.divide(new BigInteger("2"));

            cal = (mid.multiply(mid)).compareTo(N);

            if (cal == 0) break;
            else if (cal == 1) end = mid.subtract(new BigInteger("1"));
            else start = mid.add(new BigInteger("1"));
        }

        System.out.println(mid);
    }
}