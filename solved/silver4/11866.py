import sys
from collections import deque

N, K = map(int,(sys.stdin.readline().rstrip().split(' ')))

List = deque()

for i in range(1, N+1):
    List.append(i)

print('<', end='')
for i in range(1, N+1):
    for j in range(K):
        List.append(List.popleft())
    if(i == N):
        print(List.pop(), end='')
    else:
        print(List.pop(), end=', ')
print('>', end='')