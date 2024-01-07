#include <bits/stdc++.h>
using namespace std;

int passLength=3;
int intersection[1000]={};
list<unsigned char>encodedList;
unsigned char possiblePass[1000]={};
unsigned char encoded[1000000]={};
// Just print all possible decoded messages, and look for a string that makes sense.
void printComb (int p) {
	if (p == passLength) {
		int charSum = 0;
		for (int i=0; i<encodedList.size(); i++) {
			unsigned char decoded = (encoded[i] & ~possiblePass[i%passLength]) | (possiblePass[i%passLength] & ~encoded[i]);
    		charSum += decoded;
    		cout<<decoded;
    	}
    	cout<<'\n'<<charSum<<"\n\n";
    	return;
	}
	possiblePass[p]='a';
    for (int mask=1; mask<=intersection[p]; mask=mask<<1, possiblePass[p]++) {
    	if ((intersection[p] & mask) == mask) {
    		printComb(p+1);
    	}
    }
}

int main() {
    int ascii[256]={};
    for(unsigned char i=0; i<=256; i++) {
    	for(unsigned char letter = 'a'; letter<='z'; letter++){
    		unsigned char decripted = (letter & ~i) | (i & ~letter);
    		if ( 32<=decripted && decripted<=126) {
    			ascii[i] = ascii[i] + (1<<(letter-'a'));
    		}
    	}
    	if(i==255){break;}
    }
    ifstream wordsFile ("p059_cipher.txt");
    string file;
    getline(wordsFile, file);
    file=file+",";
    while(true){
    	int pos = file.find(",");
    	if(pos==string::npos){
    		break;
    	}
    	unsigned char letter = stoi(file.substr(0, pos));
    	encodedList.push_back(letter);
    	file.erase(0, pos+1);
    }
    encoded[encodedList.size()]={};
    list<unsigned char>::iterator it = encodedList.begin();
    for(int i=0; i<encodedList.size();i++,++it){
    	encoded[i]=*it;
    }
    for (int i=0; i<passLength; i++) {
    	intersection[i]=(1<<('z'-'a'+1))-1;
    	for (int j=i; j<encodedList.size(); j+=passLength) {
    		intersection[i]=intersection[i] & ascii[encoded[j]];
    	}
    }
    printComb(0);
    return 0;
}

//std::ios_base::sync_with_stdio(false);