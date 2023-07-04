import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuffer sb = new StringBuffer();

            int A= 0, B =0;

            for (int i = 0; i < 4; i++) {
                int score = Integer.parseInt(st.nextToken());
                A += score;
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                int score = Integer.parseInt(st.nextToken());
                B += score;
            }

            if(A >= B){
                System.out.println(A);
            }
            else{
                System.out.println(B);
            }



        }

    }