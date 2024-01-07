#include <bits/stdc++.h>
#include <fstream>
using namespace std;

int main() {
    ifstream wordsFile ("p042_words.txt");
    string words;
    getline(wordsFile,words);
    int count = 0;
    while (true) {
        int pos = words.find(",");
        if(pos == string::npos){
            break;
        }
        string word = words.substr(0,pos);
        int sum = 0;
        for(int i = 1; i<word.length()-1; i++) {
            sum = sum + (word[i] - 'A' + 1);
        }
        double realN = (sqrt(1 + 8*sum) - 1)/2;
        long intN = round(realN);
        if(abs(realN-intN)< 0.000000001 ){
            count++;
        }
        words.erase(0, pos + 1);
    }
    cout<< count;
    return 0;
}

//std::ios_base::sync_with_stdio(false);