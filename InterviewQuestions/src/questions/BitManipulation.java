package questions;

public class BitManipulation {
	public static int ReverseBits(int n){
        for(int i = 0; i < 16; i++){
            n = swapBits(n, i, 32-i-1);
        }     
        return n;
    }
    
    private static int swapBits(int n, int i, int j){
        int low = ((n>>i) & 1);
        int high = ((n>>j)& 1);
        
        if( (low^high) == 1 ){
            n ^= ((1<<i) | (1<<j));
        }
        
        return n;
    }

    public static int ReverseBits2(int x) {
    //!!Note:This method failed in leetcode OJ. Not sure why now.
       x = ((x & 0x55555555) << 1) | ((x & 0xAAAAAAAA) >> 1);
       x = ((x & 0x33333333) << 2) | ((x & 0xCCCCCCCC) >> 2);
       x = ((x & 0x0F0F0F0F) << 4) | ((x & 0xF0F0F0F0) >> 4);
       x = ((x & 0x00FF00FF) << 8) | ((x & 0xFF00FF00) >> 8);
       x = ((x & 0x0000FFFF) << 16) | ((x & 0xFFFF0000) >> 16);
       return x;
     }

    public int singleNumber2(int[] nums) {
        int[] a = new int[32];
        int result = 0;
        for(int i=0; i<32; i++){
            a[i] = 0;
            for(int j=0; j<nums.length; j++){
                a[i]+= (nums[j]>>i) & 1;
            }
            result |= ( (a[i]%3) << i);
        }
        
        return result;
    }

    public int BitwiseANDofNumbersRange(int m, int n) {
        int i=0;
        while(m!=n){
            m >>= 1;
            n >>= 1;
            i++;    
        }
        return m<<i;
    }
}
