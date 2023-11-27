import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = M; i <= N; i++) {

            int check = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    check++;
                }
            }

            if (check == 2) {
                list.add(i);
            }
        }

        if (list.size() == 0) {
            System.out.println("-1");
        } else {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }

            System.out.println(sum);
            System.out.println(list.get(0));

        }
    }

}