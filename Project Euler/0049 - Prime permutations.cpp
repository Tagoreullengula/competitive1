#include <bits/stdc++.h>
using namespace std;
long getDigitsPerm(int num){
    long perm=0;
    while(num>0){
        int d = num%10;
        num = num/10;
        perm += pow(10,d);
    }
    return perm;
}
int main() {
    bool sieve[10000]={};
    list<int> primes;
    list<long> primePerm;
    sieve[0]=false;
    sieve[1]=false;
    for(int i=2;i<10000; i++){
        if(!sieve[i]){
            for(int j = i*i;j<10000; j= j+i){
                sieve[j] = true;
            }
            if(i>=1000){
                primes.push_back(i);
                primePerm.push_back(getDigitsPerm(i));
            }
        }
    }
    while(primes.size()>1){
        int p1 = primes.front();
        long perm1 = primePerm.front();
        primes.pop_front();
        primePerm.pop_front();
        list<long>::iterator it2=primePerm.begin();
        for(list<int>::iterator it1 = primes.begin(); it1!= primes.end(); ++it1, ++it2){
            int p2= *it1;
            long perm2 = *it2;
            if(perm1 == perm2){
                int p3 = (p2<<1)-p1;
                if(p3>=10000){
                    break;
                }
                if(!sieve[p3] && getDigitsPerm(p3) == perm1){
                    cout<<p1<<p2<<p3<<'\n';
                }
            }
        }
    }
    return 0;
}

//std::ios_base::sync_with_stdio(false);