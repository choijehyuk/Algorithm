import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[] memberCnt = new int[N+1];
            int[] teamScore = new int[N+1];
            int[] fiveMan = new int[N+1];
            int[] inputCnt = new int[N+1];

            int[] input = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int teamNum = Integer.parseInt(st.nextToken());

                memberCnt[teamNum]++;
                input[i] = teamNum;
            }

            int idx = 1;
            for (int i = 1; i <= N; i++) {
                int teamNum = input[i];

                // 6명 팀원 있을 때
                if (memberCnt[teamNum] == 6) {
                    inputCnt[teamNum]++;
                    if (inputCnt[teamNum] == 5) {
                        fiveMan[teamNum] = idx;
                    }
                    if (inputCnt[teamNum] <= 4) {
                        teamScore[teamNum] += idx;
                    }
                    idx++;
                }
            }

            int minScore = Integer.MAX_VALUE;
            int winTeam = 0;

            for (int i = 0; i < N; i++) {
                if (teamScore[i] != 0) {
                    if (minScore == teamScore[i]) {
                        if (fiveMan[winTeam] > fiveMan[i]) {
                            winTeam = i;
                        }
                        continue;
                    } else if (minScore < teamScore[i]) {
                        continue;
                    } else {
                        minScore = teamScore[i];
                        winTeam = i;
                    }

                }
            }

            sb.append(winTeam + "\n");
        }
        System.out.println(sb);
    }
}