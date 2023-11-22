import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), i);
        }

        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (map.get(list.get(i)) > map.get(list.get(j))) {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);

    }
}