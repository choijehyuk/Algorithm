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
            ArrayList<String> list = new ArrayList<>();
            ArrayList<String> zerolist = new ArrayList<>();
            ArrayList<String> onelist = new ArrayList<>();
            ArrayList<String> twolist = new ArrayList<>();
            ArrayList<String> threelist = new ArrayList<>();
            ArrayList<String> fourlist = new ArrayList<>();
            ArrayList<String> fivelist = new ArrayList<>();
            ArrayList<String> sixlist = new ArrayList<>();
            ArrayList<String> sevenlist = new ArrayList<>();
            ArrayList<String> eightlist = new ArrayList<>();
            ArrayList<String> ninelist = new ArrayList<>();


            for (int i = 0; i < N; i++) {
                String input = br.readLine();

                if (input.charAt(0) == '0') {
                    zerolist.add(input);
                } else if (input.charAt(0) == '1') {
                    onelist.add(input);
                } else if (input.charAt(0) == '2') {
                    twolist.add(input);
                } else if (input.charAt(0) == '3') {
                    threelist.add(input);
                } else if (input.charAt(0) == '4') {
                    fourlist.add(input);
                } else if (input.charAt(0) == '5') {
                    fivelist.add(input);
                } else if (input.charAt(0) == '6') {
                    sixlist.add(input);
                } else if (input.charAt(0) == '7') {
                    sevenlist.add(input);
                } else if (input.charAt(0) == '8') {
                    eightlist.add(input);
                } else if (input.charAt(0) == '9') {
                    ninelist.add(input);
                }

            }

            sort(zerolist);
            sort(onelist);
            sort(twolist);
            sort(threelist);
            sort(fourlist);
            sort(fivelist);
            sort(sixlist);
            sort(sevenlist);
            sort(eightlist);
            sort(ninelist);


            boolean bool = true;

            bool = sub(zerolist);
            if (!bool){
                sb.append("NO\n");
                continue;
            }

            bool = sub(onelist);
            if (!bool){
                sb.append("NO\n");
                continue;
            }
            bool = sub(twolist);
            if (!bool){
                sb.append("NO\n");
                continue;
            }
            bool = sub(threelist);
            if (!bool){
                sb.append("NO\n");
                continue;
            }
            bool = sub(fourlist);
            if (!bool){
                sb.append("NO\n");
                continue;
            }
            bool = sub(fivelist);
            if (!bool){
                sb.append("NO\n");
                continue;
            }
            bool = sub(sixlist);
            if (!bool){
                sb.append("NO\n");
                continue;
            }
            bool = sub(sevenlist);
            if (!bool){
                sb.append("NO\n");
                continue;
            }
            bool = sub(eightlist);
            if (!bool){
                sb.append("NO\n");
                continue;
            }
            bool = sub(ninelist);
            if (!bool){
                sb.append("NO\n");
                continue;
            }

            if(bool) sb.append("YES\n");
        }

        System.out.println(sb);
    }

    private static boolean sub(ArrayList<String> list) {
        int idx = 0;

        while (idx < list.size()) {
            String check = list.get(idx);
            int size = check.length();

            for (int i = idx + 1; i < list.size(); i++) {
                String num = list.get(i);
                if (num.substring(0, size).equals(check)) {
                    return false;
                }

            }
            idx++;
        }
        return true;
    }

    private static void sort(ArrayList<String> list) {
        Collections.sort(list);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
    }

}