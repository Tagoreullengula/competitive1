#include <bits/stdc++.h>
using namespace std;
//Larger numbers, works in Python
int twoProd;
unsigned long gcd(unsigned long a, unsigned long b){
    if(a%b==0){
        return b;
    } else {
        return gcd(b,a%b);
    }
}
int getA(int n){
    int v =1;
    if(n%3==0){
        v = twoProd;
        twoProd-=2;
    }
    return v;
}
int main () {
    int n=50;
    twoProd = (n/3)*2;
    unsigned long num = 1;
    unsigned long den = getA(n);
    unsigned long divisor;
    n--;
    while (n>=2) {
        int ai = getA(n);
        unsigned long newDen = ai * den + num;
        num = den;
        den = newDen;
        divisor = gcd (num,den);
        num = num/divisor;
        den = den/divisor;
        n--;
    }
    num = num + den*2;
    divisor = gcd(num,den);
    num = num/divisor;
    cout<<num<<'/'<<den<<'\n';
    int sum = 0;
    while(num>0){
        sum += (num%10);
        num = num/10;
    }
    cout<<sum<<'\n';
    return 0;
}

//std::ios_base::sync_with_stdio(false);