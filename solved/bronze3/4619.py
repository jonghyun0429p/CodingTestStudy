while True:
    B, N = map(int, input().split(' '))

    if B == 0 and N == 0:
        break

    A_over = False
    A = 1
    best_A = 10000000000

    while not A_over:

        A_value = A ** N
        A_best_value = best_A ** N

        if abs(B - A_best_value) > abs(B - A_value):
            best_A = A

        A_over = A ** N > B

        A += 1

    print(best_A)