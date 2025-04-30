import sys
input = sys.stdin.readline

T = int(input())

for i in range(T):
    sum = 0
    expell_sum = 0
    pre_que = 0
    check_expell = 0
    points = input().rstrip()
    for point in points:
        if point.isdigit():
            point = int(point)
        else:
            point = ord(point)-55

        sum += point
        cur_que = sum//10

        if cur_que == 4:
            check_expell = 1
        elif cur_que > 4:
            check_expell = 2
        elif cur_que > pre_que:
            expell_sum += cur_que
        pre_que = cur_que

        if check_expell == 1:
            print("%d(weapon)" %expell_sum)
            break
        elif check_expell == 2:
            print("%d(09)" %expell_sum)
            break

    if check_expell == 0:
        print(expell_sum)

#print(ord("K")-55)