import sys
from collections import deque
input = sys.stdin.readline

N, K = map(int, input().split(' '))

visited = [0 for _ in range(100001)]

def bfs(startNode, endNode):
    q = deque()
    q.append(startNode)

    while q:
        nextNode = q.popleft()
        if nextNode == endNode:
            print(visited[nextNode])
            break
        for i in (nextNode-1, nextNode+1, nextNode*2):
            if 0 <= i <= 100000 and not visited[i]:
                visited[i] = visited[nextNode]+1
                q.append(i)

bfs(N, K)