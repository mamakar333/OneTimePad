import java.util.*;
import java.io.*;
import java.lang.*;
class OneTimePad
{

  public static void main(String[] args)throws Exception
  {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the value of lamda : ");
    int numBits = sc.nextInt();
    System.out.print("Enter a 4 letter message to be encoded :");
    String msg = sc.next();
    System.out.println("The given message is "+msg);
    keyGenerator();
    encryptionMaxima(msg);
  }


  public static void decryptionStealth()
  {


  }




  public static int randomNumberInRange(int min, int max)
  {
    Random random = new Random();
    return random.nextInt((max - min) + 1) + min;
  }



  public static void encryptionMaxima(String s)
  {
    String key="";
    String str1 = s;
    char[] message=str1.toCharArray();
    String binaryMessage="";
    for(int i=0;i<str1.length();i++)
    {
      int num1=message[i];
      String str = "00000000";
      char[] charArray1 = str.toCharArray();

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
      }
      charArray1[pl]='1';
      count=count+1;
      binaryMessage= binaryMessage+ new String(charArray1);

    }
    try
    {
      PrintWriter writer = new PrintWriter("plaintext.txt");
      writer.println(binaryMessage);
      writer.close();
    }
    catch(Exception ex)
    {
      System.out.println(ex);
    }


    System.out.println("The plain text is : ");
    System.out.println(binaryMessage);
    String fileName="key.txt";
    // Reading the Key from the txt file
    try
    {
      BufferedReader in = new BufferedReader(new FileReader(fileName));
      key = in.readLine();


    }
    catch(FileNotFoundException ex)
    {
      System.out.println("Unable to open file '" + fileName + "'");
    }
    catch(IOException ex)
    {
      System.out.println("Error reading file '" + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
    }
    char[] keyArray = key.toCharArray();
    char[] plainArray=binaryMessage.toCharArray();
    char[] cipherArray= new char[32] ;
    for(int k=0;k<32;k++)
    {

        if(keyArray[k]=='0' && plainArray[k]=='0')
        {
          cipherArray[k]='0';
        }
        if(keyArray[k]=='0' && plainArray[k]=='1')
        {
          cipherArray[k]='1';
        }
        if(keyArray[k]=='1' && plainArray[k]=='0')
        {
          cipherArray[k]='1';
        }
        if(keyArray[k]=='1' && plainArray[k]=='1')
        {
          cipherArray[k]='0';
        }
    }
    System.out.println("The Cipher Array is :");
    System.out.println(cipherArray);
    try
    {
      PrintWriter writer = new PrintWriter("ciphertext.txt");
      writer.println(cipherArray);
      writer.close();
    }
    catch(Exception ex)
    {
      System.out.println(ex);
    }

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

    System.out.println("The Random key is : ");
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
