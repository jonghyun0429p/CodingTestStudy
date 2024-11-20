import sys
from collections import deque
input = sys.stdin.readline

M, N = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]

q = deque()

for col in range(N):
    for row in range(M):
        if board[col][row] == 1:
            q.append((row, col))

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
max_day = 0

def bfs():
    global max_day
    while q:
        nowX , nowY = q.popleft()
        for i in range(4):
            nextX = nowX + dx[i]
            nextY = nowY + dy[i]

            if 0 <= nextX < M and 0 <= nextY < N and board[nextY][nextX] == 0:
                board[nextY][nextX] = board[nowY][nowX] + 1
                if board[nextY][nextX] > max_day:
                    max_day = board[nextY][nextX]
                q.append([nextX, nextY])

bfs()

for row in board:
    for i in row:
        if i == 0:
            print(-1)
            exit()

if max_day != 0:
    print(max_day-1)
else:
    print(max_day)