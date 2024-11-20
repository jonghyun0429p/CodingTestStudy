import sys
from collections import deque

def BFS(X):
    que = deque()
    que.append(X)

    while que:
        x = que.popleft()

        for i in List[x]:
            if not visit[i]:
                que.append(i)
                visit[i] = True

    visit[1] = False

count = int(sys.stdin.readline().rstrip())

pair = int(sys.stdin.readline().rstrip())

List = [[] for i in range(count+1)]
visit = [False for i in range(count+1)]

for i in range(pair):
    a, b = map(int, sys.stdin.readline().rstrip().split(' '))
    List[a].append(b)
    List[b].append(a)

BFS(1)

print(visit.count(True))