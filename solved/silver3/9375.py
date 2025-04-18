T = int(input())

for test_case in range(T):
    dic = dict()
    cnt = 1
    #옷의 개수를 입력받은 후, 딕셔너리로 저장한다.
    for i in range(int(input())):
        name, cat = map(str, input().split())
        #이미 있는 값이라면, +1로 저장
        if dic.get(cat):
            dic.update({cat:dic.get(cat)+1})
        #없는 값이라면, 새롭게 저장
        else:
            dic[cat] = 1
    #안 입는 경우의 수를 더해서, 모두 곱해준다.
    for i in dic.values():
        cnt *= i+1
    #아예 안입는 경우를 제외하고 출력한다.
    print(cnt-1)