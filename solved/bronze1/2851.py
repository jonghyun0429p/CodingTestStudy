import sys
input = sys.stdin.readline

mushrooms = []
score = 0
for i in range(10):
    mushrooms.append(int(input()))

for mushroom in mushrooms:
    if mushroom + score < 100:
        score += mushroom
    else:
        if 100 - score >= score + mushroom - 100:
            score += mushroom
            break
        else:
            break

print(score)