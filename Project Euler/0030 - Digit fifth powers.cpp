#include <bits/stdc++.h> 
using namespace std; 
    
int digitCounter [10];
long pows [10];
long globaSum = 0;
int maxd=0;

 bool verifyEqualty(long currentSum){
    int copy [10];
    for(int i = 0; i<10; i++){
        copy[i]= digitCounter[i];
    }
    while(currentSum>0){
        int digit = currentSum%10;
        currentSum =currentSum/10;
        if(copy[digit]>0) {
            copy[digit]--;
        } else {
            return false;
        }
    }
    for(int i = 0; i<10; i++){
        if(copy[i]>0){
            return false;
        }
    }
    return true;
}
 void formNumbers(int ini, long sum, int deep){
    if(deep == maxd) {
        return;
    }
    for(int i = ini; i>=0; i--){
        long newSum = sum + pows[i];
        digitCounter[i]++;
        if(verifyEqualty(newSum)){
            cout<<newSum<<'\n';
            globaSum += newSum;
        }
        formNumbers(i, newSum, deep+1);
        digitCounter[i]--;
    }
}

int main() {
    int p = 5;
    long num = 9;
    long ninePow = pow(9,p);
    long sum = ninePow;
    maxd = 1;
    while(num<=sum){
        maxd++;
        num =  num*10+9;
        sum = sum + ninePow;
    }
    
    for(int i = 0; i<10; i++){
        pows[i] = pow(i,p);
    }
    for(int i = 9; i>0;i--){
        digitCounter[i]++;
        formNumbers(i, pows[i],1);
        digitCounter[i]--;
    }
    cout<<globaSum;
    return 0;
}

//std::ios_base::sync_with_stdio(false);