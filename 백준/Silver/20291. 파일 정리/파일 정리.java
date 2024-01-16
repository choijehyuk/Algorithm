import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    static class Point {
        String name;
        int cnt;

        public Point(String name, int cnt) {
            this.name = name;
            this.cnt = cnt;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String name = "";
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '.') {
                    for (int k = j + 1; k < s.length(); k++) {
                        name += s.charAt(k);
                    }
                }
            }

            if (map.containsKey(name)) {
                int cnt = map.get(name);
                map.put(name, cnt + 1);
            } else {
                map.put(name, 1);
            }
        }

        ArrayList<Point> list = new ArrayList<>();

        for (String string : map.keySet()) {
            list.add(new Point(string, map.get(string)));
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).name + " ");
            System.out.println(list.get(i).cnt);

        }
    }
}