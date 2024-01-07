#include <bits/stdc++.h>
using namespace std;

int main () {
    map<long, long> isSquare;
    long x = 2;
    long limit = 100000000000000;
    while (true) {
        long x2= x*x;
        if(x2>limit){
            break;
        }
        isSquare[x2] = x;
        x++;
    }
    int D = 0;
    long maxX=0;
    for (int d = 2; d<=1000; d++) {
        long y = 1;
        if(isSquare.find(d) != isSquare.end()){
            continue;
        }
        while(true){
            long y2 = y*y;
            long x2 = d*y2+1;
            if(x2>limit){
                cout<<d<<'\n';
                break;
            }
            if(isSquare.find(x2)!=isSquare.end()){
                if(maxX<isSquare[x2]){
                    maxX = isSquare[x2];
                    D = d;
                }
                break;
            }
            y++;
        }
    }
    cout<<D<<'\n';
    return 0;
}

//std::ios_base::sync_with_stdio(false);