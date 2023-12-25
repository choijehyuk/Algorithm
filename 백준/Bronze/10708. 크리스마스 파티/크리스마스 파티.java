import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] target = new int[M + 1];
        int[] score = new int[N + 1];

        for (int i = 1; i <= M; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                int predict = Integer.parseInt(st.nextToken());

                if (predict == target[i]) {
                    score[j]++;
                } else {
                    score[target[i]]++;
                }
            }

        }

        for (int i = 1; i < score.length; i++) {
            System.out.println(score[i]);
        }
    }
}