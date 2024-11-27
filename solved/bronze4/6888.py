X = int(input())
Y = int(input())

for i in range(X, Y+1):
    dif = i-X
    if dif % 60 == 0:
        print('All positions change in year {}'.format(i))
