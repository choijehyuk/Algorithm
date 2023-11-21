import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int K = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            list.add(Integer.parseInt(st.nextToken()));
        }
        int area = 0;
        int newArea = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            int temp = list.get(i) * list.get(i + 1);
            if (temp > area) area = temp;
            newArea += temp;
        }

        newArea += list.get(0) * list.get(5);
        area = Math.max(list.get(0) * list.get(5), area);

        System.out.println(K * (newArea - 2 * area));
    }
}