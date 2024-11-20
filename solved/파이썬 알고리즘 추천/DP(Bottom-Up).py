def fibonacci_td(n):
    if n < 2:
        return n

    if _memo[n] is None: # 존재하지 않으면 memo!
        _memo[n] = fibonacci_td(n - 1) + fibonacci_td(n - 2)

    return _memo[n]


_memo = [None] * 50
print(fibonacci_td(36))