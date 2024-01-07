d = 1001
n = int((d-1)/2)
sum = 1
if(d>1):
    sum += int((16*n*(2*n*n + 3*n + 1))/6) + 2*n*(n+1) + 4*n
print(sum)
