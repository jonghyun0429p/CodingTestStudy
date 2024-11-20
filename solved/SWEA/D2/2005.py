T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    board = [[0] for _ in range(N)]
    board[0] = [1]

    for i in range(1, N):
        for j in range(i+1):
            if j == 0:
                board[i] = [1]
            elif j == i:
                board[i].append(1)
            else:
                board[i].append(board[i-1][i-j-1] + board[i-1][i-j])

    print("#{}".format(test_case))
    for i in board:
        print(*i)