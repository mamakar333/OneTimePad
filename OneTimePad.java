import java.util.*;
import java.io.*;
import java.lang.*;
class OneTimePad
{

  public static void main(String[] args)throws Exception
  {


    // int random_integer= 2;
    // char bin32[]  = "00000000000000000000000000000000";
    // for (int pos = 31; pos >= 0; --pos)
    // {
    //     if (random_integer % 2)
    //         bin32[pos] = '1';
    //     random_integer /= 2;
    // }

  //  System.out.println(random_integer);
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the value of lamda : ");
      int numBits = sc.nextInt();
      int minNum=1;

      int num=randomNumberInRange(minNum,2147483647);
      System.out.println(" The number is = "+num);

      String bit32 = "00000000000000000000000000000000";



      String binaryString = Long.toBinaryString(2147483648L);
      binaryString = binaryString.substring(binaryString.length() - numBits>0?binaryString.length()-numBits:0);
      System.out.println("The key generated is = "+binaryString);


      try{
      PrintWriter writer = new PrintWriter("key.txt");
      writer.println(binaryString);
    //  writer.println(printBinary(bits));
      writer.close();
      }
      catch(Exception ex)
      {
        System.out.println(ex);
      }


  }


  public static int randomNumberInRange(int min, int max)
  {
      Random random = new Random();
      return random.nextInt((max - min) + 1) + min;
  }




}
