import sys
from collections import deque

input = sys.stdin.readline


def dfs(startNode):
    visited[startNode] = 1
    answer.append(startNode)
    for nextNode in graph[startNode]:
        if visited[nextNode] == 0:
            dfs(nextNode)

def bfs(startNode):
    visited[startNode] = 1
    que = deque()
    que.append(startNode)
    answer.append(startNode)
    while que:
        currentNode = que.popleft()
        for nextNode in graph[currentNode]:
            if visited[nextNode] == 0:
                visited[nextNode] = 1
                answer.append(nextNode)
                que.append(nextNode)



N, M, V = map(int, input().split(' '))

visited = [0 for i in range(N+1)]

graph = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, N+1):
    graph[i].sort()

answer = []

dfs(V)
print(*answer)
visited = [0 for i in range(N+1)]
answer = []

bfs(V)

print(*answer)
