package Laba2

import "fmt"

func startPosFinder(m, n int, s string) interface{} {
	x, y, rX, lX, uY, dY := 0, 0, 0, 0, 0, 0
	for _, i := range s {
		switch i {
		case 'D':
			y++
			if y > dY {
				dY = y
			}
		case 'U':
			y--
			if y < uY {
				uY = y
			}
		case 'L':
			x--
			if x < lX {
				lX = x
			}
		case 'R':
			x++
			if x > rX {
				rX = x
			}
		}
	}

	if rX-lX >= m || dY-uY >= n {
		return "No"
	}
	return [2]int{1 - lX, 1 - uY}
}

func main() {
	m, n := 3, 3
	s := "ULDDRRUU"
	fmt.Println(startPosFinder(m, n, s))
}
