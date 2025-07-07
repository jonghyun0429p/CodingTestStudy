import sys
input = sys.stdin.readline

# 생각한 방안은 1. 리스트를 하나씩 다 접근할거임. 근데, visited를 사용해서 지나간 곳은 스킵, 0인 곳도 스킵

N = int(input())
map_home = []
visited = [[False] * N for i in range(N)]

for line in range(N):
    map_home.append(list(input().rstrip()))


def dfs(row, col, count):
    # 1) 갈 수 없거나 이미 방문한 곳이면 0 리턴
    if map_home[row][col] == '0' or visited[row][col]:
        return 0

    # 2) 방문 처리
    visited[row][col] = True

    # 3) 이 칸 한 채(=count) + 이웃 집들 재귀 누적
    for dx, dy in ((1,0), (0,1), (-1,0), (0,-1)):
        next_row = row + dx
        next_col = col + dy
        if 0 <= next_row < N and 0 <= next_col < N:
            if map_home[next_row][next_col] == '1' and not visited[next_row][next_col]:
                # 재귀 호출할 때는 항상 새로 셀 1을 넘겨줍니다
                count += dfs(next_row, next_col, 1)

    return count

home_count_list = []

for i in range(N):
    for j in range(N):
        home_count = dfs(i, j, 1)
        if home_count != 0:
            home_count_list.append(home_count)

home_count_list.sort()

print(len(home_count_list))

for i in home_count_list:
    print(i)
