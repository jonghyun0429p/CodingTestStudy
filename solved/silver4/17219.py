import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())

Dict = dict()

for i in range(N):
    key, value = map(str, input().rstrip().split())
    Dict[key] = value

for i in range(M):
    key = input().rstrip()

    print(Dict.get(key))
