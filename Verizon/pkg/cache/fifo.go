package cache

type CacheStruct struct {
	value     string
	CallCount int
}

type MyCache struct {
	Capacity int
	Size     int
	Cache    map[string]CacheStruct
	CountMap map[string]int
}

func GetNewCache(capacity int) MyCache {
	return MyCache{
		Capacity: capacity,
		Cache:    make(map[string]CacheStruct, 0),
	}
}

func (F MyCache) Put(key string, value string) {

}

func (F MyCache) Get(key string) string {
	F.Cache[key] 
	return F.Cache[key]
}
