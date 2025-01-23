N = int(input())
check = 0
number = 0

while check == 0 and number < N:
    number += 1
    num = number
    result = num

    while num / 10 > 0:
        result += num % 10
        num = num // 10

    if result == N:
        check = 1

if check == 1:
    print(number)
else:
    print(0)


