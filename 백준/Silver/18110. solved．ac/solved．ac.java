import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int round = (int) Math.round(n * 0.15);

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        int size = n - (round * 2);

        int answer = 0;
        for (int i = round; i < size + round; i++) {
            answer += list.get(i);
        }


        answer = (int) Math.round((double) answer / size);
        System.out.println(answer);
    }
}