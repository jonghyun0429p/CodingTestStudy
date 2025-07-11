T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):

    numList = list(map(int, input().split()))

    numList.remove(min(numList))
    numList.remove(max(numList))
    sum = 0

    for i in numList:
        sum += i

    result = round(sum / 8)

    print("#{} {}".format(test_case, result))