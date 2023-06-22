import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int[] A;
    static int[] B;
    static ArrayList<Integer> subA;
    static ArrayList<Integer> subB;
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());


        A = new int[Integer.parseInt(br.readLine()) + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < A.length; i++) {
            A[i]  = Integer.parseInt(st.nextToken());
        }

        B = new int[Integer.parseInt(br.readLine()) + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < B.length; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        subA = new ArrayList<>();
        for (int i = 1; i < A.length ; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                subA.add(sum);
            }
        }

        subB = new ArrayList<>();
        for (int i = 1; i < B.length; i++) {
            int sum = 0;
            for (int j = i; j < B.length; j++) {
                sum += B[j];
                subB.add(sum);
            }
        }
        Collections.sort(subA);
        Collections.sort(subB);

        int left = 0;
        int right = 0;
        int mid = 0;
        for (int i = 0; i < subA.size(); i++) {
            left = 0;
            right = subB.size();

            while(left < right){
                mid = (left + right) / 2;
                if(subA.get(i) + subB.get(mid) <= T){
                    left = mid +1;
                }
                else {
                    right = mid;
                }
            }
            answer += left;

            left = 0;
            right = subB.size();

            while(left < right){
                mid = (left + right) / 2;
                if(subA.get(i) + subB.get(mid) >= T){
                    right = mid;
                }
                else{
                    left = mid +1;
                }
            }
            answer -= left;

        }

        System.out.println(answer);





    }
}