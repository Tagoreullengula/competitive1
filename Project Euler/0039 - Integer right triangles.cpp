#include <bits/stdc++.h> 
using namespace std; 

int main() {
    int P = 1000;
    int pCounter [P+1] = {};
    double eps = 0.000000001;
    int max = 0;
    for(int a=1; a<=P/3; a++){
        long b = a;
        long aPow = pow(a,2);
        while(true){
            long double cDec = sqrt(aPow + b*b);
            int c = roundl(cDec);
            if(a+b+cDec<=P){
                if(abs(cDec-c) < eps){
                    pCounter[a+b+c]++;
                }
            } else {
                break;
            }
            b++;
        }
    }
    for(int i=1; i<=P; i++){
        if(pCounter[i]>pCounter[max]){
            max = i;
        }
    }
    cout<<max;
    return 0;
}

//std::ios_base::sync_with_stdio(false);