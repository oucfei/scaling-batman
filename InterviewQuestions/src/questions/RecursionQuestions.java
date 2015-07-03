package questions;

import java.util.ArrayList;
import java.util.List;

public class RecursionQuestions {
	

    public double myPow(double x, int n) {
        if( n>=0 ){
            return myPower(x, n);
        }else{
            return 1.00/myPower(x, -n);
        }
    }
    
    private double myPower(double x, int n){
        if(n == 0) return 1;
        if(n == 1) return x;
        
        double half = myPower(x, n/2);
        if(n%2 == 1) {
            return half * half * x;
        }else{
            return half * half;
        }
    }
	
    public static List<List<Integer>> allSubsets = new ArrayList<List<Integer>>();

    public static List<List<Integer>> subsets(int[] nums) {       
        return getSubsets(nums, nums.length - 1);
    }
    
    private static List<List<Integer>> getSubsets(int[] nums, int k){
        if(k == 0){
            allSubsets.add(new ArrayList<Integer>());
        }else{
            int first = nums[k];
            List<List<Integer>> subsets = getSubsets(nums, k - 1);
            allSubsets.addAll(subsets);
            for(List<Integer> subset : subsets){
                subset.add(first);
                allSubsets.add(subset);
            }
        }
        return allSubsets;
    } 

    public static ArrayList<String> letterCombinations(String digits) {
        String[] dic = {" ","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> ret = new ArrayList<String>();
        StringBuilder temp = new StringBuilder(); 
        dfs(digits, dic, 0, temp, ret);
        return ret;
    }
    public static void dfs(String digits, String[] dic, int deep, StringBuilder temp, ArrayList<String> ret){
        if(deep == digits.length()){
            ret.add(temp.toString());
            return;
        }
        else{
            for(int i = 0; i < dic[digits.charAt(deep) - '0'].length(); i++){
                temp.append(dic[digits.charAt(deep) - '0'].charAt(i));
                dfs(digits, dic, deep+1, temp, ret);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
}
