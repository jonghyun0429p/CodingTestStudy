import sys
input = sys.stdin.readline

N, L, K = map(int, input().split())
problems = []
solved_problems = 0
score = 0

for problem in range(N):
    easy, hard = map(int, input().split())
    problems.append([easy, hard])

for i, j in problems[:]:

    if solved_problems < K and j <= L:
        score += 140
        solved_problems += 1
        problems.remove([i, j])

for i, j in problems:
    if solved_problems < K and i <= L:
        score += 100
        solved_problems += 1

print(score)