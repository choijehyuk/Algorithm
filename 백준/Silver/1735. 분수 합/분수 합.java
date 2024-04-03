import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int top = a * d + b * c;
        int bottom = b * d;

        for (int i = 2; i <= Math.min(top, bottom); i++) {
            if (top % i == 0 && bottom % i == 0) {
                top /= i;
                bottom /= i;
                i--;
            }
        }
        System.out.println(top + " " + bottom);
    }
}