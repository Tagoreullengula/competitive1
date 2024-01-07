#include <bits/stdc++.h>
using namespace std;
const int limit=1000000;
int primes[limit]={};
int primeCounter=0;
long fractionCounter =0;
void find(long num, int p, long count) {
    fractionCounter += count;
    for (int i = p; i<primeCounter; i++) {
        long newNum = num*primes[i];
        if(newNum>limit){
            break;
        }
        long newCount;
        if(i==p){
            newCount = count * primes[i];
        } else {
            newCount = count * (primes[i]-1);
        }
        find(newNum, i, newCount);
    }
}
int main() {
    bool sieve[limit+1]={};
    sieve[0]=1;
    sieve[1]=1;
    for (int i = 2; i<=limit; i++) {
        if(!sieve[i]){
            for(long j = long(i)*i;j<= limit; j+=i){
                sieve[j]=1;
            }
            primes[primeCounter] = i;
            primeCounter++;
        }
    }
    for (int i = 0; i<primeCounter; i++) {
        find(long(primes[i]), i, long(primes[i]-1) );
    }
    cout<<fractionCounter<<'\n';
    return 0;
}

//std::ios_base::sync_with_stdio(false);