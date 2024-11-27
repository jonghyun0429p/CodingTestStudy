import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**7)

N,M = map(int, input().split(' '))

point = [[] for i in range(N+1)]

visited = [False for i in range(N+1)]

stack = []

cnt = 0

def DFS(startNode):
    visited[startNode] = True

    for nextNode in point[startNode]:
        if not visited[nextNode]:
            DFS(nextNode)

for i in range(M):
    u, v = map(int, input().split(' '))
    point[u].append(v)
    point[v].append(u)

for i in range(1, N+1):
    if not visited[i]:
        DFS(i)
        cnt += 1

print(cnt)