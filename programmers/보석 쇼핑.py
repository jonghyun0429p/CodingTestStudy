gems = list(input().split())
gems_dict = dict()


def solutions(gems):

    n = len(gems)
    left = 0
    gem_count_dict = {}
    min_count = 100000
    answer = []

    # 리스트를 딕셔너리로
    for gem in gems:
        gems_dict[gem] = gems_dict.get(gem, 0) + 1

    gem_count = len(gems_dict.keys())

    for right in range(n):
        gem = gems[right]
        gem_count_dict[gem] = gem_count_dict.get(gem, 0) + 1
        count = len(gem_count_dict)

        # 잼 갯수가 같으면 모든 종류를 하나 이상 산 것이므로 왼쪽부터 줄여서 길이를 최소화해본다
        while count == gem_count:
            if min_count > min(min_count, right - left + 1):
                min_count = min(min_count, right - left + 1)
                answer = [left + 1, right + 1]

            left_value = gems[left]

            if gem_count_dict[left_value] == 1:
                del gem_count_dict[left_value]
            else:
                gem_count_dict[left_value] -= 1

            left += 1

            count = len(gem_count_dict)

    return answer

print(solutions(gems))
