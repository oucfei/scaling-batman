package questions;

public class SearchingQuestions {
    public static int[] searchRange(int[] nums, int target) {
        if(nums== null || nums.length <1) return new int[]{-1, -1};
        int[] ret = new int[2];
        ret[0] = -1;
        ret[1] = -1;
        
        search(nums, 0, nums.length-1, target, ret);
        
        return ret;
    }
    
    private static void search(int[] nums, int start, int end, int target, int[] ret){
        if(start > end){
            return;
        }
        int mid = (start + end)/2;
        if(nums[mid] > target ){
            search(nums, start, mid-1, target, ret);
        }else if(nums[mid] < target){
            search(nums, mid+1, end, target, ret);
        }else{
            if(mid == start || nums[mid-1] < nums[mid] ){
                ret[0] = mid;
            }
            if(mid == end || nums[mid] < nums[mid+1]){
                ret[1] = mid;
            }
            
            search(nums, mid+1, end, target, ret);
            search(nums, start, mid-1, target, ret);
        }
    }
}
