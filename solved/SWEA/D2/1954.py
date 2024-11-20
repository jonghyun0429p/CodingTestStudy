# import sys
# sys.setrecursionlimit(10**4)

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())

    NBoard = [['0' for _ in range(N)] for _ in range(N)]

    visited = [[False for _ in range(N)] for _ in range(N)]

    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]

    count = 1

    def DFS(startX, startY):
        global count
        visited[startY][startX] = True
        NBoard[startY][startX] = count
        for i in range(4):
            x = startX + dx[i]
            y = startY + dy[i]
            if 0 <= x < N and 0 <= y < N:
                if visited[y][x] == False:
                    count += 1
                    DFS(x, y)

    DFS(0, 0)

    print("#{}" .format(test_case))
    for i in NBoard:
        print(*i)