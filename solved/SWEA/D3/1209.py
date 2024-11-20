T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    test = int(input())
    board = [list(map(int, input().split())) for i in range(100)]
    max_sum = 0
    left, right = 0, 0


    for i in range(100):
        row, col = 0, 0
        for j in range(100):
            row += board[i][j]
            col += board[j][i]

            if i == j:
                left += board[i][j]
            elif i+j == 99:
                right += board[i][j]


        if max_sum < row:
             max_sum = row
        if max_sum < col:
            max_sum = col

    if max_sum < left:
        max_sum = left
    if max_sum < right:
        max_sum = right

    print("#{} {}".format(test_case, max_sum))