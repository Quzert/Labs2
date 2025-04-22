package main

import (
	"fmt"
	"regexp"
	"strings"
)

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

	if matched, _ := regexp.MatchString(`[&=+<>,_'\-]`, username); matched {
		return false
	}

	if matched, _ := regexp.MatchString(`^[a-zA-Z0-9.]*$`, username); !matched {
		return false
	}

	return true
}

func emailCount(emailList []string) int {
	uniqueEmails := make(map[string]struct{})

	for _, email := range emailList {
		parts := strings.Split(email, "@")
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
	addressList1 := []string{"mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"}
	fmt.Println(emailCount(addressList1))
}