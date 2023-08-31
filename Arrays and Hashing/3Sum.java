import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); // initializing the answer list
        Arrays.sort(nums); // sorting the array
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) // moving the i pointer
        {
            if (i > 0 && nums[i] == nums[i - 1]) // skipping dupliacate i's {-2,-2,0,1} so i = -2 => 0
                continue; // skipping
            int j = i + 1; // j pointer
            int k = n - 1; // k pointer
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k]; // sum of three elements
                if (sum < 0) // if sum<0 and our array is sorted, we increase j, so increase the sum
                    j++;
                else if (sum > 0) // is sum>0 and our array is sorted, we decrease k, so decrease the sum
                    k--;
                else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k])); // adding the triplet to the answer
                    while (j < k && nums[j] == nums[j + 1]) // checking for duplicate j
                    {
                        j++; // skipping j duplicates
                    }
                    while (j < k && nums[k] == nums[k - 1]) // checking for duplicate k
                    {
                        k--; // skipping k duplicates
                    }
                    j++; // updating pointers
                    k--; // updating pointers
                }
            }
        }
        return ans;
    }
}