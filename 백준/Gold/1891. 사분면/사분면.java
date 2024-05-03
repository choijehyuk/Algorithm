import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken());
        String piece = st.nextToken();

        st = new StringTokenizer(br.readLine());
        long y = Long.parseLong(st.nextToken());
        long x = -(Long.parseLong(st.nextToken()));

        long dx = 0;
        long dy = 0;

        for (int i = 0; i < piece.length(); i++) {
            char c = piece.charAt(i);

//            if (c == '1') dy += (long) Math.pow(2, piece.length() - 1 - i);
//            else if (c == '3') dx = (long) Math.pow(2, piece.length() - 1 - i);
//            else if (c == '4') {
//                dx += (long) Math.pow(2, piece.length() - 1 - i);
//                dy += (long) Math.pow(2, piece.length() - 1 - i);
//            }

            if (c == '1') {
                long shift = piece.length() - 1 - i;
                long val = 1L << shift;
                y += val;
            } else if (c == '3') {
                long shift = piece.length() - 1 - i;
                long val = 1L << shift;
                x += val;
            } else if (c == '4') {
                long shift = piece.length() - 1 - i;
                long val = 1L << shift;
                x += val;
                y += val;
            }
        }

        dx += x;
        dy += y;

        //System.out.println(dx + "  " + dy + " " + (long)Math.pow(2, piece.length()));

        if (dx < 0 || dx >= (long) Math.pow(2, piece.length()) || dy < 0 || dy >= (long) Math.pow(2, piece.length()))
            sb.append("-1");
        else {
            char[] answer = new char[piece.length()];

            for (int i = piece.length() - 1; i >= 0; i--) {
                if (dx % 2 == 0) {
                    if (dy % 2 == 0) {
                        answer[i] = '2';
                    } else {
                        answer[i] = '1';
                    }
                } else {
                    if (dy % 2 == 0) {
                        answer[i] = '3';
                    } else {
                        answer[i] = '4';
                    }
                }

                dx /= 2;
                dy /= 2;
            }

            for (int i = 0; i < piece.length(); i++) {
                sb.append(answer[i]);
            }

        }
        System.out.println(sb);
    }
}