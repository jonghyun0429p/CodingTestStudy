import sys

a,b = map(int, sys.stdin.readline().rstrip().split(' '))

numlist = []
sum = 0

for i in range(1, 1000):
    for j in range(1, 1+i):
        numlist.append(i)

for i in range(a-1, b):
    sum += numlist[i]
    
print(sum)