import sys

N = int(sys.stdin.readline().rstrip())

lst = []
i = 0
while True:
    i += 1    
    #숫자를 문자열로 바꿔서 666이 들었는지 확인
    if '666' in str(i):
        lst.append(i)
        #만약 원하는 갯수만큼 했다면 출력.
        if len(lst) == N:
            print(lst[N-1])
            break