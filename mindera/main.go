package main

import "fmt"

type Set interface {
	Add(entry int64)
	Entries() []int64
}

type MySet struct {
	set map[int64]bool
}

func (ms *MySet) Add(entry int64) {
	if ms.set == nil {
		ms.set = make(map[int64]bool)
	}

	ms.set[entry] = true
}

func (ms *MySet) Entries() []int64 {
	var keys []int64

	for key, _ := range ms.set {
		keys = append(keys, key)
	}
	return keys
}

func main() {
	set := &MySet{}
	set.Add(1)
	set.Add(1)
	set.Add(2)
	fmt.Print(set.Entries()) // prints [1, 2]
}
