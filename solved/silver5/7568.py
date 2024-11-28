N = int(input())

person = []
for i in range(N):
    weight, height = map(int, input().split())
    person.append([weight,height])

for size in person:
    rank = 1
    for comp in person:
        if size[0] < comp[0] and size[1] < comp[1]:
            rank += 1
    print(rank, end=' ')
