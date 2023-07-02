    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Main {


        static int A, B;
        static int answer;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuffer sb = new StringBuffer();

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());


            while(A != B){
                if( A > B){
                    System.out.println(-1);
                    System.exit(0);
                }
                if(B % 10 == 1)
                    B /= 10;
                else if(B % 2 == 0)
                    B /= 2;
                else{
                    System.out.println(-1);
                    System.exit(0);
                }
                answer++;
            }

            System.out.println(answer+1);
        }

    }