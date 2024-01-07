#include <bits/stdc++.h>
using namespace std;

int visited;
bool sumVisited[40]={};
int n;
int halfN;
int innerPoly[20]={};
list<int> pStack;
long maxPerm;
void perm(int num, int p){
    if((visited&(1<<num))!= 0){
        return;
    }
    innerPoly[p] = num;
    if (p == halfN) {        
        int maxP =  *pStack.rbegin();
        if(innerPoly[maxP] + innerPoly[(maxP+1)%halfN + 1]< num + innerPoly[1] ){
            maxP = p;
        }
        int lineSum = innerPoly[maxP]+innerPoly[maxP%halfN +1] + halfN+1;
        int extVisited = 0;
        bool isValid = true;
        long newMax = 0;
        for (int i = 0; i<halfN && isValid; i++) {
            int nextP = maxP%halfN +1;
            int innerSum = innerPoly[maxP]+innerPoly[nextP];
            int extNum  = lineSum - innerSum;
            if (halfN+1<=extNum && extNum<=n && (extVisited&(1<<extNum)) == 0) {
                extVisited += (1<<extNum);
                newMax =newMax*1000;
                if(extNum >=10){
                    newMax =newMax*10;
                }
                newMax+= extNum*100+ innerPoly[maxP]*10 + innerPoly[nextP];
            } else {
                isValid=false;
            }
            maxP = nextP;
        }
        if(isValid && newMax>maxPerm){
            maxPerm = newMax;
        }
        return;
    }
    visited = visited + (1<<num);
    for (int i = 1; i<=halfN; i++) {
        if (((visited&(1<<i))==0) && !sumVisited[num + i]) {
            sumVisited[num+i]=true;
            int maxP = *pStack.rbegin();
            if(innerPoly[maxP] + innerPoly[maxP%halfN +1]< num + i ){
                pStack.push_back(p);
            }
            perm(i, p+1);
            if(p==*pStack.rbegin()){
                pStack.pop_back();
            }
            sumVisited[num+i]=false;
        }
    }
    visited = visited-(1<<num);
}
int main() {
    n = 10;
    halfN = n/2;
    pStack.push_back(0);
    innerPoly[0] = -n;
    maxPerm=0;
    visited=0;
    perm(1, 1);
    cout<<maxPerm<<'\n';
    return 0;
}

//std::ios_base::sync_with_stdio(false);