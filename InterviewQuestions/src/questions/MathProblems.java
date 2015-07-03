package questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MathProblems {
	
    public int TrappingRainWater(int[] height) {
        int len = height.length;
        if(len == 0) return 0;
        int[] left = new int[len];
        int[] right = new int[len];
        
        int max = height[0];
        for(int i=0; i<len; i++){
            left[i] = Math.max(height[i], max);
            max = left[i];
        }
        
        max = height[len-1];
        for(int i=len-1; i>=0; i--){
            right[i] = Math.max(height[i], max);
            max = right[i];
        }
        
        int water = 0;
        for(int i=1; i<len;i++){
            water += Math.min(left[i], right[i]) - height[i];
        }
        
        return water;
    }
    
    public int ContainerWithMostWater(int[] height) {
        if(height == null || height.length == 1){
            return 0;
        }
        int low = 0, high = height.length-1;
        int max = 0;
        while(low<high){
            int area = (high - low) * Math.min(height[high], height[low]);
            max = Math.max(max, area);
            
            if(height[low] < height[high]){
                low++;
            }else{
                high--;
            }
        }
        
        return max;
    }
    public static int CountPrimes(int n){
        if(n<2) return 0;
        
        boolean[] isPrime = new boolean[n];
        for(int i=2; i<n; i++){
            isPrime[i] = true;
        }
        
        for(int i = 2; i*i<n; i++){
            if(isPrime[i]){
                for(int j = i*i; j<n;j += i){
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for(int i=2; i<n; i++){
            if(isPrime[i]){
                count++;
            }
        }
        
        return count;
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        
        while(true){
            int sum = 0;
            while(n>0){
                int digit = n%10;
                sum += digit * digit;
                n /= 10;
            }
            if(sum == 1){ 
            	return true;
            }
            if(set.contains(sum)){
                return false;
            }else{
                set.add(sum);
                n = sum;
            }
        }
    }

    public static int mySqrt(int x) {
    //Define variables as long to avoid mid*mid overflow.
        long low = 0;
        long high = x;
        while(low<=high){
            long mid = (low+high)/2; 
            if(mid * mid > x){
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        
        return (int)high;
    }

    public static int MajorityElement(int[] nums) {
    //Moore voting algorithm	
        int count = 0;
        int candidate = nums[0];
        for(int i=0; i<nums.length; i++){
            if(nums[i] == candidate){
                count++;
            }else{
                count--;
                if(count==0){
                    count = 1;
                    candidate = nums[i];
                }
            }
        }
        
        return candidate;
    }

    private static final int[] romanValues = {
    	1000, 900, 500, 400,
    	100,  90,  50,  40,
    	10,   9,   5,   4,
    	1
    };
    private static final String[] romanSymbols = {
    	"M", "CM", "D", "CD",
    	"C", "XC", "L", "XL",
    	"X", "IX", "V", "IV",
    	"I"
    };
    
    public static String IntegerToRoman(int num){
    	StringBuilder roman = new StringBuilder();
    	int i = 0;
    	while(num > 0){
    		int k = num / romanValues[i];
    		for(int j=0; j<k; j++){
    			roman.append(romanSymbols[i]);
    			num -= romanValues[i];
    		}
    		i++;
    	}
    	
    	return roman.toString();
    }
    
    private static final HashMap<Character, Integer> romanIntegerMap= new HashMap<Character, Integer>(){
        {
            put('I', 1); put('V', 5); put('X', 10); put('L', 50);
            put('C', 100); put('D', 500); put('M',1000);
        }
      };
      
      public static int romanToInteger(String s) {
          int num = 0;
          int prev = Integer.MAX_VALUE;
          for(char c : s.toCharArray()){
              int curr = romanIntegerMap.get(c);
              if(curr>prev){
                  num += (curr - prev * 2);
              }else{
                  num += curr;
              }
              
              prev = curr;
          }
          
          return num;
      }
      
      public String ExcelSheetColumnTitle(int n) {
          StringBuilder title = new StringBuilder();
          while(n>0){
        	  //因为26进制里最小对应的是10进制里面的1，不是0, 所以以下要用（n-1）
              char c = (char) ((n-1)%26 + 'A');
              title.append(c);
              n = (n-1)/26;
          }
          title.reverse();
          return title.toString();
      }
      
      public int ExcelSheetColumnNumber(String s) {
          int num = 0;
          for(char c : s.toCharArray()){
              num = num*26 + (c - 'A' + 1);
          }
          
          return num;
      }

      public int FactorialTrailingZeroes(int n) {
          int count = 0;
          if(n<=0) return 0;
          //use long to define i to avoid possible overflow
          for(long i=5; n/i>0; i*=5){
              count += n/i;
          }
          
          return count;
      }
      
  	public static String multiplyStrings(String num1, String num2) {
  		//great chart here showing the algorithm:
  		//http://www.cnblogs.com/TenosDoIt/p/3735309.html
  		// 先把string翻转
  		String n1 = new StringBuilder(num1).reverse().toString();
  		String n2 = new StringBuilder(num2).reverse().toString();
  		
  		int[] d = new int[n1.length()+n2.length()];		// 构建数组存放乘积
  		for(int i=0; i<n1.length(); i++){
  			for(int j=0; j<n2.length(); j++){
  				d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');		// 在正确位置累加乘积
  			}
  		}
  		
  		StringBuilder sb = new StringBuilder();
  		for(int i=0; i<d.length; i++){
  			int digit = d[i]%10;		// 当前位
  			int carry = d[i]/10;		// 进位
  			if(i+1<d.length){
  				d[i+1] += carry;
  			}
  			sb.insert(0, digit);		// prepend
  		}
  		
  		// 移除前导零
  		while(sb.charAt(0)=='0' && sb.length()>1){
  			sb.deleteCharAt(0);
  		}
  		return sb.toString();
  	}

    public static String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        
        int k = (a.length() >= b.length()? a.length() : b.length());
        
        int carry = 0;
        StringBuilder res = new StringBuilder();
        for(int i=0; i<=k; i++){
            int x = ( i>=a.length()? 0 : (a.charAt(i) - '0') );
            int y = ( i>=b.length()? 0 : (b.charAt(i) - '0') );
            int num = x + y + carry;
            int digit = num%2;
            carry = num/2;
            res.insert(0, digit);
        }
        
        while(res.charAt(0) == '0' && res.length() > 1){
            res.deleteCharAt(0);
        }
        return res.toString();
        
    }

    public static boolean isValidSudoku(char[][] board) {
        if(board == null || board.length <0 || board[0].length<0) return false;
        boolean[] visited = new boolean[9];
        
        for(int i=0; i<9; i++){
        	Arrays.fill(visited, false);
            for(int j=0; j<9; j++){
                if(!validCell(visited, board[i][j])){
                    return false;
                }
            }
        }
        
        for(int i=0; i<9; i++){
        	Arrays.fill(visited, false);
            for(int j=0; j<9; j++){
                if(!validCell(visited, board[j][i])){
                    return false;
                }
            }
        }
        
        for(int i=0; i<9; i+=3){
            for(int j=0; j<9; j+=3){
            	Arrays.fill(visited, false);
                for(int m=i; m<i+3; m++){
                    for(int n=j; n<j+3; n++){
                        if(!validCell(visited, board[m][n])){
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
    
    private static boolean validCell(boolean[] visited, char c){
        if(c=='.') return true;
        if(visited[c-'0'-1]){
            return false;
        }
        visited[c-'0'-1] = true;
        return true;
    }
}
