package Laba2

import (
	"fmt"
	"strconv"
)

func countNonDecreasingSeries(sequence []int) int {
	cnt, n, i := 0, len(sequence), 0
	for i < n-1 {
		if sequence[i] <= sequence[i+1] {
			cnt++
			for i < n-1 && sequence[i] <= sequence[i+1] {
				i++
			}
		} else {
			i++
		}
	}
	return cnt
}

func strToList(s string) []int {
	var list []int
	for _, char := range s {
		num, _ := strconv.Atoi(string(char))
		list = append(list, num)
	}
	return list
}

func main() {
	sequence1 := []int{5, 1, 2, 3, 2, 5}
	fmt.Printf("Количество неубывающих серий №1: %d\n", countNonDecreasingSeries(sequence1))

	sequence2 := strToList("484756344")
	fmt.Printf("Количество неубывающих серий №2: %d\n", countNonDecreasingSeries(sequence2))

	sequence3 := strToList("12345678998765432123456789987654321")
	fmt.Printf("Количество неубывающих серий №3: %d\n", countNonDecreasingSeries(sequence3))
}
