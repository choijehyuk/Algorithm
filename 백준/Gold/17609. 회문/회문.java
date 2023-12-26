import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String word = br.readLine();

            int left = 0;
            int right = word.length() - 1;
            boolean change = false;
            boolean end = false;

            L:
            while (left < right) {
                if (word.charAt(left) == word.charAt(right)) {
                    left++;
                    right--;
                } else if (word.charAt(left) != word.charAt(right) && !change) {
                    boolean isLeft = true;
                    boolean isRight = true;

                    int beforeLeft = left;
                    int beforeRight = right;
                    
                    // 둘다 안될떄
                    if (word.charAt(left + 1) != word.charAt(right) && word.charAt(left) != word.charAt(right - 1)) {
                        sb.append("2\n");
                        end = true;
                        break L;
                    }

                    // 왼쪽
                    if (word.charAt(left + 1) == word.charAt(right)) {
                        left++;
                        change = true;

                        while (left < right) {

                            if (word.charAt(left) == word.charAt(right)) {
                                left++;
                                right--;
                            } else {
                                isLeft = false;
                                break;
                            }
                        }
                    } else {
                        isLeft = false;
                    }

                    left = beforeLeft;
                    right = beforeRight;

                    // 오른쪽
                    if (word.charAt(left) == word.charAt(right - 1)) {
                        right--;
                        change = true;


                        while (left < right) {

                            if (word.charAt(left) == word.charAt(right)) {
                                left++;
                                right--;
                            } else {
                                isRight = false;
                                break;
                            }
                        }

                    } else {
                        isRight = false;
                    }
                    
                    if (isLeft || isRight) {
                        sb.append("1\n");
                        end = true;
                        break L;
                    } else {
                        sb.append("2\n");
                        end = true;
                        break L;
                    }
                }
            }

            if (change && !end) {
                sb.append("1\n");
            } else if (!change && !end) {
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }
}

