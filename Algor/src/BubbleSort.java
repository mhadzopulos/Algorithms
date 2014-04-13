import java.util.Random;

public class BubbleSort 
{
  public static void main(String [] args)
  {
	  Random rand = new Random();
	  
	  
	  int count = rand.nextInt(1000);
	  int[] nums = new int[count];
	  for(int i = 0; i < count; i++)
	  {
		  nums[i] = rand.nextInt(count);
	  }
	  System.out.println("comparisons " + sortDescending(nums) + " vs n = " + count);
  }
  public static int sortDescending(int[] nums) 
  {
    boolean outOfOrder = true;
    int n = 0;
    for(int i = 0; i < nums.length - 1 && outOfOrder == true; i++)
    {
     outOfOrder = false;
     
     for(int j= 0; j < (nums.length-1) - i; j++)
     {
       if(nums[j] < nums[j+1])
       {
        n++;
        int temp = nums[j];
        nums[j] = nums[j+1];
        nums[j+1] = temp;
        outOfOrder = true;
       }
     }
    }
    return n;
  }
}
