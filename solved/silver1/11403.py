# import sys
# input = sys.stdin.readline
#
# N = int(input())
#
# graph = [[] for _ in range(N)]
#
# for i in range(N):
#     row = input().rstrip().split()
#     for j in range(N):
#         if row[j] == '1':
#             graph[i].append(j)
#
#
# def dfs(u, visited):
#     # u에서 갈 수 있는 모든 v에 대해 재귀
#     for v in graph[u]:
#         if not visited[v]:
#             visited[v] = True
#             dfs(v, visited)
#
#
# possible = []
# for i in range(N):
#     visited = [False] * N
#     dfs(i, visited)
#
#     row = ['1' if visited[j] else '0' for j in range(N)]
#     possible.append(row)
#
# # 4) 출력
# for row in possible:
#     print(' '.join(row))
import sys
input = sys.stdin.readline

N = int(input())
# 인접행렬 읽기
reach = [list(map(int, input().split())) for _ in range(N)]

# 플로이드-워셜로 경로 존재 업데이트
for k in range(N):
    for i in range(N):
        if reach[i][k]:
            for j in range(N):
                if reach[k][j]:
                    reach[i][j] = 1

# 출력
for row in reach:
    print(' '.join(map(str, row)))


