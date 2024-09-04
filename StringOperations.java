/***
 * To ask the user which operation they want to execute on the string. The available operations are
 * listed below: Append, CountWords, Replace, isPalindrome, Splice, Split,
 * MaxRepeatingCharacter, Sort, Shift, and Reverse.
 */
package Assignment_2;

import java.util.*;

public class StringOperations {

    Scanner input = new Scanner(System.in);

    final public void Append()
    {
        Constant constant = new Constant();
        char choice;

        System.out.println(constant.FIRST_STRING);
        String str = input.nextLine();

        do {
            System.out.println(constant.ANOTHER_STRING);
            String str2 = input.next();
            str = str + " " + str2;
            System.out.println(str);
            System.out.println(constant.APPEND_STRING);
            choice = input.next().charAt(0);
        }while(choice == 'y' || choice == 'Y');

    }

    final public void WordsCount() {

        Constant constant = new Constant();
        System.out.println(constant.ENTER_STRING);
        String str = input.nextLine();

    }

    final public void Replace() {

        Constant constant = new Constant();
        System.out.println(constant.ENTER_STRING);
        String str = input.nextLine();
        int str_len = str.length();
        System.out.println(constant.PREV_STRING);
        String x = input.nextLine();
        int x_length = x.length();
        System.out.println(constant.REPLACE_STRING);
        String v = input.nextLine();
        String new_string = "";
        for( int i = 0; i < str.length(); i++ )
        {
            if(str.charAt(i) == x.charAt(0) )
            {
                new_string = str.substring(0,i-1) + v + str.substring(x_length+1,str_len);
            }
        }
        System.out.println(new_string);
    }

    final public void isPalindrome(){

        Constant constant = new Constant();
        System.out.println(constant.ENTER_STRING);
        String str = input.nextLine();

        int n = str.length();
        int c=0;
        for(int i = 0; i < n; i++){
            int j = n-i-1;
            if( str.charAt(i) == str.charAt(j) )
            {
                c++;
            }
            else{
                break;
            }
        }
        if(c==n)
        {
            System.out.println(str+" is Palindrome");
        }
        else{
            System.out.println(str+" is not Palindrome");
        }
    }

    final public void Splice(){

        Constant constant = new Constant();

    }

    final public void Split(){

        Constant constant = new Constant();
    }

    final public void MaxRepeatChar(){

        Constant constant = new Constant();
    }

    final public void Sort(){

        Constant constant = new Constant();
    }

    final public void Shift(){

        Constant constant = new Constant();
    }

    final public void Reverse(){

        Constant constant = new Constant();
        System.out.println(constant.ENTER_STRING);
        String str = input.nextLine();
        int n = str.length();
        String reversestring = "";

        for(int i = n-1; i >= 0; i--){
            char ch = str.charAt(i);
            reversestring = reversestring + ch;
        }
        System.out.println("Reverse String is: "+reversestring);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StringOperations obj = new StringOperations();

        Constant constant = new Constant();
        System.out.println(constant.INPUT_STRING);

        System.out.println(" 1:  Append ");
        System.out.println(" 2:  CountWords ");
        System.out.println(" 3:  Replace ");
        System.out.println(" 4:  isPalindrome ");
        System.out.println(" 5:  Splice ");
        System.out.println(" 6:  Split ");
        System.out.println(" 7:  MaxRepeatingCharacter ");
        System.out.println(" 8:  Sort ");
        System.out.println(" 9:  Shift ");
        System.out.println("10:  Reverse ");

        char SELECT;

        do{

            System.out.println(constant.CHOICE);
            int choice = input.nextInt();

            switch(choice){
                case 1:
                    obj.Append();
                    break;
                case 2:
                    obj.WordsCount();
                    break;
                case 3:
                    obj.Replace();
                    break;
                case 4:
                    obj.isPalindrome();
                    break;
                case 5:
                    obj.Splice();
                    break;
                case 6:
                    obj.Split();
                    break;
                case 7:
                    obj.MaxRepeatChar();
                    break;
                case 8:
                    obj.Sort();
                    break;
                case 9:
                    obj.Shift();
                    break;
                case 10:
                    obj.Reverse();
                    break;
                default:
                    System.out.println("Enter the correct option:");
                    break;
            }
            System.out.println(constant.ANOTHER_INPUT);
            SELECT = input.next().charAt(0);

        }while(SELECT == 'y' || SELECT == 'Y');


    }
}
