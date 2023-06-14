import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static List<Integer>[] list;
    public static int[] cnt;
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        list = new ArrayList[n+1];

        for(int i=0;i<=n;i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<m;i++){
            String[] data = br.readLine().split(" ");
            int a = Integer.parseInt(data[0]);
            int b = Integer.parseInt(data[1]);
            list[a].add(b);

        }

        cnt = new int[n+1];

        for(int i=1;i<=n;i++){
            bfs(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int max_value = 0;
        for(int i=1;i<=n;i++){
            if(cnt[i] > max_value){
                max_value = cnt[i];
                ans.clear();
                ans.add(i);
            } else if (cnt[i] == max_value){
                ans.add(i);
            }
        }

        for(int a:ans){
            System.out.print(a+" ");
        }


    }

    public static void bfs(int start){
        boolean[] v = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        v[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int num : list[x]) {
                if (!v[num]) {
                    cnt[num]++;
                    v[num] = true;
                    q.offer(num);
                }
            }
        }


    }

}