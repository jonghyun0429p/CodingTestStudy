import sys

N = int(sys.stdin.readline().rstrip())

Plist = list(map(int, sys.stdin.readline().rstrip().split(' ')))

Plist.sort(reverse=True)

count = 0
for i in range(N):
    for j in range(i+1):
        count += Plist[i]
        
print(count)