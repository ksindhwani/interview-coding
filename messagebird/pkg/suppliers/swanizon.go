package suppliers

//Swanizon supports +32 and +33 at € 0,02 and € 0,03 per message.
type Swanizon struct{}

func (s *Swanizon) CalculateCost(prefix string) float64 {
	costMap := s.GetCostMap()
	if _, ok := costMap[prefix]; ok {
		return costMap[prefix]
	}

	if _, ok := costMap[ALL]; ok {
		return costMap[ALL]
	}
	return 0.0
}

func (s *Swanizon) GetCostMap() map[string]float64 {
	return map[string]float64{
		"+32": 0.02,
		"+33": 0.03,
	}
}
