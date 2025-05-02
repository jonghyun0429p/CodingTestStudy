import sys
input = sys.stdin.readline

N = int(input())

first_hand_year = 2024
first_hand_month = 8

month = first_hand_month + ((N-1)*7)

while month > 12:
    first_hand_year += 1
    month -= 12

print(first_hand_year, month)