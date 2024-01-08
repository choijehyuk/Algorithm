class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int right = 1;
        int min = Integer.MAX_VALUE;
        int sum = sequence[left];
        
        while(left < right){

            if(sum == k){
                if(right - left - 1 < min){
                    min = right - left - 1;
                    answer[0] = left;
                    answer[1] = right - 1;
                }
                sum -= sequence[left++];
            }
            else if(sum > k){
                sum -= sequence[left++];
            }
            else if(right < sequence.length){
                sum += sequence[right++];
            }
            else{
                break;
            }
            
        }
        
        return answer;
    }
}