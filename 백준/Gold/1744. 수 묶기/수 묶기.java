import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> minus = new ArrayList<>();
        ArrayList<Integer> plus = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num <= 0) minus.add(num);
            else plus.add(num);
        }

        Collections.sort(minus);
        Collections.sort(plus, Collections.reverseOrder());

        int answer = 0;

        int size = minus.size();
        for (int i = 0; i < size - 1; i += 2) {

            if (size <= 0) break;
            answer += minus.get(0) * minus.get(1);

            minus.remove(0);
            minus.remove(0);
        }

        for (Integer i : minus) {
            answer += i;
        }

        size = plus.size();
        for (int i = 0; i < size - 1; i += 2) {

            if (size <= 1) break;
            if (plus.get(1) == 1) break;
            answer += plus.get(0) * plus.get(1);

            plus.remove(0);
            plus.remove(0);

        }

        for (Integer i : plus) {
            answer += i;
        }

        System.out.println(answer);

    }
}