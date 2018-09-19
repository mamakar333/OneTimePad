import java.util.*;
import java.io.*;
import java.lang.*;
class KeyGen {


  public static void main(String[] args) {

    String str = "00000000";
    char[] charArray = str.toCharArray();
    //System.out.println(charArray);

    //charArray[31]='1';
    String str1 = "beat";
    char[] message=str1.toCharArray();
    String binaryMessage="";
  //  int num1 = message[0];
  //  System.out.println("The value of fisrt digit "+b);

    int num = 10;
  //  System.out.println(charArray);
    int num1 = 2147483647,pol=0;
    int count=0;
    int pl;

    for(int i=0;i<str1.length();i++)
    {
      pl=7;
      num1 = message[i];
      System.out.println(num1);
      while( num1 !=1)
      {
        pol=num1%2;
        if(num1%2==1)
        {
          charArray[pl]='1';
        }
        num1 = num1/2;
        pl--;

      }
      charArray[pl]='1';
      System.out.println(charArray);
    }
    count=count+1;

  //  System.out.println("THe count is "+count);
  //  System.out.println(charArray);




  }
}
