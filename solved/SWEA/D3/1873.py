T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    H, W = map(int, input().split())

    board = [list(input()) for i in range(H)]

    tank = ['<', '>', '^', 'v']

    for i in range(H):
        for j in range(W):
            if board[i][j] in tank:
                targetX = j
                targetY = i

    N = int(input())
    NList = list(input())

    for i in NList:
        if i == 'U':
            if 0 <= targetY-1 < H  and board[targetY-1][targetX] == ".":
                board[targetY][targetX] = "."
                targetY -= 1

            board[targetY][targetX] = "^"
        elif i == 'D':
            if 0 <= targetY+1 < H and board[targetY+1][targetX] == ".":
                board[targetY][targetX] = "."
                targetY += 1

            board[targetY][targetX] = "v"
        elif i == 'L':
            if 0 <= targetX-1 < W and board[targetY][targetX-1] == ".":
                board[targetY][targetX] = "."
                targetX -= 1

            board[targetY][targetX] = "<"
        elif i == "R":
            if 0 <= targetX+1 < W  and board[targetY][targetX+1] == ".":
                board[targetY][targetX] = "."
                targetX += 1
            board[targetY][targetX] = ">"
        elif i == "S":
            if board[targetY][targetX] == '^':
                for i in range(1, targetY+1):
                    if board[targetY-i][targetX] == '#':
                        break
                    elif board[targetY-i][targetX] == '*':
                        board[targetY-i][targetX] = "."
                        break
            elif board[targetY][targetX] == 'v':
                for i in range(1, H-targetY):
                    if board[targetY+i][targetX] == '#':
                        break
                    elif board[targetY+i][targetX] == '*':
                        board[targetY + i][targetX] = "."
                        break
            elif board[targetY][targetX] == '<':
                for i in range(1, targetX+1):
                    if board[targetY][targetX-i] == '#':
                        break
                    elif board[targetY][targetX-i] == '*':
                        board[targetY][targetX-i] = "."
                        break
            elif board[targetY][targetX] == '>':
                for i in range(1, W-targetX):
                    if board[targetY][targetX+i] == '#':
                        break
                    elif board[targetY][targetX+i] == '*':
                        board[targetY][targetX+i] = "."
                        break
    # print("#{}".format(test_case), end=' ')
    for i in board:
        for j in i:
            print(j, end='')
        print()






