class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int end = section[section.length-1];
        
        boolean[] v = new boolean[end+1];
        for(int i = 0; i < section.length; i++){
            v[section[i]] = true;
        }
        
        for(int i = 0; i < v.length; i++){
            if(v[i]){
                for(int j = 0; j < m; j++){
                    if(i + j < v.length){
                        v[i + j] = false;    
                    }
                }
                answer++;
            }
        }
        
        return answer;
    }
}