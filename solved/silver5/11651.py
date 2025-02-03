N = int(input())
data = list()

for i in range(N):
    data.append(list(map(int, input().split(' '))))

data.sort(key=lambda x : (x[1], x[0]))

for i in data:
    print(*i)