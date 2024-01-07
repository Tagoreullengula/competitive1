#include <bits/stdc++.h> 
using namespace std; 
    
int main()
{
    int n = 1000000;
    bitset<1000001> A;
    int maxPow = (int) (log(n)/log(2)) + 1;
    long pows [maxPow]={};
    for (int i=2; i<=n; i++){
        long a = i;
        for (int j=1; j<=n; j++){
            if(!A[a]){
                A[a] = true;
                pows[j] += 1;
            } else {
                break;
            }
            a = a*i;
            if (a>n) {
                break;
            }
        }
    }
    bitset<20000001> allPows;
    long total = 0;
    int previous = 0;
    for (int i=1; i < maxPow; i++){
        for  (int j=2; j<=n; j++){
            int prod = i*j;
            allPows[prod] = true;
        }
        total = total + ( pows[i] * (allPows.count() - previous));
        previous = allPows.count();
    }
    cout<<total;
    return 0; 
}
//std::ios_base::sync_with_stdio(false);