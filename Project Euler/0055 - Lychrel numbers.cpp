#include <bits/stdc++.h>
using namespace std;

list<int> sum(list<int> number){
    list<int> sum;
    list<int>::iterator it = number.begin();
    list<int>::reverse_iterator rit = number.rbegin();
    int c = 0;
    while (it!=number.end()){
        int d = *it + *rit + c;
        c=d>9;
        sum.push_back(d%10);
        ++it;
        ++rit;
    }
    if(c){
        sum.push_back(1);
    }
    return sum;
}
bool isPalindrome(list<int> number) {
    bool isPalin = true;
    list<int>::iterator it = number.begin();
    list<int>::reverse_iterator rit = number.rbegin();
    for (int i=1; i<=(number.size()/2) && isPalin; i++, ++it, ++rit) {
        isPalin = (*it) == (*rit);
    }
    return isPalin;
}

int main() {
    int lycherlCount = 0;
    for(int i=1,copy; i<10000; i++){
        list<int> number;
        copy = i;
        while (copy>0) {
            number.push_back(copy%10);
            copy=copy/10;
        }
        bool isLycherl = true;
        for (int j=1; j<50 && isLycherl; j++) {
            number =  sum(number);
            isLycherl = !isPalindrome(number);
        }
        if(isLycherl){
            lycherlCount++;
        }
    }
    cout<<lycherlCount<<'\n';
    return 0;
}

//std::ios_base::sync_with_stdio(false);