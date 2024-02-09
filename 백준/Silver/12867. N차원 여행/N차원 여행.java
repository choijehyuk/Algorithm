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
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        String directions = br.readLine();

        ArrayList<String> visited = new ArrayList<>();
        visited.add("");

        boolean flag = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        L:
        for (int i = 0; i < M; i++) {
            char dir = directions.charAt(i);

            // 없을 때
            if (!map.containsKey(arr[i])) {
                // 증가
                if (dir == '+') map.put(arr[i], 1);
                    // 감소
                else map.put(arr[i], -1);
            }
            // 있을 때
            else {
                // 증가
                if (dir == '+') map.put(arr[i], map.get(arr[i]) + 1);
                    // 감소
                else map.put(arr[i], map.get(arr[i]) - 1);
            }

            String cur = "";


            for (int key : map.keySet()) {
                int value = map.get(key);
                if (value != 0) {
                    cur += dist(key) + " " + dist(value) + " ";
                }
            }

            for (String str : visited) {
                if (str.equals(cur)) {
                    flag = false;
                    break L;
                }
            }

            visited.add(cur);
        }

        System.out.println(flag ? 1 : 0);
    }

    static String dist(int value) {
        String res = "";
        if (value < 0) {
            res += "-";
            value *= -1;
        }

        int val = value;
        int div = 0;
        while (val > 1) {
            val /= 10;
            div++;
        }

        for (int i = div; i >= 0; i--) {
            res += (char) (value / Math.pow(10, i) + '0');
            value %= Math.pow(10, i);
        }
        return res;
    }
}