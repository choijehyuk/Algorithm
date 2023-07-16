import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int num = Integer.parseInt(br.readLine());
            int answer = 0;
            while(true){
                if(num == 1){
                    System.out.println(answer);
                    break;
                }

                if(num % 2 == 1){
                    System.out.print(answer + " ");
                }
                answer ++;
                num /= 2;
            }
        }

    }
}
