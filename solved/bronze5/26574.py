T = int(input())

lst = []

for i in range(T):
    N = input()

    lst.append(N + ' ' + N)

for i in lst:
    print(i)