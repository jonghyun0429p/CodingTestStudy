import sys
from collections import deque
input = sys.stdin.readline


N, M = map(int, input().split())
board = [list(input().rstrip()) for _ in range(N)]
visited = [[False] * M for _ in range(N)]

def bfs(row, col):
    q = deque()
    visited[col][row] = True
    q.append((row, col, 1))

    while q:
        pop_row, pop_col, count = q.popleft()

        if pop_row == M-1 and pop_col == N - 1:
            print(count)
            break

        for dx, dy in ((1,0), (0,1), (-1, 0), (0, -1)):
            after_row = pop_row + dx
            after_col = pop_col + dy
            if 0 <= after_col < N and 0 <= after_row < M:
                if not visited[after_col][after_row] and board[after_col][after_row] == "1":
                    visited[after_col][after_row] = True
                    q.append((after_row, after_col, count + 1))

bfs(0, 0)