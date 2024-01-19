class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        char[][] map = new char[wallpaper.length][wallpaper[0].length()];
        
        for(int i = 0; i < wallpaper.length; i++){
            String s = wallpaper[i];
            for(int j = 0; j < wallpaper[0].length(); j++){
                map[i][j] = s.charAt(j);
            }
        }
        
        int minx = Integer.MAX_VALUE;
        int miny = Integer.MAX_VALUE;
        int maxx = 0;
        int maxy = 0;
        
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[0].length(); j++){
                if(map[i][j] == '#'){
                    System.out.println(i + " " + j);
                    minx = Math.min(i,minx);
                    miny = Math.min(j,miny);
                    maxx = Math.max(i,maxx);
                    maxy = Math.max(j,maxy);
                }
            }
        }

        // for(int i = 0; i < wallpaper.length; i++){
        //     for(int j = 0; j < wallpaper[0].length(); j++){
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        
        answer[0] = minx;
        answer[1] = miny;
        answer[2] = maxx + 1;
        answer[3] = maxy + 1;
                
        
        return answer;
    }
}