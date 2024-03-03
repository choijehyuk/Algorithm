import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int[] arr = new int[]{1,1,2,2,2,8};

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 6; i++) {
            int num = Integer.parseInt(st.nextToken());
            System.out.print(arr[i] - num + " ");
        }

    }
}