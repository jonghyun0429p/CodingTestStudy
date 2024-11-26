import sys
input = sys.stdin.readline

T = int(input().rstrip())

for test_case in range(1, 1+T):
    result = input().rstrip()
    sum = 0
    cnt = 0
    for i in range(len(result)):
        if result[i] == 'O':
            if cnt != 0:
                cnt += 1
                sum += cnt
            else:
                cnt += 1
                sum += cnt
        else:
            cnt = 0
        print(cnt)


    print(sum)