def cnt_non_dec_series():
    len_series = 0
    cnt = 0

    length = int(input())

    if length > 0:
        num1 = int(input())
        num2 = 0

        for _ in range(1, length):
            num2 = int(input())
            if num2 >= num1:
                len_series += 1
            elif len_series != 0:
                cnt += 1
                len_series = 0
            num1 = num2

        if len_series != 0:
            cnt += 1
    return cnt


result = cnt_non_dec_series()
print(f"Количество неубывающих серий: {result}")