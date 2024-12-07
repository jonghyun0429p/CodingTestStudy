X, Y = map(int, input().split())

if Y < X:
    print(X+Y)
else:
    print(Y%X)