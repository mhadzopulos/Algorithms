
public class median 
{
	public static int findMedian(int[] nums) 
	{
	    int median = 0;
	    if(nums.length == 1)
	     return nums[0];
	    else
	    {
	        int low= 0, high= 0;
	     for(int i = 0; i < nums.length || low == nums.length/2 || high ==     nums.length/2; i++)
	        {
	          median = nums[i];
	           for(int u = 0; u < nums.length; i++)
	           {
	             if(u != i)
	             {
	             if(nums[u] > nums[i])
	                high++;
	             else
	                low++;
	             }
	           }
	           if(low == high)
	            return nums[i];
	           low = 0;
	           high = 0;
	        }
	    }
	    return median;
	} 
	public static void main(String[] args)
	{
		int[] bug = new int[5];
		
		System.out.println("median = " + findMedian(bug));
	}
}
