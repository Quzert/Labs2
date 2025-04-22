package main

import (
	"fmt"
)

func countNonDecreasingSeries(sequence string) int {
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

func main() {
	sequence1 := "512325"
	fmt.Printf("Количество неубывающих серий №1: %d\n", countNonDecreasingSeries(sequence1))

	sequence2 := "484756344"
	fmt.Printf("Количество неубывающих серий №2: %d\n", countNonDecreasingSeries(sequence2))

	sequence3 := "12345678998765432123456789987654321"
	fmt.Printf("Количество неубывающих серий №3: %d\n", countNonDecreasingSeries(sequence3))
}