m = 3
n = 3
s = "ULDDRRUU"

def start_pos_finder(m, n, s)
  x = 0
  y = 0
  r_x = 0
  l_x = 0
  u_y = 0
  d_y = 0

  s.each_char do |i|
    case i
    when "D"
      y += 1
      d_y = y if y > d_y
    when "U"
      y -= 1
      u_y = y if y < u_y
    when "L"
      x -= 1
      l_x = x if x < l_x
    when "R"
      x += 1
      r_x = x if x > r_x
    end
  end

  if r_x - l_x >= m || d_y - u_y >= n
    return "No"
  end

  [1 - l_x, 1 - u_y]
end

puts start_pos_finder(m, n, s)