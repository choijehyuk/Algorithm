import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] line = new Stack[7];
        for (int i = 0; i < line.length; i++) {
            line[i] = new Stack<>();
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int lineNum = Integer.parseInt(st.nextToken());
            int fretNum = Integer.parseInt(st.nextToken());

            if (line[lineNum].isEmpty() || line[lineNum].peek() < fretNum) {
                if (!line[lineNum].isEmpty() && line[lineNum].peek() == fretNum) continue;

                line[lineNum].push(fretNum);
                answer++;

                continue;
            }

            while (!line[lineNum].isEmpty() && line[lineNum].peek() > fretNum) {
                line[lineNum].pop();
                answer++;
            }

            if (!line[lineNum].isEmpty() && line[lineNum].peek() == fretNum) continue;
            line[lineNum].push(fretNum);
            answer++;
        }

        System.out.println(answer);

    }
}