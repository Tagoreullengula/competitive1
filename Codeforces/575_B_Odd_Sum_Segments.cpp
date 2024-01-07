#include <bits/stdc++.h>
#include <math.h>
#include <list>
using namespace std;
#define endl "\n";
#define fastIO ios::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);

int main()
{	fastIO;
	int q, n, k, odd_count;
	long long a;
	std::list<int> odd_list;
	cin>>q;
	for(int i = 0; i<q; i++){
		cin>>n;
		cin>>k;
		odd_list={};
		for(int j=0; j<n; j++){
			cin>>a;
			if(a%2==1){
				odd_list.push_back(j+1);
			}
		}
		odd_count = odd_list.size()+1-k;
		if(odd_count > 0 && odd_count%2 == 1){
			cout<<"YES"<<endl;
			for(int j = 1; j<k; j++){
				odd_count = odd_list.front();
				cout << odd_count<< " ";
				odd_list.pop_front();
			}
			cout<<n<< endl;
		} else {
			cout<<"NO"<<endl;
		}
	}
	return 0;
}