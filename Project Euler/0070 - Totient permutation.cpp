#include <bits/stdc++.h>
using namespace std;
const int limit =10000000;
int primes[limit]={};
int primesNum=0;
long minN;
long totientMinN;
int tenPows[10];
void findNum(int num, int p, int totientN){
    if(num * totientMinN < minN*totientN){
        int copy = num;
        long numPerm = 0;
        while (copy>0) {
            numPerm += tenPows[copy%10];
            copy=copy/10;
        }
        copy = totientN;
        long totientPerm = 0;
        while (copy>0) {
            totientPerm += tenPows[copy%10];
            copy=copy/10;
        }
        if(totientPerm == numPerm){
            minN=num;
            totientMinN=totientN;
        }
    }
    for (int i = p; i<primesNum; i++) {
        long newNum = long(num) * primes[i];
        long newTotient;
        if(newNum > limit){
            return;
        }
        if(i == p){
            newTotient = totientN * primes[i];
        } else {
            newTotient = totientN * (primes[i] - 1);
        }
        findNum(newNum, i, newTotient);
    }
}
int main() {
    bitset<limit> sieve;
    sieve[0]=1;
    sieve[1]=1;
    for (int i=2; i<limit; i++) {
        if (!sieve[i]) {
            for(long j = long(i)*i; j<limit; j+=i){
                sieve[j]=1;
            }
            primes[primesNum] = i;
            primesNum++;
        }
    }
    for(int i=0,p=1; i<10; i++,p*=10){
        tenPows[i] = p;
    }
    minN = limit;
    totientMinN = 0;
    for (int i=0; i<primesNum; i++) {
        findNum(primes[i], i, primes[i]-1);
    }
    cout<<minN<<'\n';
    return 0;
}

//std::ios_base::sync_with_stdio(false);