T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    caseNumber = int(input())
    gradeList = list(map(int, input().split()))
    Dict = dict()
    result = [2]

    for i in gradeList:
        if i in Dict.keys():
            value = Dict[i]
            Dict[i] = value+1
        else:
            Dict[i] = 1

    MAX = max(Dict.values())

    for k, v in Dict.items():
        if v == MAX:
            result.append(k)

    result.sort()
    print("#{} {}" .format(caseNumber, result[-1]))



