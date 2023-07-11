package pkg

import "math"

func ParseString(stringNumber string) int64 {
	var num int64
	num = 0
	j := 0.0
	for i := len(stringNumber) - 1; i >= 0; i-- {
		number := stringNumber[i] - '0'
		num += int64(number) * int64(math.Pow(10, j))
		j++
	}
	return num
}
