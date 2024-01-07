#include <bits/stdc++.h>
using namespace std;

int main() {
    int n = 1;
    while(n>0){
        long minPenta = (n*(3*n-1))>>1;
        int minDiv = 3;
        while(minPenta<<1 > minDiv){
            if((minPenta<<1) % minDiv == 0){
                long maxDiv = (minPenta<<1)/minDiv;
                if (minDiv>maxDiv) {
                    break;
                }
                long double n = ((maxDiv + 1)/3.0 + minDiv)/2.0;
                long intN = roundl(n);
                if(abs(n - intN) <= 0.000000001 && minDiv < intN) {
                    long pentaSum = ((intN*(3*intN-1))>>1) + (((intN-minDiv)*(3*(intN-minDiv)-1))>>1);
                    long double sumN = (1+sqrt(1+24*pentaSum))/6.0;
                    long intSumN = roundl(sumN);
                    bool isInteger = abs(sumN-intSumN) <= 0.000000001;
                    if (isInteger) {
                        cout<<minPenta<<'\n';
                        n=-1;
                        break;
                    }
                }
            }
            minDiv ++;
        }
        n++;
    }
    return 0;
}

//std::ios_base::sync_with_stdio(false);