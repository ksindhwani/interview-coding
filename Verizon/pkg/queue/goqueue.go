package queue

type GoQueue struct {
	Queue    []string
	Capacity int
	Size     int
}

func GetNewQueue(capacity int) GoQueue {
	return GoQueue{
		Capacity: capacity,
	}
}

func (gq GoQueue) Enqueue(element string) {
	if gq.Size < gq.Capacity {
		_ = append(gq.Queue, element)
		gq.Size++
		gq.Capacity++
	}
}

func (gq GoQueue) DeQueue() string {
	element := gq.Queue[0]
	gq.Queue = gq.Queue[1:]
	return element
}
