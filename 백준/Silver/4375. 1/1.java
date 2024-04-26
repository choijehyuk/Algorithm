import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String input;
        int n;
        int remainder;
        int answer;
        while ((input = br.readLine()) != null) {
            n = Integer.parseInt(input);
            remainder = 1;
            answer = 1;
            while (remainder % n != 0) {
                remainder = (remainder * 10 + 1) % n;
                answer++;
            }
            System.out.println(answer);
        }

    }
}