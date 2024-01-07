#include <bits/stdc++.h> 
using namespace std; 
    
int maxPandigital = 0;
int visitedDigits = 0;
void verifyPandigital (int number){
    int pandigital = number;
    int n = 2;
    do{
        int prod = number * n;
        pandigital = pandigital*int(pow(10, int(log10(prod)) + 1)) + prod;
        n++;
    }while(int(log10(pandigital))+1 < 9);
    int verifyDigits = 0;
    int copy = pandigital;
    while(copy>0){
        int digit = copy%10;
        copy=copy/10;
        if((verifyDigits & (1<<digit)) == 0){
            verifyDigits += (1<<digit);
        } else {
            verifyDigits = 0;
            break;
        }
    }

    if(verifyDigits == 1022){
        maxPandigital = max(maxPandigital, pandigital);
    }
}

void perm(int number){
    if(number>=10000){
        return;
    }
    verifyPandigital(number);
    for(int i = 0; i<=9; i++){
        if((visitedDigits & (1<<i)) == 0){
            visitedDigits += 1<<i;
            perm(number*10 + i);
            visitedDigits = visitedDigits - (1<<i);
        }
    }
}

int main() {
    for(int i =1; i<=9; i++){
        visitedDigits += 1<<i;
        perm(i);
        visitedDigits = visitedDigits - (1<<i);
    }
    cout<< maxPandigital;
    return 0;
}

//std::ios_base::sync_with_stdio(false);