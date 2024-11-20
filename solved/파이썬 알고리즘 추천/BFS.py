from collections import deque

graph = [
    [],      # 0
    [2, 3],  # 1
    [4, 5],  # 2
    [6],     # 3
    [2, 5],  # 4
    [2, 4],  # 5
    [3, 7],  # 6
    [6]      # 7
]

visited = [False] * 8

def bfs(v):
    # 큐 생성 및 큐에 시작 노드 삽입
    q = deque()
    q.append(v)
    # 아직 방문해야 하는 노드가 있다면
    while q:
        # 큐에서 노드를 꺼내서 x에 저장
        x = q.popleft()
        print(x, end=' ')
        # 그래프를 탐색하다가 방문하지 않은 노드가 있다면
        for i in graph[x]:
            if not visited[i]:
                # 큐에 방문하라고 삽입하고 방문 처리
                q.append(i)
                visited[i] = True

bfs(1)