n = 101
fact = [1]

for i in range (1, n):
    carry = [0]
    for j in range (0, len(fact)):
	fact[j] = fact[j]*i
	if(j<len(carry)):
            fact[j] += carry[j]
	    carry[j] = int(fact[j]/10)
	else:
	    carry.append(int(fact[j]/10))
	fact[j] = fact[j]%10
	k = j+1
	while(j < len(carry) and carry[j]>0):
	    digit = carry[j]%10
	    carry[j] = int(carry[j]/10)		
    	    if(len(carry)>k):
		carry[k] += digit
	    else:
		carry.append(digit)
	    k += 1
    for j in range(len(fact), len(carry)):
	fact.append(carry[j])


sum = 0
for i in range (0, len(fact)):
    sum += fact[i]

print (sum)
