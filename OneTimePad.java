import java.util.*;
import java.io.*;
import java.lang.*;
class OneTimePad
{

  public static void main(String[] args)throws Exception
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the value of lamda : ");
    int numBits = sc.nextInt();
    System.out.print("Enter a 4 letter message to be encoded :");
    String msg = sc.next();
    System.out.println("The given message is "+msg);
    keyGenerator();
    encryptionMaxima();
  }


  public static int randomNumberInRange(int min, int max)
  {
    Random random = new Random();
    return random.nextInt((max - min) + 1) + min;
  }

  public static void encryptionMaxima()
  {

    String str1 = "beat";
    char[] message=str1.toCharArray();


    String binaryMessage="";
  //  int num1 = message[0];
  //  System.out.println("The value of fisrt digit "+b);

    for(int i=0;i<str1.length();i++)
    {
      int num1=message[i];
      System.out.println("number is "+num1);
      String str = "00000000";
      char[] charArray1 = str.toCharArray();
      System.out.println(charArray1);
      int count=0;
      int pl=7;
      while( num1 !=1)
      {
        if(num1%2==1)
        {
          charArray1[pl]='1';
        }
        num1 = num1/2;
        pl--;
        count--;
        System.out.println("The ......."+charArray1);
      }
      charArray1[pl]='1';
      count=count+1;
      System.out.println("The digit is "+num1+" The binary = "+charArray1);
      binaryMessage= binaryMessage+charArray1;

    }
    System.out.println("The converted Binary message = "+binaryMessage);

  }


  public static void keyGenerator()
  {
    int num1 = randomNumberInRange(1,2147483647);
    String str = "00000000000000000000000000000000";
    char[] charArray = str.toCharArray();
    int pol=0;
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
    }
    charArray[pl]='1';
    count=count+1;

    System.out.println(charArray);
    try
    {
      PrintWriter writer = new PrintWriter("key.txt");
      writer.println(charArray);
      writer.close();
    }
    catch(Exception ex)
    {
      System.out.println(ex);
    }

  }




}
