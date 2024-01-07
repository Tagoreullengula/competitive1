#include <bits/stdc++.h>
using namespace std;
const int limit = 100;
unsigned long dp [limit+1][limit+1]={};
unsigned long partitions(int n, int p){
	if(dp[n][p] != -1){
		return dp[n][p];
	} 
	dp[n][p]=0;
	for(int i = 0; i<=n; i+=p){
		dp[n][p]+=partitions(n-i, p-1);
	}
	return dp[n][p];
}

int main() {
	for(int i=0; i<=limit; i++){
		for(int j=1; j<=limit; j++){
			dp[i][j]=-1;
		}
	}
	dp[0][0]=1;
	cout<<partitions(limit, limit-1)<<'\n';
    return 0;
}

//std::ios_base::sync_with_stdio(false);