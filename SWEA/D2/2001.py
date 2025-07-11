T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, M = map(int, input().split())

    board = [list(map(int, input().split())) for _ in range(N)]
    maxSum = 0
    numberSum = 0

    for col in range(N - M + 1):
        for row in range(N - M + 1):
            numberSum = 0
            for i in range(M):
                for j in range(M):
                    numberSum += board[col+i][row+j]
            if numberSum > maxSum:
                maxSum = numberSum

    print("#{} {}".format(test_case, maxSum))

