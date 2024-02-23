import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] input = new String[N];

        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                boolean flag = true;
                HashMap<Character, Character> map = new HashMap<>();
                for (int k = 0; k < input[j].length(); k++) {
                    char prev = input[i].charAt(k);
                    char now = input[j].charAt(k);
                    if (map.containsKey(prev)) {
                        if (map.get(prev) != now) {
                            flag = false;
                            break;
                        }
                    } else {
                        for (Character c : map.keySet()) {
                            if (map.get(c) == now) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) map.put(prev, now);
                    }
                }
                if (flag) answer++;
            }
        }
        System.out.println(answer);
    }
}