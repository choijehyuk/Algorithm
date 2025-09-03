import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        HashMap<String, Integer> map = new HashMap<>();
        int total = 0;

        while (true) {
            String s = br.readLine();
            if (s == null || s.length() == 0) break;
            map.put(s, map.getOrDefault(s, 0) + 1);
            total++;
        }

        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);

        for (int i = 0; i < keys.length; i++) {
            int val = map.get(keys[i]);
            double percent = ((double) val / (double) total) * 100;
            sb.append(keys[i] + " " + String.format("%.4f", percent)).append("\n");
        }

        System.out.println(sb);

    }

}
