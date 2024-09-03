package Assignment_1;

import java.util.*;
public class ExpandCharacters {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str=in.nextLine();

        int i=0;
        while( i<str.length() )
        {
            char ch=str.charAt(i);

            int j=i+1;
            int k=str.charAt(j)-'0';

            while( j<(str.length()-1) )
            {
                char c=str.charAt(j+1);
                if( Character.isDigit(c) )
                {
                    int f=str.charAt(j+1)-'0';
                    k=(k*10)+f;
                }
                else {
                    break;
                }
                j++;
            }

            for(int f=1; f<=k; f++)
            {
                System.out.print(ch);
            }

            i=j+1;
        }
    }
}
