import sys
input = sys.stdin.readline

N = int(input())

S = input().rstrip()

if N <= 25:
    print(S)
else:
    middle = S[11:-11]
    # 중간에 마침표가 없으면 한 문장
    if '.' not in middle or middle.count(".") == 1 and middle[-1] == ".":
        print(S[:11] + "..." + S[-11:])
    else:
        print(S[:9] + "......" + S[-10:])
