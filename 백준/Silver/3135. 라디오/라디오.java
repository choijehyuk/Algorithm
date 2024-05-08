import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int min = Math.abs(A - B);

        for (int i = 0; i < N; i++) {
            min = Math.min(min, Math.abs(arr[i] - B));
        }

        if (min == Math.abs(A - B)) System.out.println(Math.abs(A - B));
        else System.out.println(min + 1);


    }
}