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

# 방문 정보를 기록하기 위한 리스트
visited = [False] * 8

def dfs(v):
    # 방문 표시
    visited[v] = True
    print(v, end=' ')
    # 그래프를 순환하면서 인접 노드들을 방문
    for i in graph[v]:
        # 만약 방문하지 않은 노드가 있다면
        if not visited[i]:
            # 탐색 시작
            dfs(i)

# 탐색 시작 노드 1을 넣어주며 dfs() 실행
dfs(1)