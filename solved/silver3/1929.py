#소수구하기
import sys
input = sys.stdin.readline

a, b = map(int, input().split(' '))

#에라토스테네스의 체(대량의 소수)

for i in range(a, b+1):
    if i == 1:
        continue

    for j in range(2, int(i**0.5) + 1): # 2 ~ 제곱근 사이 값 확인
        if i % j == 0: # 나누어 떨어진다면 그대로 종료 (else문 실행 X)
            break
    else: # for문이 잘 실행이 되었다면 print(i) 출력
        print(i)

# 소수를 저장, 소수만 비교
# memo = []

# for i in range(2, b+1):
#     check = True
#     for j in memo:
#         if i % j == 0:
#             check = False
#             break
#     if check:
#         memo.append(i)
#         print(i)



#주먹구구식 그냥 반복문 - 시간초과
# for i in range(a, b+1):
#     check = 0
#     for j in range(2, i):
#         if i % j == 0:
#             check = 1
#             break
#     if check == 0:
#         print(i)



