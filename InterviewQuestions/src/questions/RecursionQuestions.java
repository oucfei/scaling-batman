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
}
