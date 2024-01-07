#include <bits/stdc++.h>
using namespace std;
int limit = 12000;
int findFractions(int lnum, int lden, int num, int den, int rnum, int rden){
    if(den>limit){
        return 0;
    }
    return 1+ findFractions(lnum, lden, num+lnum, den+lden, num, den) + findFractions(num, den, num + rnum, den + rden, rnum, rden);
}
int main() {
    cout<<findFractions(1,3,2,5,1,2)<<'\n';
    return 0;
}

//std::ios_base::sync_with_stdio(false);