def count_non_decreasing_series(sequence)
  cnt = 0
  n = sequence.length
  i = 0

  while i < n - 1
    if sequence[i] <= sequence[i + 1]
      cnt += 1
      i += 1 while i < n - 1 && sequence[i] <= sequence[i + 1]
    else
      i += 1
    end
  end

  cnt
end

sequence1 = "512325"
puts "Количество неубывающих серий №1: #{count_non_decreasing_series(sequence1)}"

sequence2 = "484756344"
puts "Количество неубывающих серий №2: #{count_non_decreasing_series(sequence2)}"

sequence3 = "12345678998765432123456789987654321"
puts "Количество неубывающих серий №3: #{count_non_decreasing_series(sequence3)}"