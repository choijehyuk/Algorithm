import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (map.containsKey(s)) {
                map.replace(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        for (String s : map.keySet()) {
            max = Math.max(max, map.get(s));
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (String s : list) {
            if (map.get(s) == max) {
                System.out.println(s);
                System.exit(0);
            }
        }


    }
}