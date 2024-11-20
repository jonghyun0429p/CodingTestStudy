from collections import deque

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    def dfs(n):
        global result
        if n == cnt:
            result = max(result, int("".join(map(str, lst))))
            return

        for i in range(L-1):
            for j in range(i+1, L):
                lst[i], lst[j] = lst[j], lst[i]

                check = int("".join(map(str, lst)))
                if [n, check] not in visited:
                    visited.append([n, check])
                    dfs(n+1)

                lst[j], lst[i] = lst[i], lst[j]

    num, cnt = map(str, input().split())
    visited = []
    cnt = int(cnt)
    L = len(num)
    lst = []
    for i in num:
        lst.append(i)
    result = 0
    dfs(0)

    print("#{} {}".format(test_case, result))