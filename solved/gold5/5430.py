from collections import deque

T = int(input())

for test_case in range(T):
    p = input()
    n = int(input())
    inp = input()
    flag = True

    # 입력이 0개인 경우 예외처리.
    if n == 0:
        q = deque()
    else:
        q = deque(map(int, inp.rstrip(']').lstrip('[').split(',')))
    
    #함수에 따라 다른 처리
    for i in range(len(p)):
        #flag를 이용해서, reverse를 제거. 
        if p[i] == 'D':
            if q:
                if flag:
                    q.popleft()
                else:
                    q.pop()
            else:
                print('error')
                break
        else:
            flag =  not flag
        
        #마지막까지 수행하면 프린트.
        if i == len(p)-1:
            #flag에 따라 출력방향 결정
            if flag:
                print('[', end='')
                for j in range(len(q)):
                    if j == len(q)-1:
                        print(q[j], end='')
                    else:
                        print(q[j], end=',')
                print(']')
            else:
                print('[', end='')
                for j in range(1, len(q)+1):
                    if j == len(q):
                        print(q[-j], end='')
                    else:
                        print(q[-j], end=',')
                print(']')