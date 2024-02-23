import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> groupMap = new HashMap<>();
        HashMap<String, String[]> memberMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String group = br.readLine();
            int num = Integer.parseInt(br.readLine());

            String[] str = new String[num];
            for (int j = 0; j < num; j++) {
                String name = br.readLine();
                groupMap.put(name, group);
                str[j] = name;
                //memberMap.put(group,name);
            }
            memberMap.put(group, str);

        }


        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            int quiz = Integer.parseInt(br.readLine());

            if (quiz == 0) {
                ArrayList<String> list = new ArrayList<>();
                String[] answer = memberMap.get(input);
                for (String string : answer) {
                    list.add(string);
                }
                Collections.sort(list);
                for (String string : list) {
                    sb.append(string).append("\n");
                }
            } else if (quiz == 1) {
                sb.append(groupMap.get(input)).append("\n");
            }
        }
        System.out.println(sb);
    }
}