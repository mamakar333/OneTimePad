import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.BigInteger;
class OneTimePadCipher
{

  public static void main(String[] args)throws Exception
  {

    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the value of lamda : ");
    int numBits = sc.nextInt(); // scannig for number of bits
    System.out.print("Enter a 4 letter message to be encoded :");
    String msg = sc.next(); // Taking the user input for the message
    int messagelength=msg.length(); // length of the given message
    System.out.println("The given message is "+msg);

    // For a one time pad the message length and key length should be the same
    // so validating the user input
    if(numBits/8==messagelength)
    {
      // if the user input is correct generate a key and encryp the message.
      BigInteger b=largeNumberGenerator(numBits);       // Generating a large random number
      keyGenerator(numBits);                           // Generating a key for the encryption
      long startTime = System.nanoTime();              // Using the nanoTime fucntion of java to measure the running time of Encryption fucntion
      encryptionMaxima(msg,numBits);                   // Callin the encryption method
      long stopTime = System.nanoTime();
      System.out.print("The Running time of the Encryption fucntion is ");
      System.out.println((stopTime - startTime)/100000);// Time taken to run the encryption method
      decryptionStealth(numBits,messagelength);        // Callin the decryption fucntion
    }
    else
    {
      System.out.println("Please enter a message of length = "+ numBits/8); // Error message if the entered message is not correct
    }

  }


  public static BigInteger largeNumberGenerator(int lamda)
  {
    BigInteger b = new BigInteger(lamda, new Random());   // Generating the random number using the Random method
    //System.out.println(b);
    return b;

  }

public static String stringGenerator(int lamda)
{
    String jack="";
    int t=lamda,p=0;
    while(p<t)
    {
      jack=jack+"0";
      p++;
    }
    return jack;

}

public static void decryptionStealth(int lamda,int length)
{
  String key="";
  String cipher="";
  String fileName="key.txt";
  String cipherFile = "ciphertext.txt";
  // Reading the Key from the txt file
  try
  {
    BufferedReader in = new BufferedReader(new FileReader(fileName));
    BufferedReader buf = new BufferedReader(new FileReader(cipherFile));
    key = in.readLine();
    cipher=buf.readLine();
  }
  catch(FileNotFoundException ex)
  {
    System.out.println("Unable to open file '" + fileName + "'");
  }
  catch(IOException ex)
  {
    System.out.println("Error reading file '" + fileName + "'");
  }
  char[] keyArray = key.toCharArray();
  char[] cipherArray=cipher.toCharArray();
  char[] plainArray= new char[lamda] ;
  for(int k=0;k<lamda;k++)
  {
      if(keyArray[k]=='0' && cipherArray[k]=='0' || keyArray[k]=='1' && cipherArray[k]=='1')
      {
        plainArray[k]='0';
      }
      if(keyArray[k]=='0' && cipherArray[k]=='1' || keyArray[k]=='1' && cipherArray[k]=='0')
      {
        plainArray[k]='1';
      }
  }
  int k=8;
  int b=0;

  String message = "";
  for(int j =0;j<length;j++)
  {
    double sub=7;
    double aNum=0;
    double two=2;
    for(int l=b;l<k;l++)
    {
      int doll=(int)plainArray[l]-48;
      aNum = aNum+(doll*(Math.pow(two,sub)));
      sub--;
    }
    b=b+8;
    k=k+8;
    int bNum = (int)aNum;
    char cello = (char)bNum;
    message=message+cello;
  }
  System.out.println("The original Message is : ");
  System.out.println(message);
}

public static void encryptionMaxima(String s,int lamda)
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
  }
  char[] keyArray = key.toCharArray();
  char[] plainArray=binaryMessage.toCharArray();
  char[] cipherArray= new char[lamda] ;
  for(int k=0;k<lamda;k++)
  {
      if(keyArray[k]=='0' && plainArray[k]=='0' || keyArray[k]=='1' && plainArray[k]=='1')
      {
        cipherArray[k]='0';
      }
      if(keyArray[k]=='0' && plainArray[k]=='1' || keyArray[k]=='1' && plainArray[k]=='0')
      {
        cipherArray[k]='1';
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

  public static void keyGenerator(int lamda)
  {
    BigInteger num1 = largeNumberGenerator(lamda);
  //  System.out.println("the fucking in is "+num1);
    String str = stringGenerator(lamda);
  //  System.out.println(" Be the bold ");
  //  System.out.println(str);
    char[] charArray = str.toCharArray();

    int count=0;
    int pl=lamda-1;
    BigInteger poli= BigInteger.valueOf(15);
    BigInteger pik =poli.mod(BigInteger.TWO);
  //  System.out.println("Picardoooooooooo"+pik);
    int res = num1.compareTo(BigInteger.ONE);;
    while( res!=0)
    {

      int sop= num1.mod(BigInteger.TWO).compareTo(BigInteger.ONE);
      if(sop == 0)
      {
        charArray[pl]='1';
      }
      num1 = num1.divide(BigInteger.TWO);
      pl--;
      count--;
      res = num1.compareTo(BigInteger.ONE);
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
