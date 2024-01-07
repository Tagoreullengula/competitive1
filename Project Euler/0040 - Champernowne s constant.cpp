#include <bits/stdc++.h> 
using namespace std; 

int main() {
    int n= 7;
    int positions [n]= {1, 10, 100, 1000, 10000, 100000, 1000000};
    long prod = 1;
    long tenPows=1;
    int numDigits = 1;
    int previous = 0;
    for(int d = 0; d<n; d++) {
        while(true) {
            if(positions[d] <= previous + tenPows * 9 * numDigits) {
                int pos = positions[d] - previous - 1;
                cout<< to_string(tenPows + (pos/numDigits)).at(pos%numDigits)<<'\n';
                prod = prod * (to_string(tenPows + (pos/numDigits)).at(pos%numDigits) - '0');
                break;
            } else {
                previous += tenPows * 9 * numDigits;
                tenPows *= 10;
                numDigits++;
            }
        }
    }
    cout<<prod;
    return 0;
}

//std::ios_base::sync_with_stdio(false);