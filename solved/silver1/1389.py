# import sys
# input = sys.stdin.readline
# # sys.setrecursionlimit(100000)
# from collections import deque
#
# N, M = map(int, input().split())
# friend_list = [[] for _ in range(N + 1)]

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

# bacon_list = [0]
#
# for _ in range(M):
#     a, b = map(int, input().split())
#     friend_list[a].append(b)
#     friend_list[b].append(a)
#
# def bfs(start):
#     visited = [False] * (N + 1)
#     dist = [0] * (N + 1)
#     q = deque()
#     q.append(start)
#     visited[start] = True
#
#     while q:
#         now = q.popleft()
#         for neighbor in friend_list[now]:
#             if not visited[neighbor]:
#                 visited[neighbor] = True
#                 dist[neighbor] = dist[now] + 1
#                 q.append(neighbor)
#
#     return sum(dist[1:])


# for i in range(1, N+1):
#     bacon_list.append(bfs(i))
# print(bacon_list.index(min(bacon_list[1:])))

#플로이드-워셜

import sys
input = sys.stdin.readline

# 1) 입력
N, M = map(int, input().split())

# 2) 초기화
INF = 10**9
dist = [[INF]*(N+1) for _ in range(N+1)]
for i in range(1, N+1):
    dist[i][i] = 0

# 3) 친구 관계 반영
for _ in range(M):
    A, B = map(int, input().split())
    dist[A][B] = 1
    dist[B][A] = 1

# 4) 플로이드–워셜
for k in range(1, N+1):
    for i in range(1, N+1):
        # i에서 k까지 혹은 k에서 j까지가 무한대면 넘어가도 무방
        di_k = dist[i][k]
        if di_k == INF:
            continue
        row_i = dist[i]
        row_k = dist[k]
        for j in range(1, N+1):
            # i→j > i→k + k→j 라면 갱신
            if row_i[j] > di_k + row_k[j]:
                row_i[j] = di_k + row_k[j]

# 5) 케빈 베이컨 수 계산 & 정답 출력
min_sum = INF
answer = 0
for i in range(1, N+1):
    total = sum(dist[i][1:])
    if total < min_sum:
        min_sum = total
        answer = i

print(answer)







