n = 10001
sieve = [True]*n
primes = []
for i in range (2, n):
    if(sieve[i]):
	primes.append(i);
	for j in range (i+i,n,i):
	    sieve[j] = False

global amicables
global sum

amicables = [-1]*n
sum = 0
def verify (number, divSum):
    global amicables
    global sum
    if(number < n and divSum < n and divSum > 1):
	if(amicables[number] == -1):
            if(amicables[divSum]==-1):
		amicables[divSum] = []
	    amicables[divSum].append(number)
	    amicables[number] = []
	else:
	    for i in range (0, len(amicables[number])):
		if(amicables[number][i] == divSum):
#		    print(number, divSum)
		    sum += number + divSum

def newInteger(number, p, completeSum, partialSum):
    for i in range(p, len(primes)):
	newNumber = number * primes[i]
	if(newNumber >= n):
	    return
        if(i == p):
	    partialSum *= primes[i]
  	else:
	    partialSum = completeSum * primes[i]
	newCompleteSum = completeSum + partialSum + number
	verify(newNumber, newCompleteSum)
	newInteger(newNumber, i, newCompleteSum, partialSum)
newInteger(1,0,0,0)
print(sum)
