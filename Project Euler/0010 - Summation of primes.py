limit = 2000001
sieve = [True]*limit
primeSum = 0
for i in range (2, limit, 1):
	if(sieve[i]):
		primeSum += i
		for j in range(i+i, limit, i):
			sieve[j]= False

print(primeSum)
