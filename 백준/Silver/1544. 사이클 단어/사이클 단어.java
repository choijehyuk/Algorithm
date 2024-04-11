import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        ArrayList<String>[] arr;

        arr = new ArrayList[N];

        int answer = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
            String input = br.readLine();

            for (int j = 0; j < input.length(); j++) {
                arr[i].add(input.substring(j) + input.substring(0, j));
            }

            boolean flag = true;

            for (int j = 0; flag && j <= i - 1; j++) {
                for (int k = 0; flag && k < arr[j].size(); k++) {
                    if (input.equals(arr[j].get(k))) flag = false;
                }
            }

            if (flag) answer++;
        }
        System.out.println(answer);

    }
}