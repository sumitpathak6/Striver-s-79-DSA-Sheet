import java.util.*;
public class Solution 
{
    public static int subarraysWithSumK(int []a, int b) {
        int xr=0; //prefix xor
        int n=a.length; //length of the array
        HashMap<Integer,Integer> map = new HashMap<>(); //map to map the prefix xor to their frequencies
        map.put(0,1); //default values for the map
        int count=0;
        for(int i=0;i<n;i++)
        {
            xr = xr ^ a[i]; //prefix xor calculation
            int x = xr^b; //finding the required xor
            if(map.containsKey(x))
            {
                count+=map.get(x); //counting the number of possible subarrays
            }
            if(map.containsKey(xr))
            {
                map.put(xr,map.get(xr)+1); //if prefix xor is already there, increment the count by 1
            }
            else
            {
                map.put(xr,1); //put new value of prefix xor and its count into the map
            }
        }
        return count;
    }
}