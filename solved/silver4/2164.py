import sys
from collections import deque

N = int(sys.stdin.readline().rstrip())

Nlist = deque()

for i in range(1,N+1):
    Nlist.append(i)

for i in range(N-1):
    Nlist.popleft()
    if(i == N-2):
        break
    Nlist.append(Nlist.popleft())

print(Nlist[0])
