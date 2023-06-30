import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuffer sb = new StringBuffer();

        while (true) {
            String s = br.readLine();
            boolean check = true;
            if (s.equals("0"))
                System.exit(0);

            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) check = false;
            }

            if (check) System.out.println("yes");
            else System.out.println("no");

        }

    }


}