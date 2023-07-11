package main

import (
	"fmt"

	"github.com/messagebird/interview/pkg"
)

/*
A customer wants to send a single message to a list of phone numbers. Our system uses various suppliers to deliver those messages, but each supplier
supports a limited set of prefixes. For this exercise, the prefix is a plus sign followed by 2 digits. For reliability purposes we have some overlap
in prefix coverage.

Implement a system that simulates sending messages to the given numbers. Each number through the most suitable supplier. It must optimise for the best
cost for the customer. It must return the total messages sent and the total cost for the batch.

We define the following suppliers:


TweetMobile supports all prefixes at € 0,04 per message.
Swanizon supports +32 and +33 at € 0,02 and € 0,03 per message.
BeakOn supports +31 and +32, both at € 0,01 per message.


Questions

More suppliers are possible
Existing suppliers can also support multiple prefixes
Existing suppliers can change their current rates
Only in Euros

If Supplier has all means all prefixes


The batch is as follows:

batch := []string {
	"+31000000001", // 1
	"+32000000001", // 1
	"+33000000001", // 3
	"+32000000002", // 1
	"+3@00000003",  // 0
	"+34000000001", // 4
	"+44000000001", // 4
	"+31000000002", // 1
	"+44000000002", // 4
	"+31000000003", // 1
}

$batch = [
        "+31000000001",
	"+32000000001",
	"+33000000001",
	"+32000000002",
	"+3@00000003",
	"+34000000001",
	"+44000000001",
	"+31000000002",
	"+44000000002",
	"+31000000003"
];

Expected outcome is 9 messages sent, total cost being 20 cents.


*/
func main() {

	batch := []string{
		"+31000000001",
		"+32000000001",
		"+33000000001",
		"+32000000002",
		"+3@00000003",
		"+34000000001",
		"+44000000001",
		"+31000000002",
		"+44000000002",
		"+31000000003",
	}

	totalMessages, totalBatchCost := pkg.ProcessBatch(batch)
	fmt.Printf("total Messages - %d", totalMessages)
	fmt.Printf("total Cost - %f", totalBatchCost)
}
