def textCheck(rowword, colword, size):
    rowCount = 0
    colCount = 0
    if rowword and colword:
        for cnt in range(size//2):
            if rowword[cnt] == rowword[-cnt-1]:
                rowCount += 1
            if colword[cnt] == colword[-cnt-1]:
                colCount += 1
        if colCount == (size // 2):
            palList.append(colword)
        if rowCount == (size // 2):
            palList.append(rowword)
    elif rowword:
        for cnt in range(size//2):
            if rowword[cnt] == rowword[-cnt-1]:
                rowCount += 1
        if rowCount == (size // 2):
            palList.append(rowword)
    elif colword:
        for cnt in range(size//2):
            if colword[cnt] == colword[-cnt-1]:
                colCount += 1
        if colCount == (size // 2):
            palList.append(colword)
    return




T = 10

# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    size = int(input())

    board = [list(input()) for _ in range(8)]

    count = 0

    palList = []

    for col in range(8):
        for row in range(8):
            rowWord = []
            colWord = []
            rowCount = 0
            colCount = 0
            if col < 9-size and row < 9-size:
                for cnt in range(size):
                    rowWord.append(board[col][row+cnt])
                    colWord.append(board[col+cnt][row])
            elif col < 8 and row < 9-size:
                for cnt in range(size):
                    rowWord.append(board[col][row+cnt])
            elif col < 9-size and row < 8:
                for cnt in range(size):
                    colWord.append(board[col+cnt][row])
            textCheck(rowWord, colWord, size)
            count += 1

    print("#{} {}".format(test_case, len(palList)))