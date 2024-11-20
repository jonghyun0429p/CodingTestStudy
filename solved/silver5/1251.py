import sys

number = int(sys.stdin.readline().rstrip())
before = []
score = []
count = False
for i in range(number):
    before.append(list(map(int, sys.stdin.readline().rstrip().split(' '))))
    score.append(0)

for a in range(number):
    for c in range(1+a, number):
        for b in range(5):
            if(before[a][b] == before[c][b]):
                score[a] += 1
                score[c] += 1
                break
            
for i in range(number):
    if(max(score)==score[i]):
        print(i+1)
        break


