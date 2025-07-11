T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, L = map(int, input().split())

    TList = []
    KList = []

    for i in range(N):
        T, K = map(int, input().split())
        TList.append(T)
        KList.append(K)

    maxTaste = 0

    def dfs(start, Taste, kcal):
        global maxTaste
        if kcal > L:
            return
        if Taste > maxTaste:
            maxTaste = Taste
        if start == N:
            return

        dfs(start+1, Taste + TList[start], kcal + KList[start])
        dfs(start+1, Taste, kcal)

    dfs(0, 0, 0)

    print("#{} {}".format(test_case, maxTaste))

