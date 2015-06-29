package questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

//The problems below should all come from Leetcode.
public class InterviewQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s =MathProblems.romanToInteger("MCMXCVI");
		System.out.print(s);
		
	}


  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  private static final int MaxDiv10 = Integer.MAX_VALUE/10;

  public int myAtoi(String str) {
      int number=0;
      int len = str.length();
      int i = 0;
      while(i < len && Character.isWhitespace(str.charAt(i))) i++;
      int sign = 1;
      if( i < len && str.charAt(i) == '+'){
          i++;
      }else if(i<len && str.charAt(i) == '-'){
          i++;
          sign = -1;
      }
      while(i<len && Character.isDigit(str.charAt(i))){
          int digit = Character.getNumericValue(str.charAt(i));
          if(number > MaxDiv10 || (number == MaxDiv10)&&(digit >= 8)){
              return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
          }
          number = number * 10 + digit;
          i++;
      }
      return number * sign;
  }
  
    public static int SearchInRotatedSortedArray(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] <= nums[r]){
                if(target > nums[mid] && target <= nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }else{
                if(target >=nums[l] && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        
        return -1;
    }
    
    public static int FindMinimumInRotatedSortedArray(int[] nums) {
        int L = 0, R = nums.length - 1;
        while( L < R){
            int mid = L + (R-L)/2;
            if(nums[mid] <= nums[R]){
                R = mid;
            }else{
                L = mid + 1;
            }
        }
        
        return nums[L];
    }

    public boolean SearchA2DMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0||matrix==null)
            return false;
            
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int low = 0;
        int high = rows*cols-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            int midValue = matrix[mid/cols][mid%cols];
            if(midValue == target)
                return true;
            else if(midValue < target)
                low = mid+1;
            else
                high = mid-1;
        }
        return false;
    }
    private static int rand7(){
    	Random rand = new Random(); 
    	int randomNum = rand.nextInt((7-1) + 1) + 1;    
    	return randomNum;
    }
    
    //Rejection Sampling from leetcode articles
    //http://articles.leetcode.com/2010/11/rejection-sampling.html
    public static int rand10(){
    	int result = 0;
    	int idx = 0;
    	do{
    		int col = rand7();
    		int row = rand7();
    		idx = col + (row-1) * 7;
    	}while(idx > 40);
    	
    	result = (idx-1)%10 + 1;
    	return result;
    }
    
    public static int rand10_better(){
    	int col = rand7();
    	int row = rand7();
    	int idx = col + (row-1) * 7;
    	if(idx<=40){
    		return 1 + (idx - 1)%10;
    	}
    	col = idx - 40;
    	row = rand7();
    	idx = col + (row-1)*7;
    	if(idx <=60){
    		return 1 + (idx - 1)%10;
    	}
    	col = idx - 60;
    	do{
    	row = rand7();
    	idx = col + (row-1)*7;
    	}while(idx >20);
    	
    	return 1 + (idx - 1)%10;
    }
    
    public static void SetMatrixZeroes(int[][] matrix) {
        if(matrix == null) return;
        List<Integer> zeroRows = new ArrayList<Integer>();
        List<Integer> zeroCols = new ArrayList<Integer>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }
        
        for(int i=0; i<zeroRows.size(); i++){
            int row = zeroRows.get(i);
            for(int j = 0; j<matrix[0].length;j++){
                matrix[row][j] = 0;
            }
        }
        for(int i=0; i<zeroCols.size(); i++){
            int col = zeroCols.get(i);
            for(int j = 0; j<matrix.length;j++){
                matrix[j][col] = 0;
            }
        }
        
        /*
        if(matrix == null) return;
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(rows[i] == 1 || cols[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
         * 
         */
    }

    public static boolean JumpGame(int[] nums) {
    	//Greedy. Reference:http://www.cnblogs.com/yuzhangcmu/p/4039840.html
        if(nums == null || nums.length == 0) return false;
        
        int lastIndex = nums.length - 1;
        int right = 0;
        for(int i=0; i<nums.length; i++){
            right = Math.max(right, i + nums[i]);
            
            if(right == lastIndex)
                return true;
                
            if(right == i)
                return false;
        }
        
        return true;
    }

    public static ListNode RotateList(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int len = 1;
        ListNode p = head;
        while(p.next!=null){
            len++;
            p = p.next;
        }
        k = k%len;
        
        ListNode tail = head;
        for(int i = 0; i<len - k -1; i++){
            tail = tail.next;
        }
        
        p.next = head;
        head = tail.next;
        tail.next = null;
        
        return head;
    } 

    public ListNode reverseList(ListNode head) {
    	//ReverseLinkedList
        /*   if(head == null) return null;
           if(head.next == null) return head;
           
           ListNode secondNode = head.next;
           head.next = null;
           
           ListNode reversed = reverseList(secondNode);
           
           secondNode.next = head;
           
           return reversed;
       */
       
       ListNode prev = null, p = head;
       
       while(p != null){
           ListNode q = p.next;
           p.next = prev;
           prev = p;
           p = q;
       }
       return prev;
       
       }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	//(Contains Duplicate 2)
         HashSet<Integer> set = new HashSet<>();
         
         for(int i=0; i<nums.length; i++){
             if(set.contains(nums[i])){
                 return true;
             }else{
                 set.add(nums[i]);
                 if(i>=k){
                     set.remove(nums[i-k]);
                 }
             }
         }
         return false;
    }

    public static void RotateArray(int[] nums, int k) {
        if(nums == null) return;
        int n = nums.length;
        k = k%n;
        
        reverseArray(nums, 0, n-1);
        reverseArray(nums, 0, k-1);
        reverseArray(nums, k, n-1);
        
    }
    
    private static void reverseArray(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++; end--;
        }
    }
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if(nums.length == 0) return result;
        for(int i=0; i<nums.length; i++){
            int k = i;
            int j = i + 1;
            while(j < nums.length && nums[j] == nums[i] + 1){
                j++;
                i++;
            }
            
            j--;
            
            if(k == j){
                result.add(Integer.toString(nums[k]));
            }else{
                String s = Integer.toString(nums[k]) + "->" + Integer.toString(nums[j]);
                result.add(s);
            }
        }
        
        return result;
    }
  
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        while(i<=j){
            if(nums[i] == val){
                nums[i] = nums[j];
                j--;
            }else{
                i++;
            }
        }
        return ++j;
    }


}
