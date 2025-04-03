package Laba2

import (
	"fmt"
	"strings"
)

func emailCount(emailList []string) int {
	uniqueEmails := make(map[string]struct{})

	for _, email := range emailList {
		parts := strings.Split(email, "@")
		local := strings.ReplaceAll(parts[0], ".", "")
		if plusIndex := strings.Index(local, "+"); plusIndex != -1 {
			local = local[:plusIndex]
		}
		uniqueEmails[local+"@"+parts[1]] = struct{}{}
	}

	return len(uniqueEmails)
}

func main() {
	addressList1 := []string{"mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"}
	addressList2 := []string{"mar.pha+science@corp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru"}
	addressList3 := []string{"mar.pha+science@co.rp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru"}

	fmt.Println(emailCount(addressList1)) // 1
	fmt.Println(emailCount(addressList2)) // 1
	fmt.Println(emailCount(addressList3)) // 2
}
