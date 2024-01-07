#include <bits/stdc++.h>
#include <math.h>
using namespace std;
#define endl "\n";
#define crap ios::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);

int main(){
	crap;
	int n;
	long long a, max_non_psquare=-1000001;
	bool hashMap [1000001]={false};
    for(int i=0;i<=1000;i++){
    	hashMap[(int)pow(i,2)] = true;
    }
    cin>>n;
	for(int i=0; i<n; i++){
		cin>>a;
		if((a<0 || !hashMap[a]) && a > max_non_psquare) {

			max_non_psquare = a;
		}
	}
	cout<<max_non_psquare<<endl;
	return 0;
}
