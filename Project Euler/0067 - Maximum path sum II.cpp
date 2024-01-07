#include <bits/stdc++.h>
using namespace std;

list<string> split(string cad, string separator){
	list<string> splitted;
	while(true){
		int pos = cad.find(separator);
		if(pos == string::npos){
			break;
		}
		splitted.push_back(cad.substr(0,pos));
		cad.erase(0,pos+1);
	}
	return splitted;
}


int main() {
    ifstream wordsFile ("p067_triangle.txt");
    string file;
    list<list<string>> lines;
    int c = 1;
    while(getline(wordsFile, file)){
    	c++;
    	lines.push_back(split(file+" "," "));
    }
    
    int dp[c]={};
    for (list<list<string>>::reverse_iterator rit = lines.rbegin(); rit != lines.rend(); ++rit) {
    	list<string> l = *rit;
    	int i=0;
    	//cout<<l.size()<<'\n';
    	for (list<string>::iterator it = l.begin(); it!=l.end(); i++, ++it) {
			//cout<<stoi(*it)<<" ";
    		dp[i] = stoi(*it) + max(dp[i], dp[i+1]);
    	}
    	//cout<<dp[0]<<'\n';
    }
    cout<<dp[0]<<'\n';
    return 0;
}

//std::ios_base::sync_with_stdio(false);