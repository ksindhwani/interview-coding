package pkg

import "github.com/messagebird/interview/pkg/suppliers"

/*
input - batch - array of strings
return the total messages sent and the total cost for the batch
*/

var Suppliers = []suppliers.Supplier{
	&suppliers.TweetMobile{},
	&suppliers.Swanizon{},
}

func ProcessBatch(batch []string) (int, float64) {
	totalMessages := len(batch)
	totalCost := 0.0

	for _, phoneNumber := range batch {
		prefix := getPhoneNumberPrefix(phoneNumber)
		messageCost := findMinimumMessageCost(prefix)
		totalCost += messageCost
	}

	return totalMessages, totalCost
}

func getPhoneNumberPrefix(phoneNumber string) {
	panic("unimplemented")
}

func findMinimumMessageCost(prefix string) float64 {
	minCost := Suppliers[0].CalculateCost(prefix) // Check if supplier array is empty or not 
	for _, supplier := range Suppliers {
		cost := supplier.CalculateCost(prefix)
		if cost < minCost {
			minCost = cost
		}
	}
	return minCost
}
