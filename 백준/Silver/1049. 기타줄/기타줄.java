import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int six = Integer.MAX_VALUE;
        int one = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int price1 = Integer.parseInt(st.nextToken());
            int price2 = Integer.parseInt(st.nextToken());
            if (price1 < six)
                six = price1;
            if (price2 < one)
                one = price2;
        }
        int price = 0;
        while (N >= 6) {
            int min = Math.min(six, one * 6);
            price += min;
            N -= 6;
        }

        if (N > 0) {
            int min = Math.min(six, one * N);
            price += min;
        }
        System.out.println(price);
    }
}