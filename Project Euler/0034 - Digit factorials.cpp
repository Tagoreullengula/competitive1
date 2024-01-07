#include <bits/stdc++.h> 
using namespace std;
int removeDigit(int number, int d){
    int tenPow =  pow(10, d);
    return (number%tenPow) + (number/(tenPow*10))*tenPow;
}
int main()
{
    queue<int> numbers;
    queue<int> factSum;
    int fact [10];
    fact[0]=1;
    for(int i =1;i<10;i++){
        fact[i] = i*fact[i-1];
        numbers.push(i);
        factSum.push(fact[i]);
    }
    long sum = 0;
    int p = numbers.size();
    while(!numbers.empty()){
        int num = numbers.front();
        int digitFactSum = factSum.front();
        numbers.pop();
        factSum.pop();
        if(digitFactSum + fact[9] >= num){
            for(int i = 0; i<10; i++){
                int newNum = num*10+i;
                int newFactSum = digitFactSum + fact[i];
                if(newNum == newFactSum){
                    cout<<newNum<<'\n'<<'\n';
                    sum += newFactSum;
                }
                numbers.push(newNum);
                factSum.push(newFactSum);
            }
        }
    }
    cout<<sum;
    return 0; 
}
//std::ios_base::sync_with_stdio(false);