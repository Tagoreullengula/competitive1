import math
x = 1000000
x = x-1
permElem = ['0', '1', '2','3', '4', '5', '6', '7', '8', '9']
n = 10
xPermutation = ''
fact = math.factorial(n)

for i in range (n, 0, -1):
    fact = int(fact / i)
    elem = int(x/fact)
    x = x%fact
    xPermutation += permElem.pop(elem)
print(xPermutation)
    


