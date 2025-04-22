a, b, c = map(int, input().split('/'))
result = a + c

if result < b or b == 0:
    print("hasu")
else:
    print("gosu")