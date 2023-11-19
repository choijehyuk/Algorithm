import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();

        int max = 0;
        long answer = 0;

        for (int i = 0; i < N; i++) {
            long card = Long.parseLong(br.readLine());

            map.put(card, map.getOrDefault(card, 0) + 1);

            if (map.get(card) > max) {
                max = map.get(card);
                answer = card;
            } else if (map.get(card) == max) {
                answer = Math.min(answer, card);
            }
        }

        System.out.println(answer);
    }
}