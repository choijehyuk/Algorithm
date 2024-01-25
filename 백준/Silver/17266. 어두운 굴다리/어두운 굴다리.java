import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = N;
        int answer = 0;

        while (left <= right){
            int mid = (left + right) / 2;
            boolean flag = false;

            int lamp = 0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] - mid  <= lamp){
                    lamp = arr[i] + mid;
                }
                else{
                    flag = true;
                }
            }
            if( N - lamp > 0) flag = true;
            else flag = false;

            if(!flag){
                answer = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}