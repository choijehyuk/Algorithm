import java.util.*;
import java.io.*;

class Solution {
    static int[][] routes;
    static List<Integer> list;
    public int solution(int[][] routes) {
        
        this.routes = routes;
        list = new ArrayList<>();
        
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        
        for(int i = 0; i < routes.length; i++) {
            int min = routes[i][0];
            int max = routes[i][1];
            
            boolean flag = false;
            for(int j = 0; j < list.size(); j++) {
                if(list.get(j) >= min && list.get(j) <= max) {
                    flag = true;
                    break;
                }
            }
            if(!flag) list.add(max);
        }
        
        int answer = list.size();
        System.out.println(list.size());
        
        return answer;
        
    }
}