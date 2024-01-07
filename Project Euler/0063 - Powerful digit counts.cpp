#include <bits/stdc++.h>
using namespace std;
int countDigits(list<unsigned long> num){
    int c = 0;
    unsigned long last = *num.rbegin();
    while (last>0) {
        last=last/10;c++;
    }
    return c+(num.size()-1) * 17;
}
list<unsigned long> prod(list<unsigned long> num, int n){
    int c=0;
    list<unsigned long> newNum;
    for (list<unsigned long>::iterator it = num.begin(); it!=num.end(); ++it) {
        newNum.push_back(((*it)*n + c)%100000000000000000);
        c = ((*it)*n + c)/100000000000000000;
    }
    if (c!=0) {
        newNum.push_back(c);
    }
    return newNum;
}
int main () {
    int n = 1;
    int p = 1;
    int counter=0;
    list<unsigned long> num;
    num.push_back(n);
    while (countDigits(num) <= p) {
        while (countDigits(num) == p) {
            counter++;
            num = prod(num, n);
            p++;
        }
        n++;
        p=1;
        num.clear();
        num.push_back(n);
    }
    cout<<counter<<'\n';
    return 0;
}

//std::ios_base::sync_with_stdio(false);