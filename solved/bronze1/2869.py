A, B, V = map(int, input().split(" "))

if A == V:
    print(1)
elif (V-A) % (A-B) == 0:
    print((V-A) // (A-B) + 1)
else:
    print((V-A) // (A-B) + 2)