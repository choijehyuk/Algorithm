class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        // 7 하고 3 
        // idx 가 3까지 
        int idx = 0;
        while(idx + p.length() <= t.length()){
            boolean isBig = true;
    
            for(int i = idx; i < idx + p.length(); i++){
                if(t.charAt(i) < p.charAt(i-idx)){
                    break;
                }
                else if(t.charAt(i) > p.charAt(i-idx)){
                    isBig = false;
                    break;
                }
            }
            
            if(isBig){
                answer++;
            }
            idx++;
        }
        return answer;
    }
}