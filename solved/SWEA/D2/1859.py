T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.

for test_case in range(1, T + 1):
    days = int(input())
    costs = list(map(int, input().split()))
    max = costs[-1]
    sum = 0

    for i in range(days-1, -1, -1):
        if max<costs[i]:
            max = costs[i]
        else:
            sum += max - costs[i]

    print("#{} {}" .format(test_case, sum))

