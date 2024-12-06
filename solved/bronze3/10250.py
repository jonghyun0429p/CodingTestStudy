T = int(input())

for test_case in range(1, T+1):
    H, W, N = map(int, input().split())
    #나머지가 층수
    floor = N%H
    #나누었을때 +1 한 값이 호수.
    room = N//H+1
    #나머지가 0이라면, N==H라는 것이므로,
    if floor == 0:
        floor = H
        room -= 1
    print(floor*100 + room)

