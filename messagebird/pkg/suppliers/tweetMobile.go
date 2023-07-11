package suppliers

type TweetMobile struct{}

func (tm *TweetMobile) CalculateCost(prefix string) float64 {
	costMap := tm.GetCostMap()

	// consider write this in function
	if _, ok := costMap[prefix]; ok {
		return costMap[prefix]
	}

	if _, ok := costMap[ALL]; ok {
		return costMap[ALL]
	}
	return 0.0
}

// TweetMobile supports all prefixes at € 0,04 per message.
func (tm *TweetMobile) GetCostMap() map[string]float64 {
	return map[string]float64{
		"all": 0.04,
	}
}
