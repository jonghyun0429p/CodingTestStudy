import sys

X = int(sys.stdin.readline().rstrip())

memo = {1:0}

def makeone(X):
    if X in memo.keys():
        return memo[X]

    if (X % 3 == 0) and (X % 2 == 0):
        memo[X] = min(makeone(X // 3) + 1, makeone(X // 2) + 1)
    elif X % 3 == 0:
        memo[X] = min(makeone(X // 3) + 1, makeone(X - 1) + 1)
    elif X % 2 == 0:
        memo[X] = min(makeone(X // 2) + 1, makeone(X - 1) + 1)
    else:
        memo[X] = makeone(X - 1) + 1

    return memo[X]

makeone(X)

print(memo[X])