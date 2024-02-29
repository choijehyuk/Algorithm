import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < N; i++) {
            String ring = br.readLine();

            String circle = ring + ring;

            for (int j = 0; j < circle.length(); j++) {
                if (circle.contains(s)) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

}