A, B = map(int, input().split())
if A == B:
    print(0)
elif A < B:
    print(B-A-1)
    for i in range(A+1, B):
        if i == B-1:
            print(i)
        else:
            print(i, end=' ')
else:
    print(A-B-1)
    for i in range(B+1, A):
        if i == A-1:
            print(i)
        else:
            print(i, end=' ')