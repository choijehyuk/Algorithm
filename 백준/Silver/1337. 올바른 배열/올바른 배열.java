import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        int[] cnt = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                if (!list.contains(list.get(i) + j)) {
                    cnt[i]++;
                }

            }
        }

        int min = cnt[0];
        for (int c : cnt) {
            if (c <= min) {
                min = c;
            }
        }
        System.out.println(min);

    }
}