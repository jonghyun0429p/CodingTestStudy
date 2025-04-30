import sys
input = sys.stdin.readline
sys.setrecursionlimit(10 ** 6)
T = int(input().rstrip())

for t in range(T):
    M, N, K = map(int, (input().rstrip().split(' ')))


    board = [[0 for i in range(M)] for j in range(N)]
    visited = [[0 for i in range(M)] for h in range(N)]

    for i in range(K):
        x, y = map(int, input().rstrip().split(' '))
        board[y][x] = 1

    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    def dfs(x, y):
        visited[x][y] = 1
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if 0 <= nx < N and 0 <= ny < M:
                if visited[nx][ny] == 0 and board[nx][ny] == 1:
                    dfs(nx, ny)

    answer = 0

    for i in range(N):
        for j in range(M):
            if visited[i][j] == 0 and board[i][j] == 1:
                dfs(i, j)
                answer += 1

    print(answer)
