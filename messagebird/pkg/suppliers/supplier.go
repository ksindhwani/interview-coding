package suppliers

const ALL = "all"

type Supplier interface {
	CalculateCost(prefix string) float64
	GetCostMap() map[string]float64
}
