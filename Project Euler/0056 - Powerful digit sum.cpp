#include <bits/stdc++.h>
using namespace std;

list<long> sum(list<long> a, list<long> b){
    list<long> c;
    list<long>::iterator ita = a.begin();
    list<long>::iterator itb = b.begin();
    long carry = 0;
    long lim = 100000000000000000;
    while (ita != a.end() || itb != b.end()) {
        long ad,bd;
        if(ita!=a.end()){
            ad = *ita;
            ++ita;
        } else {
            ad = 0;
        }
        if(itb!=b.end()){
            bd = *itb;
            ++itb;
        } else {
            bd = 0;
        }
        long cd = bd+ad+carry;
        c.push_back(cd%lim);
        carry = cd/lim;
    }
    if(carry>0){
        c.push_back(carry);
    }
    return c;
}

int main() {
    int maxDigitSum = 0;
    int n = 100;
    for(int a=1; a<n; a++){
        list<long> number;
        number.push_back(a);
        for(int b=1; b<n;b++){
            int count = 0;
            for(list<long>::iterator it = number.begin(); it!=number.end();++it){
                long copy = *it;
                while (copy>0) {
                    count += copy%10;
                    copy = copy/10;
                }
            }
            maxDigitSum = max(maxDigitSum,count);
            list<long> newProd;
            for(int i = 1; i<=a; i++){
                newProd = sum(newProd, number);
            }
            number = newProd;
        }
    }
    cout<<maxDigitSum<<'\n';
    return 0;
}

//std::ios_base::sync_with_stdio(false);