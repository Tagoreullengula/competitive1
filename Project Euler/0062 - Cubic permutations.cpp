#include <bits/stdc++.h>
using namespace std;

int main () {
    map<long, set<long>> history={};
    long n = 2;
    int tenPows [10] = {};
    for(int i=0,p=1; i<10; i++, p*=10){
        tenPows[i] = p;
    }
    while(true){
        long cube = n*n*n;
        long copy = cube;       
        long frecuency=0;
        while(copy>0){
            frecuency += tenPows[copy%10];
            copy = copy/10;
        }
        set<long> permu = history[frecuency];
        permu.insert(cube);
        history[frecuency] = permu;
        if(permu.size()==5) {
            cout<<(*permu.begin())<<'\n';
            for(set<long>::iterator it=permu.begin(); it!=permu.end(); ++it){
                cout<<*it<<'\n';
            }
            break;
        }
        n++;
    }
    return 0;
}

//std::ios_base::sync_with_stdio(false);