import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, k;
    static int[] arr;
    static int[] sel;
    static boolean[] v;
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        set = new HashSet<>();
        arr = new int[n];
        sel = new int[k];
        v = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0);

        System.out.println(set.size());
    }

    private static void dfs(int depth) {
        if (depth == k) {
            String s = "";
            for (int i = 0; i < sel.length; i++) {
                s += sel[i];
            }
            set.add(Integer.parseInt(s));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                v[i] = true;
                sel[depth] = arr[i];
                dfs(depth + 1);
                v[i] = false;
            }
        }
    }

}