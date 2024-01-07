n = 1001
prod = [1]
for i in range (1,n):
    carry = 0
    for j in range(0, len(prod)):
	prod[j] = prod[j]*2 + carry
	if(prod[j]>=10):
	    carry = 1
	    prod[j] -= 10
	else:
	    carry = 0
    if(carry == 1):
	prod.append(carry)

digitsum = 0
for i in range (0, len(prod)):
    digitsum += prod[i]

print(digitsum)
