n = 1000
cribe = [True]*n
primes = []
p = 0

for i in range(2,n):
    if(cribe[i]):
        primes.append(i)
        p=p+1
        for j in range(i+i, n, i):
            cribe[j]=False


smallFactor = [1]
maxPrimesFactors = [0]*p
def findAllFactors( ini, counter, lastNum): 
    for i in range(ini, p):
        current = lastNum * primes[i]
        if(i > ini):
            counter = 0
        if(current<=n):
            if(counter+1>maxPrimesFactors[i]):
                maxPrimesFactors[i] += 1
                smallFactor[0] *= primes[i]
            findAllFactors(i,counter+1,current)
        else:
            return

findAllFactors(0, 0, 1)
print(smallFactor[0])
