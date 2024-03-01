import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger sum = BigInteger.ONE;
        BigInteger div = BigInteger.ONE;

        for (int i = 0; i < m; i++) {
            sum = sum.multiply(new BigInteger(String.valueOf(n - i)));
            div = div.multiply(new BigInteger(String.valueOf(i + 1)));
        }

        System.out.println(sum.divide(div));
    }
}