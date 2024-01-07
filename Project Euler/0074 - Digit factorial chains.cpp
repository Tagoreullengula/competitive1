#include <bits/stdc++.h>
using namespace std;

int main() {
	int arraySize = 10000000;
	int limit = 1000000;
    int dp [arraySize]={};
    int fact[10]={};
    fact[0]=1;
    for(int i = 1; i<10;i++){
    	fact[i] = fact[i-1]*i;
    }
    int counter = 0;
    for(int i =1; i<limit; i++){
    	long chainEle=i;
    	int length = 1;
    	list<long> chain;
    	while(chainEle>=arraySize || dp[chainEle]==0){
    		if(chainEle<arraySize){
    			dp[chainEle] = -length;
    			chain.push_back(chainEle);
    		}
    		length++;
    		long nextChain = 0;
    		while (chainEle>0) {
    			nextChain += fact[chainEle%10];
    			chainEle = chainEle/10;
    		}
    		chainEle = nextChain;
    	}
    	if (dp[chainEle]<0) {
    		int cycleLength = length + dp[chainEle];
    		for(list<long>::reverse_iterator rit = chain.rbegin(); rit != chain.rend(); ++rit) {
    			long ele = *rit;
    			dp[ele] = cycleLength;
    			chain.pop_back();
    			if(ele == chainEle){
    				break;
    			}
    		}
    		length = length - cycleLength;
    	}
    	length += dp[chainEle];
    	for(list<long>::iterator it = chain.begin(); it!=chain.end(); ++it){
    		dp[*it] = length + dp[*it];
    	}
    	if(dp[i] == 60){
    		counter++;
    	}
    }
    cout<<counter<<'\n';
    return 0;
}

//std::ios_base::sync_with_stdio(false);