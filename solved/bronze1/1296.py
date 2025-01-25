name = input()
rep = int(input())
percent = 0
result = ''
nameLcnt = name.count("L")
nameOcnt = name.count("O")
nameVcnt = name.count("V")
nameEcnt = name.count("E")

for i in range(rep):
    team = input()
    if result == '':
        result = team

    Lcnt = team.count("L") + nameLcnt
    Ocnt = team.count("O") + nameOcnt
    Vcnt = team.count("V") + nameVcnt
    Ecnt = team.count("E") + nameEcnt

    per = ((Lcnt + Ocnt) * (Ocnt + Vcnt) * (Vcnt + Ecnt) * (Lcnt + Vcnt) * (Lcnt + Ecnt) * (Ocnt + Ecnt)) % 100

    if per > percent:
        percent = per
        result = team
    elif per == percent:
        tempList = list([result, team])
        tempList.sort()
        result = tempList[0]

print(result)
