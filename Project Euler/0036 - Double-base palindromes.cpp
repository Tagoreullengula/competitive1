#include <bits/stdc++.h> 
using namespace std; 

long palindromeSum = 0;
void isPalindrome(int number, int subNum){
    while(subNum>0){
        number = number*10 + subNum%10;
        subNum = subNum/10;
    }
    int numBase2 = 0;
    int twoPow = 1;
    do{
        numBase2 = numBase2<<1;
        if((number & (twoPow)) == twoPow){
            numBase2++;
        }
        twoPow = twoPow<<1;
    } while(twoPow <= number);
    if(numBase2 == number){
        //cout<<number<<'\n';
        palindromeSum += number;
    }
}
int main() {
    int n = 1000;
    for(int i = 1; i<n; i++){
        isPalindrome(i, i);
        isPalindrome(i, i/10);
        
    }
    cout<<palindromeSum;
    return 0;
}

//std::ios_base::sync_with_stdio(false);