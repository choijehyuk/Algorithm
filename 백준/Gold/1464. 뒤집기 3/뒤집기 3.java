import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        String answer = s.substring(0, 1);

        for (int i = 1; i < s.length(); i++) {
            if (answer.charAt(i - 1) < s.charAt(i)) answer = s.charAt(i) + answer;
            else answer = answer + s.charAt(i);
        }

        for (int i = 0; i < answer.length(); i++) {
            System.out.print(answer.charAt(answer.length() - i - 1));
        }
    }
}