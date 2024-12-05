sum = int(input())

T = int(input())
moneySum = 0
for case in range(T):
    money, cnt = map(int, input().split())
    moneySum += money*cnt

if moneySum == sum:
    print("Yes")
else:
    print("No")
