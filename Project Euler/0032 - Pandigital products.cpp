#include <bits/stdc++.h> 
using namespace std;
int visited = 0;
int pandigitalSum = 0;
bitset<100000> pandigitalRep;
void perm (int num, int deep){
    if(deep == 5){
        int tenPow = pow(10, deep-1);
        for(int i =0;i<deep/2;i++) {
            int prod = (num/tenPow) * (num%tenPow);
            tenPow =tenPow/10; 
            int copy = prod;
            bool shouldSum = !pandigitalRep[prod];
            
            int visities = visited;
            // if(num == 39186){
            //     cout<<prod<<'\n';
            //     cout<<shouldSum<<'\n'<<'\n';
            // }
            while (shouldSum && copy>0) {
                int digit = copy%10;
                copy = copy/10;
                if((visities&(1<<digit)) == 0){
                    visities |= (1<<digit);
                } else {
                    shouldSum = false;
                }
            }
            // if(num == 39186){
            //     cout<<prod<<'\n';
            //     cout<<shouldSum<<'\n'<<'\n';
            // }
            if(shouldSum && visities == 1022){
                //cout<< prod<<'\n';  
                pandigitalSum += prod;
                pandigitalRep[prod] = 1;
            }
        }
        return;
    }

    for(int i=1;i<=9;i++) {
        if((visited & (1<<i))== 0) {
            visited |= 1<<i;
            perm(num*10+i, deep+1);
            visited =visited - (1<<i);
        }
    }
}
int main()
{
    perm(0,0);
    cout<<pandigitalSum;
    return 0; 
}
//std::ios_base::sync_with_stdio(false);