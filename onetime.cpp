#include <iostream>
#include <random>
using namespace std;
int main()
{
    int dec;
    int max = 2147483647, min=0;

    srand((unsigned)time(0));
    int random_integer;
    int lowest=1, highest=2147483647;
    int range=(highest-lowest)+1;

     random_integer = lowest+int(range*rand()/(RAND_MAX + 1.0));
     cout << random_integer << endl;
    //cout<<" The random number "<<randNum<<endl;

    char bin32[]  = "00000000000000000000000000000000";
    for (int pos = 31; pos >= 0; --pos)
    {
        if (random_integer % 2)
            bin32[pos] = '1';
        random_integer /= 2;
    }


    std::random_device rd;
        std::mt19937 mt(rd());
      //  std::uniform_real_distribution<double> dist(1, 10);
        std::uniform_real_distribution<double> dist(1, std::nextafter(10, 2147483647));

        for (int i=0; i<1; ++i)
            std::cout << dist(mt) << "\n";


    cout << "The binary of the given number is: " << bin32 << endl;

}
