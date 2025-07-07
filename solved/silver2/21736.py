import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N, M = map(int, input().split(' '))


def dfs(x, y, row, col, board, visited):
    count = 0

    # 보드 밖으로 나가는지 검사
    if x < 0 or x > row - 1 or y < 0 or y > col - 1:
        return 0

    # 막혀있거나 지나온 곳이면 취소
    if board[x][y] == "X" or visited[x][y]:
        return 0

    # P 만나면 +1
    if board[x][y] == "P":
        count = 1

    visited[x][y] = True

    for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
        count += dfs(x+dx, y+dy, row, col, board, visited)

    return count



board = []
visited = [[False] * M for _ in range(N)]
find_i = [0, 0, True]

for i in range(N):
    row = list(input().rstrip())
    board.append(row)

    if find_i[2]:
        for j in range(M):
            if row[j] == "I":
                find_i = [i, j, False]


count_P = dfs(find_i[0], find_i[1], N, M, board, visited)

if count_P == 0:
    print("TT")
else:
    print(count_P)