import java.io.*;
import java.util.*;

public class Main {
    static class Taxi {
        int passengerR, passengerC, destinationR, destinationC;

        public Taxi(int passengerR, int passengerC, int destinationR, int destinationC) {
            this.passengerR = passengerR;
            this.passengerC = passengerC;
            this.destinationR = destinationR;
            this.destinationC = destinationC;
        }
    }

    static class Node implements Comparator<Node> {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.r == o2.r) return Integer.compare(o1.c, o2.c);
            return Integer.compare(o1.r, o2.r);
        }
    }

    static int N, M, fuel;
    static int[][] map;
    static boolean[][] v;
    static boolean[] passenger;
    static boolean[] destination;
    static int startX, startY;
    static ArrayList<Taxi> list;
    static int idx;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static boolean flag;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        list = new ArrayList<>();
        passenger = new boolean[M + 2];
        destination = new boolean[M + 2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int passengerR = Integer.parseInt(st.nextToken()) - 1;
            int passengerC = Integer.parseInt(st.nextToken()) - 1;
            int destinationR = Integer.parseInt(st.nextToken()) - 1;
            int destinationC = Integer.parseInt(st.nextToken()) - 1;
            map[passengerR][passengerC] = 2 + i;

            list.add(new Taxi(passengerR, passengerC, destinationR, destinationC));
        }

        //print(map);

        int cnt = list.size();

        while (cnt > 0) {
            findPassenger(startX, startY);
            cnt--;
            if (fuel < 0) break;

            //System.out.println("afterFind" + fuel);
        }

        if (!flag) {
            System.out.println("-1");
            System.exit(0);
        }

        boolean isGo = true;

        for (int i = 0; i < destination.length - 2; i++) {
//            System.out.println(passenger[i]);
//            System.out.println(destination[i]);
//            System.out.println();
            if (!passenger[i] || !destination[i]) {
                isGo = false;
                break;
            }
        }

        if (!isGo) {
            System.out.println("-1");
            System.exit(0);
        }

        System.out.println(fuel);

    }

    private static void print(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void findPassenger(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        v = new boolean[N][N];
        fuel++;

        flag = true;

        ArrayList<Node> passengerList = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();

            fuel--;
            if (fuel < 0) return;
            //System.out.println();

            for (int i = 0; i < size; i++) {
                Node cur = q.poll();

                //System.out.println(cur.r + " " + cur.c + " " + fuel);

                // 승객 찾음
                if (map[cur.r][cur.c] != 0 && map[cur.r][cur.c] != 1 && !passenger[map[cur.r][cur.c] - 2]) {
                    passengerList.add(new Node(cur.r, cur.c));
                    //System.out.println("원래 들어가던거" + (map[cur.r][cur.c] - 2));
                    //findDestination(cur.r, cur.c, map[cur.r][cur.c] - 2);
                    //System.out.println("map" + (map[cur.r][cur.c] - 2));
                    //passenger[map[cur.r][cur.c] - 2] = true;
                    continue;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];

                    if (!isRange(nr, nc)) continue;
                    if (map[nr][nc] == 1) continue;
                    if (v[nr][nc]) continue;

                    q.add(new Node(nr, nc));
                    v[nr][nc] = true;

                }
            }
            if (!passengerList.isEmpty()) {
                break;
            }
        }

        if (passengerList.isEmpty()) {
            flag = false;
            return;
        }

        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        int index = 0;
        //System.out.println("패신저리스트 사이즈 " + passengerList.size());
        for (int i = 0; i < passengerList.size(); i++) {
            if (passengerList.get(i).r < minR) {
                minR = passengerList.get(i).r;
                minC = passengerList.get(i).c;
                index = i;
            } else if (passengerList.get(i).r == minR) {
                if (passengerList.get(i).c < minC) {
                    minR = passengerList.get(i).r;
                    minC = passengerList.get(i).c;
                    index = i;
                }
            }
        }

        //System.out.println("index : " + (map[minR][minC] -2));
        passenger[map[minR][minC] - 2] = true;
        findDestination(minR, minC, map[minR][minC] - 2);
    }

    private static void findDestination(int r, int c, int idx) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        v = new boolean[N][N];
        int beforeFuel = fuel;

        fuel++;

        //System.out.println(beforeFuel);
        while (!q.isEmpty()) {

            int size = q.size();
            fuel--;
            if (fuel < 0) return;

            for (int i = 0; i < size; i++) {
                Node cur = q.poll();

                // 목적지 찾음
                if (cur.r == list.get(idx).destinationR && cur.c == list.get(idx).destinationC) {
                    startX = cur.r;
                    startY = cur.c;
                    //System.out.println(beforeFuel + " " + fuel + "idx: " + idx);
                    fuel += (beforeFuel - fuel) * 2;
                    destination[idx] = true;
                    return;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];

                    if (!isRange(nr, nc)) continue;
                    if (map[nr][nc] == 1) continue;
                    if (v[nr][nc]) continue;

                    q.add(new Node(nr, nc));
                    v[nr][nc] = true;
                }
            }
        }
        flag = false;
    }

    private static boolean isRange(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
        return false;
    }

}