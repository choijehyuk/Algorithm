import java.util.*;
import java.io.*;

class Solution {
    static int robotX, robotY;
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        char[][] map = new char[park.length][park[0].length()];
        
        for(int i = 0; i < park.length; i++){
            String s = park[i];
            for(int j = 0 ; j < park[0].length(); j ++){
                char c = s.charAt(j);
                map[i][j] = c;
                if(map[i][j] == 'S'){
                    robotX = i;
                    robotY = j;
                }
            }
        }
        
        for(int i = 0; i < park.length; i ++){
            for(int j = 0; j < park[0].length(); j ++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        
        for(int i = 0; i < routes.length; i++){
            String s = routes[i];
            
            boolean isGo = true;
            
            if(s.charAt(0) == 'N'){
                if(robotX - (s.charAt(2) - '0') >= 0){
                    for(int j = 0; j <= (s.charAt(2) - '0'); j++){
                        if(map[robotX - j][robotY] == 'X'){
                            isGo = false;
                            break;
                        }
                    }
                }
                else{
                    isGo = false;
                }
                if(isGo){
                    robotX -= (s.charAt(2) - '0');
                }
            }
            else if(s.charAt(0) == 'S'){
                if(robotX + (s.charAt(2) - '0') < park.length){
                    for(int j = 0; j <= (s.charAt(2) - '0'); j++){
                        if(map[robotX + j][robotY] == 'X'){
                            isGo = false;
                            break;
                        }
                    }
                }
                else{
                    isGo = false;
                }
                if(isGo){
                    robotX += (s.charAt(2) - '0');
                }
            }
            else if(s.charAt(0) == 'W'){
                if(robotY - (s.charAt(2) - '0') >= 0){
                    for(int j = 0; j <= (s.charAt(2) - '0'); j++){
                        if(map[robotX][robotY - j] == 'X'){
                            isGo = false;
                            break;
                        }
                    }
                }
                else{
                    isGo = false;
                }
                if(isGo){
                    robotY -= (s.charAt(2) - '0');
                }                
            }
            else if(s.charAt(0) == 'E'){
                if(robotY + (s.charAt(2) - '0') < park[0].length()){
                    for(int j = 0; j <= (s.charAt(2) - '0'); j++){
                        if(map[robotX][robotY + j] == 'X'){
                            isGo = false;
                            break;
                        }
                    }
                }
                else{
                    isGo = false;
                }
                if(isGo){
                    robotY += (s.charAt(2) - '0');
                }                 
            }
            System.out.println(robotX + " " + robotY);
        }
        answer[0] = robotX;
        answer[1] = robotY;
        return answer;
    }
    
    
    
}