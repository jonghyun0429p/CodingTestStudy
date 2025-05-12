import sys
input = sys.stdin.readline

def find_common_multiple(M, N):
    a, b = M, N
    while b:
        a, b = b, a % b
    return M * N // a  # 최소공배수

def find_answer(M, N, x, y, common_multiple):
    current_value = x
    while current_value <= common_multiple:
        if (current_value - 1) % N + 1 == y:
            print(current_value)
            return
        current_value += M
    print(-1)

test_case = int(input())
for _ in range(test_case):
    M, N, x, y = map(int, input().split())
    find_answer(M, N, x, y, find_common_multiple(M, N))