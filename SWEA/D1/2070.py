T = int(input())

for test_case in range(1, T + 1):
    first, second = map(int, input().split(' '))

    if first > second:
        print('#%d >' % test_case)
    elif first < second:
        print('#%d <' % test_case)
    else:
        print('#%d =' % test_case)