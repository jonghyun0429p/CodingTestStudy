#스택 수열
#1부터 n까지 들어가면서, 입력해준 대로 수열을 완성할 수 있는지 구해야함.
import sys
input = sys.stdin.readline
from collections import deque

N = int(input())

num_list = [1]
input_list = deque()
stack_list = ['+']
want_num = 0
current_num = 1
check = True

for i in range(1, N+1):
    input_list.append(int(input()))

for i in range(1, N+1):
    if not check:
        break
    want_num = input_list.popleft()
    if want_num > current_num:
        for j in range(current_num+1, want_num+1):
            stack_list.append('+')
            num_list.append(j)
            current_num += 1
        stack_list.append('-')
        num_list.pop()
    else:
        while len(num_list):
            left_num = num_list.pop()
            if want_num < left_num:
                check = False
                break
            elif want_num == left_num:
                stack_list.append('-')
                break
            else:
                stack_list.append('-')

if not check:
    print('NO')
else:
    for i in stack_list:
        print(i)