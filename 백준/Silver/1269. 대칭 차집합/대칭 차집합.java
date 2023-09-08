import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B.length; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> sett = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }

        for (int i = 0; i < B.length; i++) {
            set.remove(B[i]);
        }

        for (int i = 0; i < B.length; i++) {
            sett.add(B[i]);
        }

        for (int i = 0; i < A.length; i++) {
            sett.remove(A[i]);
        }

        System.out.println(set.size() + sett.size());
    }
}