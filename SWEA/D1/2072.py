T = int(input())

for test_case in range(1, T+1):
    numberList = list(map(int, input().split(' ')))
    sum = 0

    for i in range(10):
        if numberList[i] % 2 == 1:
            sum += numberList[i]

    print("#%d %d" % (test_case, sum))