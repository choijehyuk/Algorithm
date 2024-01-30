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
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s,0) + 1);

        }

        for (int i = 0; i < N - 1; i++) {
            String s = br.readLine();
            map.put(s,map.getOrDefault(s,0)-1);
        }

        for (String string : map.keySet()) {
            if(map.get(string) == 1){
                System.out.println(string);
                break;
            }
        }
    }
}