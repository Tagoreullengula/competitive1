#include <bits/stdc++.h>
using namespace std;

int tenPows[10];

int getNumberOfDigits(int number){
    int digitsCount = 0;
    while(number > 0){
        int d = number%10;
        number = number/10;
        digitsCount+=tenPows[d];
    }
    return digitsCount;
}
int main() {
    int n=1;
    int tenPow = 10;
    int limit = tenPow/6;
    for(int i = 0, p=1; i<10; i++, p=p*10){
        tenPows[i] = p;
    }
    while (true) {
        if (n>limit) {
            n = tenPow;
            tenPow *= 10;
            limit=tenPow/6;
        }
        int count = getNumberOfDigits(n);
        bool valid = true;
        for(int i=2, newNumber = n+n; i<=6 && valid; i++,newNumber+=n){
            valid = getNumberOfDigits(newNumber) == count;
        }
        if(valid){
            cout<<n<<'\n';
            break;
        }
        n++;
    }
    return 0;
}

//std::ios_base::sync_with_stdio(false);