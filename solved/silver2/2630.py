import sys
input = sys.stdin.readline


def divideAndConquer(row, col, size):
    color = colorPaper[col][row]

    for i in range(col, col+size):
        for j in range(row, row+size):
            if color != colorPaper[i][j]:
                divideAndConquer(row, col, size // 2)
                divideAndConquer(row + size // 2, col, size // 2)
                divideAndConquer(row, col + size // 2, size // 2)
                divideAndConquer(row + size // 2, col + size // 2, + size // 2)
                return
    if color:
        counts.append(1)
    else:
        counts.append(0)



N = int(input())

colorPaper = [list(map(int, input().split(' '))) for _ in range(N)]

counts = []

divideAndConquer(0, 0, N)

print(counts.count(0))
print(counts.count(1))





