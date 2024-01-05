import java.util.*;
import java.io.*;

class Solution {
    static class Point{
        int r,c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static char[][] map;
    public int[] solution(String[] maps) {
        int[] answer = new int[10000];
        
        boolean[][] v = new boolean[maps.length][maps[0].length()];
        int idx = 0;
        map = new char[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++){
            String s = maps[i];
            for(int j = 0; j < maps[0].length(); j++){
                char c = maps[i].charAt(j);
                map[i][j] = c;
            }
        }
        for(int i = 0; i< maps.length; i++){
            String s = maps[i];
            for(int j = 0; j < maps[0].length(); j++){
                char c = maps[i].charAt(j);
                if(!v[i][j] && c != 'X'){
                    bfs(maps,v,i,j,idx,answer, map);
                    idx++;
                }
            }
        }
        
        if(answer[0] == 0){
            answer = new int[1];
            answer[0] = -1;
        }
        else{
            int end = 0;
            for(int i = 0; i < answer.length; i++){
                if(answer[i] == 0){
                    end = i;
                    break;
                }
            }
            int[] copy = new int[end];
            
            for(int i = 0; i < end; i++){
                copy[i] = answer[i];
            }
            answer = new int[end];
            for(int i = 0 ; i < end; i++){
                answer[i] = copy[i];
            }
            Arrays.sort(answer);
            
        }
        
        return answer;
    }
    
    private static void bfs(String[] maps, boolean[][] v, int r , int c, int idx, int[] answer, char[][] map){
        Queue<Point> q = new LinkedList<>();
        v[r][c] = true;
        q.add(new Point(r,c));
        int cnt = 0;
        
        while(!q.isEmpty()){
            Point p = q.poll();
            cnt+= (int)map[p.r][p.c] - 48;
            for(int d = 0; d < 4; d++){
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                
                if(nr >=0 && nr < maps.length && nc >= 0 && nc < maps[0].length() && !v[nr][nc] && map[nr][nc] != 'X'){
                    q.add(new Point(nr,nc));
                    v[nr][nc] = true;
                }
            }
        }
        
        answer[idx] = cnt;
    }
}