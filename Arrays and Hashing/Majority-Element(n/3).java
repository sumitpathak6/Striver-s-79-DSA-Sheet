import java.util.*;
class Solution {
    public List<Integer> majorityElement(int[] v) 
    {
        int c1=0,c2=0; //initialising the counters
        int ele1 = Integer.MIN_VALUE,ele2=Integer.MIN_VALUE;
        for(int num:v) //iterating in the loop
        {
            if(c1==0 && num!=ele2) //checking for the first element
            {
                c1=1;
                ele1=num;
            }
            else if(c2==0 && num!=ele1) //checking for the second element
            {
                c2=1;
                ele2=num;
            }
            else if(num == ele1) //if found as the same, increase counter1
                c1++;
            else if(num == ele2) //if found as the same, increase counter2
                c2++;
            else //if different elements are found, decrease counters
            {
                c2--;
                c1--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        c1=0;c2=0;
        for(int num:v) //manually checking the frequency of both the elements found
        {
            if(num==ele1)
                c1++;
            else if(num==ele2)
                c2++;
        }
        int n=v.length;
        int minimum_value = (n/3)+1;
        if(c1 >= minimum_value)
            ans.add(ele1);
        if(c2>= minimum_value)
            ans.add(ele2);
        Collections.sort(ans); //sorting the final answer
        return ans;
    }
}