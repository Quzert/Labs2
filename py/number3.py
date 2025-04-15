def count_non_decreasing_series(sequence):
    cnt = 0
    n = len(sequence)
    i = 0
    while i < n-1:
        if sequence[i] <= sequence[i + 1]:
            cnt += 1
            while i < n - 1 and sequence[i] <= sequence[i + 1]:
                i += 1
        else:
            i += 1

    return cnt

def str_to_list(s):
    return list(i for i in s)

sequence1 = [5, 1, 2, 3, 2, 5]
print(f"Количество неубывающих серий №1: {count_non_decreasing_series(sequence1)}")

sequence2 = str_to_list("484756344")
print(f"Количество неубывающих серий №2: {count_non_decreasing_series(sequence2)}")

sequence3 = str_to_list("12345678998765432123456789987654321")
print(f"Количество неубывающих серий №3: {count_non_decreasing_series(sequence3)}")
