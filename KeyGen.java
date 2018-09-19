import java.util.*;
import java.io.*;
import java.lang.*;
class KeyGen {


  public static void main(String[] args) {

    String str = "00000000000000000000000000000000";
    char[] charArray = str.toCharArray();
    System.out.println(charArray);

    //charArray[31]='1';

    int num = 10;
    System.out.println(charArray);
    int num1 = 2147483647,pol=0;
    int count=0;
    int pl=31;
    while( num1 !=1)
    {
      pol=num1%2;
      if(num1%2==1)
      {
        charArray[pl]='1';
      }
      num1 = num1/2;
      pl--;
      count--;
      System.out.println("This is ..."+num1+" The reminder "+pol);

    }
    charArray[pl]='1';
    count=count+1;

    System.out.println("THe count is "+count);
    System.out.println(charArray);




  }
}
