import sys
input = sys.stdin.readline

def solve():
    N = int(input())
    M = int(input())
    S = input().rstrip()

    ans = 0     # 최종 패턴 개수
    cnt = 0     # 지금까지 연속으로 발견한 "IO" 쌍의 개수
    i = 0       # 현재 스캔 위치

    while i < M - 1:
        # "IO" 쌍 발견
        if S[i] == 'I' and S[i+1] == 'O':
            cnt += 1
            i += 2   # "IO"를 소비하고 넘어감

            # 연속된 "IO" 쌍이 N개 이상이고,
            # 다음 문자가 'I' 이면 PN 한 번 등장
            if cnt >= N and i < M and S[i] == 'I':
                ans += 1
        else:
            # 패턴이 깨지면 다시 0으로 리셋하고 한 칸만 이동
            cnt = 0
            i += 1

    print(ans)

if __name__ == "__main__":
    solve()