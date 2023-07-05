import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        while (true) {
            String s = br.readLine();
            int answer = 0;

            if (s.equals("#")) {
                break;
            }

            s = s.toLowerCase();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')
                    answer++;
                else
                    continue;
            }


            System.out.println(answer);
        }
    }

}