import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> musicList = new ArrayList<>();
        int SUNYOUNG = 1;

        for (int i = 1; i <= N; i++) map.put(i, new ArrayList<Integer>());

        for (int i = 0; i < E; i++) {
            int songID = i;
            List<Integer> todayJoinList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            for (int j = 0; j < K; j++) {
                todayJoinList.add(Integer.parseInt(st.nextToken()));
            }

            if (todayJoinList.contains(SUNYOUNG)) {
                musicList.add(songID);
                todayJoinList.forEach(user -> {
                    map.get(user).add(songID);
                });
            } else {
                HashSet<Integer> sharedMusicList = new HashSet<>();
                todayJoinList.forEach(user -> {
                    sharedMusicList.addAll(map.get(user));
                });
                todayJoinList.forEach(user -> {
                    map.put(user, new ArrayList<>(sharedMusicList));
                });
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key).size() == musicList.size()) {
                sb.append(key).append("\n");
            }
        }
        System.out.println(sb);
    }
}