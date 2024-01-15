import java.util.*;
import java.io.*;

class Solution {
    static class Point{
        String word; int cnt;
        public Point(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
    static boolean[] v;
    static int answer;
    public int solution(String begin, String target, String[] words) {
       
        v = new boolean[words.length];
        bfs(begin, target, words);
        
        return answer;
    }
    
    private static void bfs(String begin, String target, String[] words){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(begin, 0));
        
        while(!q.isEmpty()){
            Point p = q.poll();
            
            //System.out.println(p.word + " " + p.cnt);
            if(p.word.equals(target)){
                answer = p.cnt;
                return;
            }
            
            
            for(int i = 0; i < words.length; i++){
                String trans = words[i];
    
                int cnt = 0;
                for(int j = 0; j < trans.length(); j++){
                    if(p.word.charAt(j) != trans.charAt(j)){
                        cnt++;
                    }
                }
                if(cnt == 1 && !v[i]){
                    v[i] = true;
                    q.add(new Point(trans,p.cnt+1));
                }
            }
        }
    }
}