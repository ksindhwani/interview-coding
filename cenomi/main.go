package main

import "github.com/cenomi/interview/pkg"

/*

We receive a string e.g. "123" or "003" we want to write a function to parse it and return an integer
*/

func main() {

	stringNum := "123"
	num := pkg.ParseString(stringNum)
	print(num)

}
