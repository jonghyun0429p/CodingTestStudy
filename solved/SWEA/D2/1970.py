T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):

    money = int(input())

    lst = [0 for i in range(8)]
    def recusive(x):
        if x // 50000 >= 1:
            lst[0] += 1
            recusive(x - 50000)
        elif x // 10000 >= 1:
            lst[1] += 1
            recusive(x - 10000)
        elif x // 5000 >= 1:
            lst[2] += 1
            recusive(x - 5000)
        elif x // 1000 >= 1:
            lst[3] += 1
            recusive(x - 1000)
        elif x // 500 >= 1:
            lst[4] += 1
            recusive(x - 500)
        elif x // 100 >= 1:
            lst[5] += 1
            recusive(x - 100)
        elif x // 50 >= 1:
            lst[6] += 1
            recusive(x - 50)
        elif x // 10 >= 1:
            lst[7] += 1
            recusive(x - 10)
        else:
            print("#{}".format(test_case))
            print(*lst)

    recusive(money)
