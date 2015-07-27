package questions;

import java.util.ArrayList;
import java.util.Set;

public class DynamicProgramming {
    public static boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0) return true;
        if(wordDict == null || wordDict.size() == 0) return false;
        
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for(int i=0; i<s.length(); i++){
            
            String temp = s.substring(0, i+1);
            for(int j=0; j<=i; j++){
                if(res[j] && wordDict.contains(temp.substring(j) )){
                    res[i+1] = true;
                }
            }
        }
        
        return res[s.length()];
    }
    
    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle.size()==1)
            return triangle.get(0).get(0);
            
        int[] dp = new int[triangle.size()];

        //initial by last row 
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }
     
        // iterate from last second row
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
     
        return dp[0];
    }
}
