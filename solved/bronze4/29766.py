string = input()

flag = 0
cnt = 0
for i in string:
    if i == "D":
        flag = 1
    elif i == "K" and flag == 1:
        flag = 2
    elif i == "S" and flag == 2:
        flag = 3
    elif i == "H" and flag == 3:
        cnt += 1
        flag = 0
    else:
        flag = 0

print(cnt)