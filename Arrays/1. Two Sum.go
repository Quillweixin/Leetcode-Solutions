package Arrays

func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	// turn the nums array into a map[value]index
	for i, v := range nums {
		m[v] = i
	}
	for i, v := range nums {
		index, ok := m[target-v]
		if ok && i != index {
			return []int{i, index}
		}
	}
	return nil
}
