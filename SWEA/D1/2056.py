T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    date = input()
    year = date[0:4]
    month = int(date[4:6])
    day = int(date[6:8])
    day31 = set([1, 3, 5, 7, 8, 10, 12])
    day30 = set([4, 6, 9, 11])
    error = False

    if 1 <= month <= 12:
        if month == 2:
            if 28 < day or day < 1:
                error = True
        if month in day31:
            if 31 < day or day < 1:
                error = True
        if month in day30:
            if 30 < day or day < 1:
                error = True
    else:
        error = True

    if error == False:
        print("#%d " % test_case + year+'/'+date[4:6]+'/'+date[6:8])
    else:
        print("#%d " % test_case + "-1")


