#include <bits/stdc++.h>
using namespace std;

int main() {
    int n = 100;
    int pascal [n+1][n+1] = {};
    pascal[0][0]=1;
    for(int i=1; i<=n; i++){
        pascal[i][0]=1;
        pascal[0][i]=1;
    }
    int count = n*2 + 1;
    int limit = 1000000;
    for (int i=1; i<=n; i++) {
        for (int j=1; j<=n-i; j++) {
            int sum = pascal[i][j-1]+pascal[i-1][j];
            if (sum<=limit) {
                pascal[i][j]=sum;
                count++;
            } else {
                pascal[i][j]=limit+1;
                break;
            }
        }
    }
    int greater = ((n+1)*(n+2))/2 - count;
    cout<<greater<<'\n';
    return 0;
}

//std::ios_base::sync_with_stdio(false);