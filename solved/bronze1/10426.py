import sys
input = sys.stdin.readline

months = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 29]

date, days = input().split(' ')

days = int(days) - 1

year, month, day = map(int, date.split('-'))

goal_day = day + days
current_month = 0
def check_year(yy):
    if yy % 400 == 0:
        return True
    elif yy % 4 == 0 and yy % 100 != 0:
        return True
    else:
        return False

while goal_day > 0:
    # 현재 달 일수 계산
    if check_year(year) and month == 2:
        current_month = 29
    else:
        current_month = months[month-1]

    if goal_day > current_month:
        goal_day -= current_month
        if month == 12:
            month = 1
            year += 1
        else:
            month += 1
    elif goal_day == current_month:
        goal_day = 0
        day = 1
        if month == 12:
            month = 1
            year += 1
        else:
            month += 1
    else:
        day = goal_day
        goal_day = 0

print(f"{year}-{month:02d}-{day:02d}")

# import sys
# input = sys.stdin.readline
#
# months = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
#
# date, days = input().split()
# days = int(days)
#
# year, month, day = map(int, date.split('-'))
#
# def is_leap_year(yy):
#     return (yy % 400 == 0) or (yy % 4 == 0 and yy % 100 != 0)
#
# # 현재 날짜에 days만큼 더하기
# day += days
#
# while True:
#     # 현재 월의 최대 일수 계산
#     if month == 2 and is_leap_year(year):
#         max_day = 29
#     else:
#         max_day = months[month - 1]
#
#     if day <= max_day:
#         break
#     else:
#         day -= max_day
#         month += 1
#         if month > 12:
#             month = 1
#             year += 1
#
# # 출력 (포맷팅 개선)
# print(f"{year}-{month:02d}-{day:02d}")










