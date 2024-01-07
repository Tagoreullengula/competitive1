#include <bits/stdc++.h>
using namespace std;

int main() {
    long tenDigits = 10000000000;
    long sum = 0;
    for(int i =1; i<=1000; i++){
        long prod = 1;
        for(int j=1;j<=i;j++){
            prod = (prod*i)%tenDigits;
        }    
        sum = (sum+prod)%tenDigits;
    }
    cout<<sum;
    return 0;
}

//std::ios_base::sync_with_stdio(false);