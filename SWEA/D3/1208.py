T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    cnt = int(input())
    boxs = list(map(int, input().split()))

    for i in range(cnt):
        high = max(boxs)
        low = min(boxs)

        boxs[boxs.index(high)] = high-1
        boxs[boxs.index(low)] = low+1

    high = max(boxs)
    low = min(boxs)

    print("#{} {}".format(test_case, high-low))

