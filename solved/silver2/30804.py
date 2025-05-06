N = int(input())
S = list(map(int, input().split()))

counter = {}
left = 0
max_len = 0

for right in range(N):
    fruit = S[right]
    counter[fruit] = counter.get(fruit, 0) + 1

    while len(counter) > 2:
        left_fruit = S[left]
        counter[left_fruit] -= 1
        if counter[left_fruit] == 0:
            del counter[left_fruit]
        left += 1

    max_len = max(max_len, right - left + 1)

print(max_len)
