n = 28123
n +=1
sieve = [True] * n
primes = []
for i in range (2, n):
    if(sieve[i]):
	primes.append(i)
	for j in range(i+i, n, i):
	    sieve[j]=False

abundants = []
def findAbundantNumbers(number, p, divSum, partialSum):
    for i in range(p, len(primes)):
	newNumber = number*primes[i]
	if(newNumber>=n):
	    return
	if(i == p):
	    partialSum *=  primes[i]
	else:
	    partialSum = divSum * primes[i]
	newDivSum  = divSum + partialSum + number
	if(newDivSum > newNumber):
	    abundants.append(newNumber)
	findAbundantNumbers(newNumber, i, newDivSum, partialSum)

findAbundantNumbers(1,0,0,0)

formedNumbers = [True] * n
nSum = int((n*(n-1))/2)
for i in range (0, len(abundants)):
    for j in range (i, len(abundants)):
	formed = abundants[i]+abundants[j]
	if(formed<n and formedNumbers[formed]):
	    nSum -= formed
	    formedNumbers[formed] = False
	    

print (nSum)
