#include <bits/stdc++.h> 
using namespace std; 


int main() {
    int n = 1000000;
    queue<int> primes;
    bitset<1000000> sieve;
    sieve[0]=1;
    sieve[1]=1;
    for (int i = 2; i<n ; i++){
        if(!sieve[i]){
            primes.push(i);
            for(int j =i+i; j<n ;j = j+i){
                sieve[j]=1;
            }
        }
    }
    int truncableSum = 0;
    int counter = 0;
    while(!primes.empty() && counter<11){
        int prime = primes.front();
        int primeReverse = 0;
        int tenPow = 1;
        bool isTruncable = true;
        while(prime>10 && isTruncable) {
            primeReverse = (prime %10)*tenPow + primeReverse;
            tenPow *= 10;
            prime = prime/10;
            isTruncable = !sieve[prime] &&  !sieve[primeReverse];
        }
        
        if(primes.front()>10 && isTruncable){
            //cout<<primes.front()<<'\n';
            truncableSum += primes.front();
            counter++;
        }
        primes.pop();
    }
    cout<<truncableSum;
    return 0;
}

//std::ios_base::sync_with_stdio(false);