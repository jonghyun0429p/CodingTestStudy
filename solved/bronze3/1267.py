count = int(input())
Y, M = 0, 0
calls = input().split(' ')

for i in range(2):
    for j in range(count):
        if(i == 0):
            Y += (int(calls[j])//30+1)*10
        if(i == 1):
            M += (int(calls[j])//60+1)*15

if(Y < M):
    print('Y ' + str(Y))
elif(Y == M):
    print('Y ' + 'M ' + str(Y))
else:
    print('M ' + str(M))