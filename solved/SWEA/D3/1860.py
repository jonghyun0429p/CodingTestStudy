T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, M, K = map(int, input().split(' '))

    comingList = list(map(int, input().split()))
    comingList.sort()
    result = 'Possible'

    for i in range(N):
        count = (comingList[i] // M) * K - (i+1)
        if count < 0:
            result = 'Impossible'
            break


    print("#{} {}".format(test_case, result))
