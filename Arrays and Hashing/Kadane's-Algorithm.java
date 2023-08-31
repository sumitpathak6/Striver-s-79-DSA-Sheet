class Solution {
    public int maxSubArray(int[] nums) 
    {
        int curSum=0; //storing the current running sum
        int maxSum=nums[0]; //storing the maximum sum calculated, initialised with the first element of the array
        for(int i=0;i<nums.length;i++)
        {
            curSum+=nums[i]; //adding the elements of the array
            if(curSum>maxSum) //reinitialising the maximum sum calculated 
            maxSum=curSum;

            if(curSum<0) // if current sum calculated is -ve, then we need to start the current sum calculation from there again from 0.
            curSum=0;
        }
        return maxSum;
    }
}