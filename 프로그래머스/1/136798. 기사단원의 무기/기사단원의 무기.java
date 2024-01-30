class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++){
            int cnt = 0;
            boolean flag = false;
            for(int j = 1; j * j <= i; j++){
                if(j * j == i) cnt++;
                else if(i % j == 0) cnt += 2;
            }
            //System.out.print(cnt + " ");
            if(cnt > limit) answer += power;
            else answer += cnt;
        }
        return answer;
    }
}