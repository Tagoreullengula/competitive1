#include <bits/stdc++.h>
using namespace std;
const int limit = 5000;
int dp[limit+1][limit+1]={};
int mod = 1000000;
int partitions(int n, int p){
	if (dp[n][p] != -1) {
		return dp[n][p];
	}
	dp[n][p]=0;
	for (int i = 0; i<=n; i+=p) {
		dp[n][p] = (dp[n][p] + partitions(n-i, p-1)) % mod;
	}
	return dp[n][p];
}
int main() {
	for(int i = 0; i<=limit; i++){
		for(int j = 1; j<=limit; j++){
			dp[i][j]=-1;
		}
	}
	dp[0][0]=1;
	for(int i = 1; i<=limit; i++){
		int partiMod = partitions(i,i);
		//cout<<i<<'\n';
		if(partiMod == 0){
			cout<<i<<'\n';
			break;
		}
	}
	cout<<"complete\n";
    return 0;
}

//std::ios_base::sync_with_stdio(false);