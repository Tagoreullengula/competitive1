#include <bits/stdc++.h>
using namespace std;

short primes[7];
short visited;
long sum = 0;
void permutations(long number, int numDigits) {
    if (numDigits>=4) {
        if ((number%1000)%primes[numDigits-4] != 0) {
            return;
        }
        if(numDigits==10){
            //cout<<number<<'\n';
            sum += number;
            return;
        }
    }
    for (int i = 0; i<10; i++) {
        if ((visited & (1<<i)) == 0) {
            visited += 1<<i;
            permutations(number*10 + i, numDigits+1);
            visited -= 1<<i;
        }
    }
}
int main() {
    primes[0] = 2;
    primes[1] = 3;
    primes[2] = 5;
    primes[3] = 7;
    primes[4] = 11;
    primes[5] = 13;
    primes[6] = 17;

    permutations(0,0);
    cout<<sum;
    return 0;
}

//std::ios_base::sync_with_stdio(false);