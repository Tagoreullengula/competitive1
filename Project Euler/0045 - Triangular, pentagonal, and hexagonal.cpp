#include <bits/stdc++.h>
using namespace std;

int main() {
    int h = 1;
    int count = 3;
    while (true) {
        long hexagonal = h*((h<<1)-1);
        long double realPenta = (sqrt(1+24*hexagonal)+1)/6;
        long p = roundl(realPenta);
        if (abs(realPenta - p)< 0.000000001) {
            long double realTrian = (sqrt(8*hexagonal+1) -1)/2;
            long t = roundl(realTrian);
            if (abs(realTrian-t)<0.000000001) {
                count--;
                cout<<hexagonal<<'\n';
                if(count==0)  {
                    break;
                }
            }
        }
        h++;
    }
    return 0;
}

//std::ios_base::sync_with_stdio(false);