#include <bits/stdc++.h>
using namespace std;
const int limit= 1000000;
long maxN;
long totientmMaxN;
int primes[limit]={};
int primesNum;
void findMax (long num, int p, long counter) {
    long totientN = num - counter;
    if (totientmMaxN*num > maxN*totientN) {
        maxN = num;
        totientmMaxN = totientN;
    }

    for (int i = p; i < primesNum; i++) {
        long newNum = num * primes[i];
        if (newNum>limit) {
            return;
        }
        long newCounter;
        if (i == p) {
            newCounter = counter*primes[i];
        } else {
            newCounter = counter*(primes[i]-1) + num;
        }

        findMax(newNum, i, newCounter);
    }
}

int main() {
    bool sieve[limit+1]={};
    primesNum = 0;
    sieve[0]=1;
    sieve[1]=1;
    for(int i=2 ; i<=limit; i++){
        if(!sieve[i]){
            for(long j = long(i)*i; j<=limit; j += i){
                sieve[j] = 1;
            }
            primes[primesNum] = i; 
            primesNum++;
        }
    }
    maxN = 0;
    totientmMaxN = 1;
    for (int i=0; i<primesNum; i++) {
        findMax(primes[i], i, 1);
    }
    cout<<maxN<<'\n';
    return 0;
}

//std::ios_base::sync_with_stdio(false);