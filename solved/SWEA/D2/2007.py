T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    line = input()

    for i in range(1, 11):
        if line[:i] == line[i:2*i]:
            result = line[:i]
            break
    print("#{} {}".format(test_case, len(result)))