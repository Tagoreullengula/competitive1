limit = 1000001
dp = [0]*limit
largestChain = 1
ln = 0
dp[1]=1
for i in range (2, limit):
    stack = []
    n = i
    counter = 0
    while(n >= limit or dp[n] == 0):
	if(n<limit):
    	    stack.append(n)
            dp[n] = counter
	counter += 1
	if(n%2 == 0):
	    n =n/2
	else:
	    n=3*n+1
    counter += dp[n]
    while(len(stack) > 0):
	n = stack.pop(0)
	dp[n] = counter-dp[n]

    if(largestChain<=counter):
	largestChain = counter
	ln = i		 

print(ln)
