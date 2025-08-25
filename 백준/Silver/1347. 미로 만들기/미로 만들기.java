import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Main {
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());

        String move = br.readLine();

        int dir = 2;

        int nowX = 0;
        int nowY = 0;

        int maxX = 0;
        int maxY = 0;
        int minX = 0;
        int minY = 0;

        List<Node> list = new ArrayList<>();
        list.add(new Node(0, 0));

        for (int i = 0; i < move.length(); i++) {
            char c = move.charAt(i);

            if (c == 'L') {
                dir = (dir + 3) % 4;
            } else if (c == 'R') {
                dir = (dir + 1) % 4;
            }

            if (c == 'F') {
                if (dir == 0) {
                    nowX -= 1;
                    minX = Math.min(minX, nowX);
                } else if (dir == 1) {
                    nowY += 1;
                    maxY = Math.max(maxY, nowY);
                } else if (dir == 2) {
                    nowX += 1;
                    maxX = Math.max(maxX, nowX);
                } else if (dir == 3) {
                    nowY -= 1;
                    minY = Math.min(minY, nowY);
                }

                list.add(new Node(nowX, nowY));
            }
        }

        char[][] map = new char[maxX - minX + 1][maxY - minY + 1];
        for (int i = 0; i < maxX - minX + 1; i++) {
            for (int j = 0; j < maxY - minY + 1; j++) {
                map[i][j] = '#';
            }
        }

//        System.out.println(maxX  + " " + minX + " " + maxY + " " + minY);

        int printX = 0;
        int printY = 0;
        if (minX < 0) {
            printX = minX * -1;
        }
        if (minY < 0) {
            printY = minY * -1;
        }
        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).r + " " + list.get(i).c);
            map[list.get(i).r + printX][list.get(i).c + printY] = '.';
        }

        print(map, (maxX - minX + 1), (maxY - minY + 1));
    }

    private static void print(char[][] map, int nr, int nc) {
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }


}
