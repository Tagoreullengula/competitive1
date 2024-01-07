#include <bits/stdc++.h> 
using namespace std; 

int coins [1000]={};
int possibleComb[1000][1000]={};

int getComb(int num, int coin){
    if(possibleComb[num][coin] != -1){
        return possibleComb[num][coin];
    }
    possibleComb[num][coin] = 0;
    for( int newN = num - coins[coin]; newN >=0; newN =newN - coins[coin]){
        possibleComb[num][coin] += getComb(newN, coin-1);
    }
    possibleComb[num][coin] += getComb(num, coin-1);
    return possibleComb[num][coin];
}
int main() {
    int n = 200;
    int numCoins = 8;
    coins[0] = 1;
    coins[1] = 2;
    coins[2] = 5;
    coins[3] = 10;
    coins[4] = 20;
    coins[5] = 50;
    coins[6] = 100;
    coins[7] = 200;
    for(int i = 0; i< numCoins; i++){
        possibleComb[0][i] = 1;
    }
    for(int i = coins[0]; i<=n; i += coins[0]){
        possibleComb[i][0]= 1;
    }
    for(int i = 1; i<=n; i++){
        for(int j = 1; j<numCoins; j++){
            possibleComb[i][j]= -1;
        }
    }
    cout<<getComb(n, numCoins-1);
    for (int i = 0; i<=n; i++){
        for (int j = 0; j<numCoins; j++){
            cout<<possibleComb[i][j]<<' ';
        }
        cout<<'\n';
    }
    return 0;
}

//std::ios_base::sync_with_stdio(false);