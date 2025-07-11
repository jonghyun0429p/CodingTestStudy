T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    sudoku = [list(input().split()) for _ in range(9)]

    result = 1

    for i in range(9):

        row = set()
        col = set()

        for j in range(9):

            rowLen = len(row)
            colLen = len(col)

            row.add(sudoku[i][j])
            col.add(sudoku[j][i])

            if len(row) == rowLen or len(col) == colLen:
                result = 0
                break
    if result != 0:
        for i in range(9):
            nine = set()
            for j in range(9):
                nineLen = len(nine)

                nine.add(sudoku[3*(i//3)+j//3][3*(i%3)+j%3])

                if len(nine) == nineLen:
                    result = 0
                    break


    print("#{} {}".format(test_case, result))
