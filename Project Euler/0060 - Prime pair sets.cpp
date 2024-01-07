#include <bits/stdc++.h>
using namespace std;

bitset<20000000> sieve;
list<set<int>> history[5000][4];
bool isConcatPrime(int primeA, int primeB){
    bool isPrime = !sieve[stoi(to_string(primeA)+to_string(primeB))];
    if (isPrime) {
        isPrime = !sieve[stoi(to_string(primeB)+to_string(primeA))];
    }
    return isPrime;
}

bool formsPrimes (set<int> primes, int p) {
    bool is = primes.size()>0 && primes.find(p) == primes.end();
    for (set<int>::iterator it = primes.begin(); it!=primes.end() && is; ++it) {
        is = isConcatPrime(*it, p);
    }
    return is;
}
int main () {
    sieve[0]=1;
    sieve[1]=1;
    list<int> primes;
    for (long i=2;i<20000000; i++) {
        if (!sieve[i]) {
            for (long j = i*i;j<20000000; j=j+i) {
                sieve[j] = 1;
            }
            primes.push_back(i);
        }
    }
    primes.remove(2);
    primes.remove(5);
    for (list<int>::iterator it=primes.begin(); it!=primes.end(); ++it) {
        if(*it>=5000){
            break;
        }
        set<int> p;
        p.insert(*it);
        history[*it][0].push_back(p);
    }
    bool finish = false;
    int n=3;
    
    while (!finish) {
        for (list<int>::iterator it1 = primes.begin(); it1!=primes.end() && *it1<n && !finish; ++it1) {
            int prime = *it1;
            int subSum = n - prime;
            for (list<set<int>>::iterator it2 = history[subSum][2].begin(); it2!=history[subSum][2].end(); ++it2) {
                if (formsPrimes(*it2, prime)) {
                    cout<<n<<'\n';
                    finish=true;
                    break;
                }
            }
            for (int i=0;i<3 && !finish; i++) {
                for (list<set<int>>::iterator it2 = history[subSum][i].begin(); it2!=history[subSum][i].end(); ++it2) {
                    if (formsPrimes(*it2, prime)) {
                        set<int> newSet(*it2);
                        newSet.insert(prime);
                        history[n][i+1].push_back(newSet);
                    }
                }
                if (n == 792 && i == 2 && prime == 3) {
                    cout<<history[n][i+1].size()<<'\n';
                    for (list<set<int>>::iterator it2 = history[n][i+1].begin(); it2!=history[n][i+1].end(); ++it2) {
                        for(set<int>::iterator it3 = (*it2).begin(); it3!=(*it2).end(); ++it3) {
                            cout<<*it3<<' ';
                        }
                        cout<<'\n';
                    }
                }
            }
        }
        //cout<<n<<'\n';
        n++;
    }
    return 0;
}

//std::ios_base::sync_with_stdio(false);