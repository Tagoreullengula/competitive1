#include <bits/stdc++.h>
using namespace std;

int main() {
    bool sieve[1000000]={};
    long primesSum[200000]={};
    int maxlength = 0;
    int primeCounter=1;
    sieve[0]=true;
    sieve[1]=true;
    for(int i=2;i<1000000;i++){
        if(!sieve[i]){
            for(int j = i*i;j>0 && j<1000000;j=j+i){
                sieve[j] = true;
            }
            primesSum[primeCounter] = i + primesSum[primeCounter-1];
            if(primesSum[primeCounter]<1000000){
                maxlength++;
            }
            primeCounter++;
        }
    }
    while(maxlength>0){
        for(int i = 0; i+maxlength<primeCounter; i++){
            long possiblePrime = primesSum[i+maxlength] - primesSum[i];
            if(possiblePrime<1000000){
                if(!sieve[int(possiblePrime)]){
                    cout<<maxlength<<'\n'<<possiblePrime<<'\n';
                    maxlength=0;
                    break;
                }
            } else {
                break;
            }
        }
        maxlength--;
    }
    return 0;
}

//std::ios_base::sync_with_stdio(false);