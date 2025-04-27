def sum_number_groups(s):
    total = 0
    num = ""

    for char in s:
        if char.isdigit():
            num += char
        else:
            if num != "":
                total += int(num)
                num = ""
    # 마지막에 숫자로 끝날 경우 처리
    if num != "":
        total += int(num)

    return total

size = int(input())
string = input()
print(sum_number_groups(string))
