import sys
input = sys.stdin.readline

months = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

date, days = input().split()
days = int(days)

year, month, day = map(int, date.strip().split('-'))

def check_year(yy):
    return (yy % 400 == 0) or (yy % 4 == 0 and yy % 100 != 0)

# 날짜에 days를 더함
day += days - 1

while True:
    # 현재 달이 2월이고 윤년이면 29일, 아니면 months[month-1]
    if month == 2 and check_year(year):
        current_month_days = 29
    else:
        current_month_days = months[month-1]

    # day가 현재 달의 일수보다 작거나 같으면 정상
    if day <= current_month_days:
        break
    else:
        # 현재 달을 넘어감
        day -= current_month_days
        month += 1
        if month > 12:
            month = 1
            year += 1

# 날짜 포맷 출력
print(f"{year}-{month:02d}-{day:02d}")
