import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String , Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            if(s.length() < M){
                continue;
            }
            // 주어진 단어 길이보다 길 때
            else{
                // 이미 있으면
                if(map.containsKey(s)){
                    int val = map.get(s).intValue();
                    map.put(s,val+1);
                }
                else{
                    map.put(s,1);
                }
            }
        }


        List<String> keySet = new ArrayList<>(map.keySet());

        keySet.sort((o1, o2) -> {
            // 1. 자주 나오는 단어일수록 앞에 배치
            if (map.get(o1) != map.get(o2)) {
                return map.get(o2).compareTo(map.get(o1));
            }
            // 2. 해당 단어의 길이가 길수록 앞에 배치
            else if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }
            // 3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치
            else {
                return o1.compareTo(o2);
            }
        });


        for (String s : keySet) {
            sb.append(s + "\n");
        }
        //System.out.println(map);
        System.out.println(sb);
    }
}