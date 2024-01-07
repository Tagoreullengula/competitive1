#include <bits/stdc++.h>
using namespace std;

list<long> sum(list<long> A , list<long>B){
    list<long> C;
    list<long> ::iterator ita = A.begin();
    list<long> ::iterator itb = B.begin();
    long carry =0;
    while(ita!=A.end() || itb != B.end()){
        long a,b;
        if(ita!=A.end()){
            a = *ita;
            ++ita;
        } else {
            a = 0;
        }
        if(itb!=B.end()){
            b = *itb;
            ++itb;
        } else {
            b = 0;
        }
        long c = a+b+carry;
        C.push_back(c%100000000000000000);
        carry = c/100000000000000000;
    }
    if(carry>0){
        C.push_back(carry);
    }
    return C;
}

int countDigits(list<long> num) {
    long lastNum = *num.rbegin();
    int count = 0;
    while (lastNum > 0) {
        lastNum=lastNum/10;
        count++;
    }
    return (num.size()-1) * 17 + count;
}

int main() {
    list<long> num;
    list<long> den;
    num.push_back(1);
    den.push_back(2);
    int count = 0;
    for(int i=1;i<=1000; i++){
        list<long> actualNum = sum(num, den);
        if(countDigits(actualNum)> countDigits(den)) {
            count++;
        }
        actualNum = sum(actualNum, den);
        num = den;
        den = actualNum;
    }
    cout<<count<<'\n';
    return 0;
}

//std::ios_base::sync_with_stdio(false);