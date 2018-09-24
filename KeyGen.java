import java.util.*;
import java.io.*;
import java.lang.*;
class KeyGen {


  public static void main(String[] args)throws Exception
  {

    keyGenerator();

  }

  public static void keyGenerator()
  {

    int count1=0,count2=0,count3=0,count4=0,count5=0,count6=0,count7=0;
    int past=0;

    while(past<5000){
    int num1 = randomNumberInRange(1,7);
    String str = "000";
    char[] charArray = str.toCharArray();
    int pol=0;
    int count=0;
    int pl=2;
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
    String blast= new String(charArray);

//    System.out.println("The Random key is : ");
    if(blast.equals("001"))
    {

        count1++;
    }
    else if(blast.equals("010"))
    {
        count2++;

    }else if(blast.equals("100"))
    {
        count3++;

    }else if(blast.equals("110"))
    {
        count4++;

    }else if(blast.equals("101"))
    {
        count5++;

    }else if(blast.equals("011"))
    {
        count6++;

    }else if(blast.equals("111"))
    {
        count7++;
    }

    try {

          //String content = "This is the content to write into file";

          File file = new File("three_key.txt");

          // if file doesnt exists, then create it
          if (!file.exists()) {
              file.createNewFile();
          }

          FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
          BufferedWriter bw = new BufferedWriter(fw);
          bw.write(charArray);
          bw.write("\n");
          bw.close();

      }
    catch(Exception ex)
    {
      System.out.println(ex);
    }
    past++;

}

  System.out.println("Count1 ="+count1+" Count2 = "+count2+" Count3 = "+count3);
  System.out.println("count4 = "+count4+" Count5 = "+count5+" count6 = "+count6+" count7 = "+count7);
}

public static int randomNumberInRange(int min, int max)
{
  Random random = new Random();
  return random.nextInt((max - min) + 1) + min;
}
}
