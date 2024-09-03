package Assignment_1;

import java.util.*;
public class LongestSubstring {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter any String: ");
        String s=in.nextLine();      // To input String from the user
        int n=s.length();

        if( n==0 )      // If length of the string is 0
        {
            System.out.println("Invalid String");
        }

        ArrayList<Integer> list=new ArrayList<Integer>();    // To input the length of the substring without repeating characters
        int start=0;      // Start pointer

        for(int end=1; end<n; end++)       // End pointer
        {
            for(int i=start; i<end; i++)
            {
                if(s.charAt(i)==s.charAt(end))     // extraction of characters from the string to check repetition
                {
                    list.add(end-start);      // length of the substring without repeating characters
                    start=i+1;         // Update start pointer
                }
            }
        }
        int result=Collections.max(list);      // To get the maximum element from the arraylist
        System.out.println(result);       // To print the maximum element
    }
}
