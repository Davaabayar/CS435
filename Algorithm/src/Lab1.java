
import java.util.ArrayList;
import java.util.List;

public class Lab1 {

	public static void main(String[] args) {
		//System.out.println(gcd(24,20));
		int nums[] = {1,2,3,4}; 
		System.out.println("RESULT:" + subsetSum(nums,10));
		System.out.println("RESULT:" + subsetSumWithDesc(nums,10));
	}
	
	public static int gcd(int a, int b) {		
		if(a==0 || b==0) return a+b;
		if(b>a) return gcd(a,b%a);
		else return gcd(b, a%b);
	}

    static boolean subsetSum(int nums[], int S) 
    {    
        int n = nums.length;   //1
        int subsetTotal;       //1
     
        for (int i = 0; i < 1<<n; i++) //1 + 2^n + 1 
        { 	subsetTotal = 0;					//1
            for (int j = 0; j < n; j++) { 		//n
                if ((i & (1 << j)) > 0) {       //n*3          	
                	subsetTotal+=nums[j];		//n*2
                }
            }            
            if(subsetTotal==S) {				//2^n
            	return true;					//1
            }
        } 
        return false;							//1
    } 
    
    static boolean subsetSumWithDesc(int nums[], int S) 
    {    
        int n = nums.length;   
        int subsetTotal;        
        int twoPowN = 1<<n;
        for (int i = 0; i < twoPowN; i++) 
        { 	subsetTotal = 0;
        	List<Integer> subset = new ArrayList<Integer>();
        	System.out.print("i=" + i );
            for (int j = 0; j < n; j++) { 
                if ((i & (1 << j)) > 0) {                 	
                	subsetTotal+=nums[j];
                	subset.add(nums[j]);
                }
            }            
            System.out.println(" " + subset.toString());            
            if(subsetTotal==S) {
            	System.out.println("Option: " + i +" | Selected subset: " + subset.toString());     
            	return true;
            }
        } 
        return false;
    }    
}
