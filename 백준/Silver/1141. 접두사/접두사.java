import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        int answer = N;

        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).startsWith(word)) {
                    answer--;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}