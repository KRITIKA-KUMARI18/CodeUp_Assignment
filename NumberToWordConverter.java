package Assignment_1;

import java.util.*;

public class NumberToWordConverter {
    static int reverse(int n) {
        int k = 0;
        while (n > 0) {
            int a = n % 10;
            k = k * 10 + a;
            n = n / 10;
        }
        return k;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter any Number: ");
        int number = in.nextInt();
        int n = reverse(number);

        while (n > 0) {
            String s = Integer.toString(n);

            int l = s.length();

            if (l == 4) {
                System.out.print("One Thousand ");

            } else if (l == 3) {
                int num = n % 10;
                if (num == 1)
                    System.out.print("One Hundred ");
                else if (num == 2)
                    System.out.print("Two Hundred ");
                else if (num == 3)
                    System.out.print("Three Hundred ");
                else if (num == 4)
                    System.out.print("Four Hundred ");
                else if (num == 5)
                    System.out.print("Five Hundred ");
                else if (num == 6)
                    System.out.print("Six Hundred ");
                else if (num == 7)
                    System.out.print("Seven Hundred ");
                else if (num == 8)
                    System.out.print("Eight Hundred ");
                else if (num == 9)
                    System.out.print("Nine Hundred ");

            } else if (l == 2) {
                int num = n % 10;

                if (num == 1) {
                    if (n == 10)
                        System.out.print(" Ten");
                    else if (n == 11)
                        System.out.print(" Eleven");
                    else if (n == 12)
                        System.out.print(" Twelve");
                    else if (n == 13)
                        System.out.print(" Thirteen");
                    else if (n == 14)
                        System.out.print(" Fourteen");
                    else if (n == 15)
                        System.out.print(" Fifteen");
                    else if (n == 16)
                        System.out.print(" Sixteen");
                    else if (n == 17)
                        System.out.print(" Seventeen");
                    else if (n == 18)
                        System.out.print(" Eighteen");
                    else if (n == 19)
                        System.out.print(" Nineteen");
                    break;

                } else if (num == 2)
                    System.out.print(" Twenty");
                else if (num == 3)
                    System.out.print(" Thirty");
                else if (num == 4)
                    System.out.print(" Forty");
                else if (num == 5)
                    System.out.print(" Fifty");
                else if (num == 6)
                    System.out.print(" Sixty");
                else if (num == 7)
                    System.out.print(" Seventy");
                else if (num == 8)
                    System.out.print(" Eighty");
                else if (num == 9)
                    System.out.print(" Ninety");
            } else {
                if (n == 1)
                    System.out.print(" One");
                else if (n == 2)
                    System.out.print(" Two");
                else if (n == 3)
                    System.out.print(" Three");
                else if (n == 4)
                    System.out.print(" Four");
                else if (n == 5)
                    System.out.print(" Five");
                else if (n == 6)
                    System.out.print(" Six");
                else if (n == 7)
                    System.out.print(" Seven");
                else if (n == 8)
                    System.out.print(" Eight");
                else if (n == 9)
                    System.out.print(" Nine");
            }
            n = n / 10;
        }
    }
}
