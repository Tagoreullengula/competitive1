#include <bits/stdc++.h>
using namespace std;

int main() {
    bitset<100000> sieve;
    list<int> primes;
    for (int i =2; i<100000; i++) {
        if (!sieve[i]) {
            primes.push_back(i);
            for (int j = i+i; j<100000; j=j+i) {
                sieve[j]=1;
            }
        }
    }
    queue<int> bfs;
    queue<short> repeated;
    list<int> permutations;
    bfs.push(0);
    repeated.push(0);
    sieve.reset();
    for(int i = 4; i<1024; i=i<<1){
        sieve[i-2] = 1;
    }
    while (!bfs.empty()) {
        int number = bfs.front();
        short visited = repeated.front();
        bfs.pop();
        repeated.pop();
        for(int i=1;i<10;i++){
            if((visited & (1<<i)) == 0){
                bfs.push(number * 10 + i);
                repeated.push(visited | (1<<i));
                if(sieve[visited | (1<<i)]) {
                    permutations.push_back(number * 10 + i);
                }
            }
        }
    }
    int count =0;
    while (!permutations.empty()) {
        int perm = permutations.back();
        permutations.pop_back();
        bool isPrime = true;
        for(list<int>::iterator it = primes.begin(); it != primes.end(); ++it){
            long p = *it;
            if (perm%p != 0) {
                if (p*p>perm) {
                    break;
                }
            } else {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            cout<<perm<<'\n';
            break;
        }
    }
    return 0;
}

//std::ios_base::sync_with_stdio(false);