#include <bits/stdc++.h>
using namespace std;
const int limit = 4000;
int primes[limit] = {};
int primeCounter = 0;
int dp [limit+1][limit+1] = {};
int primePartitions(int n, int p){
	if(dp[n][p] != -1){
		return dp[n][p];
	}
	dp[n][p]=0;
	for(int i=0; i<=n; i+=primes[p]){
		dp[n][p] += primePartitions(n-i, p-1);
	}
	return dp[n][p];
}

int main() {
	bitset<limit> sieve;
	sieve[0]=1;
	sieve[1]=1;
	for (int i =2; i<limit; i++) {
		if (!sieve[i]) {
			for (int j = i*i; j<limit; j+=i) {
				sieve[j] = 1;
			}
			primes[primeCounter]=i;
			primeCounter++;
		}
	}

	for(int i=0; i<=limit; i++){
		for(int j=1; j<=limit; j++){
			dp[i][j] = -1;
		}
		dp[0][i]=1;
	}
	for(int i=primes[0]; i<=limit; i+=primes[0]){
		dp[i][0] = 1;
	}
	for(int i=3, p=0; i<=limit; i++){
		if(primes[p+1]<i){
			p++;
		}
		int parti = primePartitions(i, p);
		cout<<i<<' '<<primes[p]<<'\n';
		cout<<parti<<'\n';
		if (parti>5000) {
			cout<<i<<'\n';
			break;
		}
	}
    return 0;
}

//std::ios_base::sync_with_stdio(false);