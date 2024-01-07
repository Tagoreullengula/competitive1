#include <bits/stdc++.h>
using namespace std;

bitset<100000000> primeHash;
bitset<100000000> verifHash;
int tenPows[9]={};
list<int> primes;

bool isPrime(int number){
    if(!verifHash[number]){
        bool answer = true;
        for(list<int>::iterator it = primes.begin(); it!=primes.end() && answer; ++it){
            int prime = *it;
            if(prime*prime > number){
                break;
            } else {
                answer = number % prime !=0;
            } 
        }
        verifHash[number] = 1;
        primeHash[number] = answer;
    }
    return !!primeHash[number];
}

int getNumberOfPrimes(int number, list<int> pos, int ini, int limit, int digit) {
    int numberPrimes = 0;
    if ( ini == 0 && number - tenPows[*pos.rbegin()] * digit < tenPows[*pos.rbegin()]) {
        ini++;
    }
    list<int> qq;
    for(int i = ini, copy = number; i<=limit; i++, copy = number) {
        for (list<int>::iterator it = pos.begin(); it != pos.end(); ++it) {
            int position = *it;
            copy = copy - tenPows[position] * digit + tenPows[position] * i;
        }
        if (isPrime(copy)) {
            if(number == 121313){
                qq.push_back(copy);
            }
            numberPrimes++;
        }
    }
    if(number == 121313 && numberPrimes ==7) {
        for(list<int>::iterator it = qq.begin(); it != qq.end(); ++it){
            cout<<*it<<'\n';
        }
    }
    return numberPrimes;
}
int main() {
    for (int i = 0, p=1;i<=8;i++,p=p*10) {
        tenPows[i]=p;
    }
    isPrime(2);
    int number = 3;
    bool found = false;
    while (!found) {
        if (isPrime(number)) {
            int copy = number;
            list<int> positions[3];
            int coun = 0;
            positions[0]={};
            positions[1]={};
            positions[2]={};
            while (copy>0) {
                int digit = copy%10;
                copy = copy/10;
                if (digit<3) {
                    positions[digit].push_back(coun);
                }
                coun++;
            }
            for (int i=0; i<3 && !found; i++) {
                list<int> pos = positions[i];
                for (int j=1, maskLimit=1<<pos.size();j<maskLimit; j++) {
                    list<int> subSet;
                    list<int>::iterator it = pos.begin();
                    for (int k=1; k<=j; k=k<<1) {
                        if ((j&k) == k) {
                            subSet.push_back(*it);
                        }
                        ++it;
                    }
                    //cout<<j<<'\n';
                    if (getNumberOfPrimes(number, subSet, 0, i-1, i) == 0) {
                        if (getNumberOfPrimes(number, subSet, i+1, 9, i) == 7) {
                            found = true;
                            cout<<number<<'\n';
                            break;
                        }
                    }
                }
            }
            primes.push_back(number);
        }
        verifHash[number+1]=1;
        primeHash[number+1]=0;
        number += 2;
    }
    return 0;
}

//std::ios_base::sync_with_stdio(false);