#include <bits/stdc++.h>
using namespace std;

int main() {
    list<int> primes;
    primes.push_back(2);
    set<int> orderedPrimes;
    int n = 3;
    while(true){
        bool isPrime = true;
        for (list<int>::iterator it = primes.begin(); it != primes.end(); ++it){
            int prime = *it;
            double div = ((double)n)/prime;
            if(div<prime){
                break;
            }
            if(n%prime == 0){
                isPrime =false;
                break;
            }
        }
        if(isPrime){
            primes.push_back(n);
            orderedPrimes.insert(n);
        } else {
            bool breaksConjeture = true;
            for(int i =1; ((i*i)<<1)<n && breaksConjeture; i++){
                breaksConjeture = orderedPrimes.find(n - ((i*i)<<1)) == orderedPrimes.end();
            }
            if(breaksConjeture){
                cout<<n<<'\n';
                break;
            }
        }
        n+=2;
    }
    return 0;
}

//std::ios_base::sync_with_stdio(false);