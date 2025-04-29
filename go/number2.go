package main

import (
	"fmt"
	"strings"
)

// Функция для проверки корректности имени пользователя
func isValidUsername(username string) bool {
	if len(username) < 6 || len(username) > 30 {
		return false
	}
	if strings.HasPrefix(username, ".") || strings.HasSuffix(username, ".") {
		return false
	}
	if strings.Contains(username, "..") {
		return false
	}
	return true
}

func emailCount(emailList []string) int {
	uniqueEmails := make(map[string]struct{})

	for _, email := range emailList {
		parts := strings.Split(email, "@")
		if len(parts) != 2 {
			fmt.Println("Некорректный email:", email)
			continue
		}

		local := parts[0]
		domain := parts[1]

		if !isValidUsername(local) {
			fmt.Println("Некорректное имя пользователя:", local)
			continue
		}

		local = strings.ReplaceAll(local, ".", "")

		if starIndex := strings.Index(local, "*"); starIndex != -1 {
			local = local[:starIndex]
		}

		uniqueEmails[local+"@"+domain] = struct{}{}
	}

	return len(uniqueEmails)
}

func main() {
	// Пример 1
	addressList1 := []string{
		"mar.pha+science@corp.nstu.ru",
		"marpha+scie.nce@corp.nstu.ru",
		"marph.a+s.c.i.e.n.c.e+@corp.nstu.ru",
	}
	fmt.Printf("Output (Пример 1): %d\n", emailCount(addressList1))

	// Пример 2
	addressList2 := []string{
		"mar.pha+science@co.rp.nstu.ru",
		"marpha+scie.nce@corp.nstu.ru",
		"marph.a+s.c.i.e.n.c.e+@corp.nstu.ru",
	}
	fmt.Printf("Output (Пример 2): %d\n", emailCount(addressList2))

}