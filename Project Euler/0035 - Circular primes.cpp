#include <bits/stdc++.h> 
using namespace std; 

int main() {
    int n = 1000000;
    bool sieve [n+1];
    queue<int> primes;
    for(int i = 2; i<=n; i++){
        if(!sieve[i]){
            primes.push(i);
            for(int j = i+i;j<=n;j=j+i){
                sieve[j]=true;
            }
        }
    }
    int answer = 0;
    while(!primes.empty()) {
        int prime = primes.front();
        primes.pop();
        int numDigits = (int)log10(prime) + 1;
        int tenPow = pow(10, numDigits-1);
        int rotation = prime;
        int count = 1;
        do{
            if(!sieve[rotation]){
                //sieve[rotation] = true;
                //count++;
            } else {
                count = 0;
                break;
            }
            rotation = (rotation%10)*tenPow + (rotation/10);
        }while(rotation != prime);
        answer += count;
    }
    cout<<answer;
    return 0;
}

//std::ios_base::sync_with_stdio(false);