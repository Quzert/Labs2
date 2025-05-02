package main

import "fmt"

func cntNonDecSeries() int {
	lenSeries := 0
	cnt := 0

	var length int
	fmt.Scanln(&length)

	if length > 0 {
		var num1 int
		fmt.Scanln(&num1)

		var num2 int
		for i := 1; i < length; i++ {
			fmt.Scanln(&num2)

			if num2 >= num1 {
				lenSeries++
			} else if lenSeries != 0 {
				cnt++
				lenSeries = 0
			}
			num1 = num2
		}

		if lenSeries != 0 {
			cnt++
		}
	}
	return cnt
}

func main() {
	result := cntNonDecSeries()
	fmt.Printf("Количество неубывающих серий: %d\n", result)
}