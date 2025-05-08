import sys
input = sys.stdin.readline
# sys.setrecursionlimit(100000)
from collections import deque

N, M = map(int, input().split())
friend_list = [[] for _ in range(N + 1)]

#DFS로 해결
# for _ in range(M):
#     a, b = map(int, input().split())
#     friend_list[a].append(b)
#     friend_list[b].append(a)
#
# bacon_list = [0] * (N + 1)
#
# def dfs(v, depth):
#     if min_bacon[v] > depth:
#         min_bacon[v] = depth
#         for i in friend_list[v]:
#             dfs(i, depth + 1)
#     print(min_bacon)
#
# for i in range(1, N + 1):
#     min_bacon = [int(1e9)] * (N + 1)
#     dfs(i, 0)
#     bacon_list[i] = sum(min_bacon[1:])  # 0번 노드는 제외
#
# print(bacon_list.index(min(bacon_list[1:])))

#BFS로 해결

bacon_list = [0]

for _ in range(M):
    a, b = map(int, input().split())
    friend_list[a].append(b)
    friend_list[b].append(a)

def bfs(start):
    visited = [False] * (N + 1)
    dist = [0] * (N + 1)
    q = deque()
    q.append(start)
    visited[start] = True

    while q:
        now = q.popleft()
        for neighbor in friend_list[now]:
            if not visited[neighbor]:
                visited[neighbor] = True
                dist[neighbor] = dist[now] + 1
                q.append(neighbor)

    return sum(dist[1:])


for i in range(1, N+1):
    bacon_list.append(bfs(i))

print(bacon_list.index(min(bacon_list[1:])))




