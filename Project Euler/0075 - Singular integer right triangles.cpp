#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b){
	if(a%b==0){
		return b;
	} else {
		return gcd(b, a%b);
	}
}
int main() {
	int limit = 1500000;
	short primiTriplet [limit+1]= {};
	short kTriplet [limit+1]= {};
	int m = 2;
	while(2*m*(m+1)<=limit){
		for(int n = 1+(m%2); n<m; n+=2){
			int l = 2*m*(m+n);
			if(l>limit){
				break;
			}
			if(gcd(m, n) == 1){
				primiTriplet[l]++;
			}
		}
		m++;
	}

	int counter = 0;
	for(int l=2; l<=limit; l+=2){
		if(primiTriplet[l] + kTriplet[l] == 1){
			counter++;
		}
		if(primiTriplet[l]>0){
			for(int kl = l+l; kl<=limit; kl+=l){
				kTriplet[kl] += primiTriplet[l];
			}
		}
	}
	cout<<counter<<'\n';
    return 0;
}

//std::ios_base::sync_with_stdio(false);