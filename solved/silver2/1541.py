n = input()
nlist = n.split('-')

for i in range(len(nlist)):
    sum = 0
    iList = nlist[i].split('+')
    for j in iList:
        sum += int(j.lstrip('0'))

    if i == 0:
        nlist[i] = sum
    else:
        nlist[0] -= sum



print(nlist[0])
