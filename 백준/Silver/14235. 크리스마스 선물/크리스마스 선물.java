import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());

            if(input == 0){
                if(q.isEmpty()){
                    System.out.println("-1");
                }
                else{
                    System.out.println(q.poll());
                }
            }
            else{
                while(st.hasMoreTokens()){
                    int gift = Integer.parseInt(st.nextToken());
                    q.add(gift);
                }
            }

        }
    }
}