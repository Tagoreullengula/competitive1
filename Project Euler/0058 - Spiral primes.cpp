#include <bits/stdc++.h>
using namespace std;

int main() {
    bool sieve[100000];
    list<int> primes;
    for (int i =2;i<100000; i++) {
        if (!sieve[i]) {
            primes.push_back(i);
            for (long j = long(i)*i; j<100000; j=j+i) {
                sieve[int(j)]=true;
            }
        }
    }
    int n=3;
    int diagonalTotal = 1;
    int diagonalPrimes = 0;
    while(true){
        long n2 = long(n)*n;
        diagonalTotal+=4;
        for(long i=0, possiblePrime = n2-n+1;i<3;i++, possiblePrime = possiblePrime-n+1){
            for(list<int>::iterator it = primes.begin(); it!=primes.end(); ++it){
                long p = *it;
                if(p*p>possiblePrime){
                    diagonalPrimes++;
                    break;
                }
                if(possiblePrime % p == 0){
                    break;
                }
            }
        }
        if(diagonalPrimes * 10 < diagonalTotal){
            cout<<n<<'\n';
            break;
        }
        n+=2;
    }
    return 0;
}

//std::ios_base::sync_with_stdio(false);