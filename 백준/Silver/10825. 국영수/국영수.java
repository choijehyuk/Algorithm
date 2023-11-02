import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Point {
        String name;
        int korea, english, math;

        public Point(String name, int korea, int english, int math) {
            this.name = name;
            this.korea = korea;
            this.english = english;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        ArrayList<Point> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int korea = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            list.add(new Point(name, korea, english, math));
        }


        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int ret = 0;

                if (o2.korea - o1.korea > 0) {
                    ret = 1;
                } else if (o2.korea - o1.korea < 0) {
                    ret = -1;
                } else {
                    if (o2.english - o1.english < 0) {
                        ret = 1;
                    } else if (o2.english - o1.english > 0) {
                        ret = -1;
                    } else {
                        if (o2.math - o1.math > 0) {
                            ret = 1;
                        } else if (o2.math - o1.math < 0) {
                            ret = -1;
                        } else {
                            int len = Math.min(o2.name.length(), o1.name.length());

                            for (int i = 0; i < len; i++) {
                                if (o2.name.charAt(i) - o1.name.charAt(i) < 0) {
                                    ret = 1;
                                    break;
                                } else if(o2.name.charAt(i) - o1.name.charAt(i) > 0) {
                                    ret = -1;
                                    break;
                                }
                                else{
                                    continue;
                                }
                            }
                        }
                    }
                }
                return ret;
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(list.get(i).name);
        }
    }


}