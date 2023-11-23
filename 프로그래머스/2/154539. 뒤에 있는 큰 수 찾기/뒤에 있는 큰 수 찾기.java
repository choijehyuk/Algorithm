import java.util.*;
import java.io.*;

class Solution {

    static class Point implements Comparable<Point> {
        int num, idx;
        public Point(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point other) {
            return Integer.compare(this.num, other.num);
        }
    }
    
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        PriorityQueue<Point> q = new PriorityQueue<>();
        
        Arrays.fill(answer, -1);
        for(int i = 0; i < numbers.length; i++){
            int check = numbers[i];
            q.add(new Point(check,i));
            
            int size = q.size();
            for(int j = 0; j < size; j++){
                Point p = q.poll();

                if(p.num < check){
                    answer[p.idx] = check;
                }
                else{
                    q.add(new Point(p.num, p.idx));
                    break;
                }
            }
        }
        
        return answer;
    }
}