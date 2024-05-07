import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            
            for (int j = 0; j < size; j++) arr[i].add(Integer.parseInt(st.nextToken()));

            Collections.sort(arr[i], Comparator.reverseOrder());

            int diff = arr[i].get(0) - arr[i].get(1);
            for (int k = 1; k < size; k++) diff = Math.max(diff, arr[i].get(k - 1) - arr[i].get(k));

            sb.append("Class ").append(i + 1).append('\n');
            sb.append("Max ").append(arr[i].get(0)).append(", ")
                    .append("Min ").append(arr[i].get(size - 1)).append(", ")
                    .append("Largest gap ").append(diff).append('\n');
        }

        System.out.print(sb);
    }
}