package Assignment_1;

import java.util.*;
public class PrimeNumberChecker {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter any number: ");
        int num=in.nextInt();     // To input number from the user
        int c=0;     // Pointer

        if(num==1)    // Since 1 is not a prime number
        {
            System.out.println("This given number is NOT prime");
        }

        for(int i=2; i<=num/2; i++)
        {
            if(num%i==0) {
                c++;
                System.out.println("This given number is NOT prime");
                break;
            }
        }
        if(c==0)
        {
            System.out.println("The given number is PRIME");
        }
    }

}
