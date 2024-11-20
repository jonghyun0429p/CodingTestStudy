T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, K = map(int, input().split())

    puzzle = [list(map(int, input().split())) for _ in range(N)]

    result = 0

    for col in range(N):
        colCount = 1
        rowCount = 1
        for row in range(N):
            if 0 < row < N:
                if puzzle[col][row] == 1 and puzzle[col][row] == puzzle[col][row-1]:
                    rowCount += 1
                if puzzle[row][col] == 1 and puzzle[row][col] == puzzle[row-1][col]:
                    colCount += 1

                if puzzle[col][row] == 0:
                    if rowCount == K:
                        result += 1
                    rowCount = 1
                if puzzle[row][col] == 0:
                    if colCount == K:
                        result += 1
                        
                    colCount = 1

        if rowCount == K:
            result += 1
        if colCount == K:
            result += 1

    print("#{} {}".format(test_case, result))