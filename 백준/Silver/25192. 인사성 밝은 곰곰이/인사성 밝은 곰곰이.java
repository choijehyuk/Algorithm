import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            if(!s.equals("ENTER")){
                map.put(s,i);
            }
            else{
                if(map!= null){
                    for (String s1 : map.keySet()) {
                        cnt++;
                    }
                }
                map = new HashMap<>();
            }
        }

        for (String s : map.keySet()) {
            cnt++;
        }

        System.out.println(cnt);
    }

}