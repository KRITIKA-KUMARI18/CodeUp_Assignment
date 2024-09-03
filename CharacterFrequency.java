/***
 *
 */

package Assignment_1;

import java.util.*;

public class CharacterFrequency {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        Constant constant = new Constant();

        System.out.print(constant.ENTER_STRING);
        String str = in.nextLine();

        int i=0;
        while( i<str.length() )

        {
            int f=1;
            char c=str.charAt(i);
            for(int j=i+1; j<str.length(); j++)
            {
                char s=str.charAt(j);
                if(c==s) {
                    f++;
                }
                else {
                    break;
                }

            }

            System.out.println(c+" "+f);
            i=i+f;

        }
    }
}
