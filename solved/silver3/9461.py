memo = [1,1,1,2,2,3,4,5]

T = int(input())

for test_case in range(T):
    N = int(input())
    #만약 저장된 수들 보다 더 큰 번째의 삼각형이라면,
    if N > len(memo):
        #없는 수부터, N까지
        for i in range(len(memo), N):
            #삼각형 변의 길이를 구해서 저장한다.
            memo.append(memo[i-1]+memo[i-5])
    print(memo[N-1])