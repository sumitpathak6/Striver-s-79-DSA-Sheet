
class Solution {
    public void nextPermutation(int[] nums) 
    {
        int ind=-1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                ind=i; //finding the breakpoint of the array => [2,3,6,5,0] => breakpoint would be 3 as 3<6
                break;
            }
        }    
        if(ind==-1) //checks if the given array is the last permutation, if yes, then it returns the first permutation by reversing the array
        {
            reverse(nums,0); //seperate code to reverse the array
        }
        else
        {
            for(int i=n-1;i>=ind;i--) //checks for the smallest (GREATER) element than that of the break point element
            {                         // for eg if the break point is at 3, then this will give 5 as the smallest (GREATER) element
                if(nums[i]>nums[ind])
                {
                    swap(nums,i,ind); //swapping the break point element and the found smallest (greater) element
                    break;
                }
            }
            reverse(nums,ind+1); //reverse the remaining elements of the array to find the next greatest permutation
        }
        
    }
    void swap(int[] nums,int i,int j) //swapping two elements
    {
        int temp=0;
        temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    void reverse(int[] nums,int start) //reverse the array from a given index to the end of the array
    {
        int i=start;
        int j=nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    
}