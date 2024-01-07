#include <bits/stdc++.h>
using namespace std;

list<int> dp[6][100]={};
bool visited[6]={};
int digits[6]={};
int answer,sp;
bool found;
void findCycle(int row, int twoD) {
    if(visited[row]) {
        if(row==0 && digits[0]==twoD && sp==6) {
            for(int i=0;i<6;i++){
                answer = answer + digits[i]*100+digits[(i+1)%6];
                cout<<digits[i]*100+digits[(i+1)%6]<<'\n';
            }
            found=true;
        }
        return;
    }
    visited[row] = 1;
    digits[sp] = twoD;
    sp++;
    for (list<int>::iterator it = dp[row][twoD].begin(); it!=dp[row][twoD].end() && !found; ++it) {
        int nextTwo= *it;
        for (int i=0; i<6 && !found; i++) {
            findCycle(i, nextTwo);
        }
    }
    sp--;
    visited[row]=0;
}

int main () {
    for (int i=0; i<6; i++) {
        int n = 1;
        int sum = i+2;
        while (n<10000) {
            if(n>=1000){
                dp[i][n/100].push_back(n%100);
            }
            n += sum;
            sum += i+1;
        }
    }
    sp=0;
    found=false;
    for (int i=0;i<6;i++) {
        for (int j=0;j<10;j++) {
            if(dp[i][j].size()>0){
                cout<<i<<' '<<j<<'\n';
            }
        }
    }
    for(int i=0; i<100 && !found; i++){
        findCycle(0, i);
    }
    cout<<answer<<'\n';
    return 0;
}

//std::ios_base::sync_with_stdio(false);s