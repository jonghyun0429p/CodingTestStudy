T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):

    N = int(input())

    buildings = list(map(int, input().split()))

    result = 0

    dx = [-2, -1, 1, 2]


    for i in range(2, N-2):
        max_height = buildings[i]
        min_diff = 255
        for j in range(4):
            now_building = buildings[i+dx[j]]
            if max_height < now_building:
                max_height = now_building
            else:
                if min_diff > max_height - now_building:
                    min_diff = max_height - now_building
        if max_height == buildings[i]:
            result += min_diff


    print("#{} {}".format(test_case, result))