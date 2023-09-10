//APPROACH 1
import java.util.*;
public class Solution {
    public static int[] findMissingRepeatingNumbers(int []a) 
    {
        // Write your code here
        long n=a.length;
        long sum=0;
        long sqsum=0;
        long sn = n * (n+1) / 2; //sum of n natural numbers
        long sqsumn = n * (n+1) * (2*n + 1)/6; //sum of squares of n natural numbers
        
        for(int i=0;i<n;i++)
        {
            sum+=a[i]; //sum of elements of the array
            sqsum += ((long)a[i] * (long)a[i]); //sum of squares of elements of the array
        }
        
        long val1 = sum-sn; //x-y
        long val2 = sqsum-sqsumn; //x^2 - y^2

        val2 = val2/val1; // (x^2 - y^2)/(x+y) => ((x+y)(x-y))/(x-y) => x+y

        long x = (val1+val2)/2; //calculation by (x+y) and (x-y)
        long y = x-val1; //calculation by (x-y) and (x+y)
        int ans[] = new int[2];
        ans[0]=(int)x;
        ans[1]=(int)y;
        return ans;
    }
}

//APPROACH 2

public class Solution {
    public static int[] findMissingRepeatingNumbers(int []a) {
        int n=a.length;
        int xr=0; //xor of elements of the array and from 1 to N => xr = missing ^ repeating
        for(int i=0;i<n;i++)
        {
            xr = xr^a[i]; //xor of elements of the array 
            xr = xr^(i+1); //xor of numbers from 1 to N
        }
        int bitNo = (xr & ~(xr-1)); //rightmost differentiating bit
        
        int zero=0; //zero at differentitating bit (zero club)
        int one=0; //one at differentiating bit (one club)
        for(int i=0;i<n;i++)
        {
            if((a[i] & bitNo)!=0)
            {
                one = one^a[i]; //one club
            }
            else
            {
                zero = zero^a[i]; //zero club
            }
        }
        for(int i=1;i<=n;i++)
        {
            if((i&bitNo)!=0)
            {
                one = one^i; //one club
            }
            else
            {
                zero = zero^i; //zero club
            }
        }
        int count=0; //rechecking once
        int ans[]=new int[2];
        for(int i=0;i<n;i++)
        {
            if(a[i]==zero)
                count++;
        }
        if(count==2)
        {
            ans[0]=zero;
            ans[1]=one;
            return ans;
        }
        ans[0]=one;
        ans[1]=zero;
        return ans;
    }
}