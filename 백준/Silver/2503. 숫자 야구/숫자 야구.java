import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            arr[i][0] = num;
            arr[i][1] = strike;
            arr[i][2] = ball;
        }

        int temp = 102;
        while(temp < 1000){
            int hun = temp / 100;
            int ten = temp / 10 - hun * 10;
            int one = temp % 10;

            if(hun == ten || ten == one || one == hun || ten == 0 || one == 0){
                temp++;
                continue;
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                int numhun = arr[i][0] / 100;
                int numten = arr[i][0] / 10 - numhun * 10;
                int numone = arr[i][0] % 10;

                int str = 0;
                int ba = 0;

                if( hun == numhun) {
                    str++;
                }
                if(ten == numten){
                    str++;
                }
                if(one == numone){
                    str++;
                }
                if(hun == numten || hun == numone){
                    ba++;
                }
                if(ten == numhun || ten == numone){
                    ba++;
                }
                if(one == numhun || one == numten){
                    ba++;
                }

                if(arr[i][1] == str && arr[i][2] == ba){
                    cnt++;
                }
            }
            if(cnt == N){
                answer++;
            }
            temp++;
        }

        System.out.println(answer);
    }
}