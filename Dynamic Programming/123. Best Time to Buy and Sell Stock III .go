func maxProfit(prices []int) int {
    if len(prices)<=1 {return 0}
    
    t1Cost, t1profit := prices[0], 0 
    t2Cost, t2profit := prices[0],0
    for _, price := range prices{
        t1Cost = min(t1Cost,price)
        t1profit = max(t1profit,price-t1Cost)
        // profit in transaction 1 will be counted in the nexxt transaction
        t2Cost = min(t2Cost,price-t1profit)
        t2profit = max(t2profit,price-t2Cost)
    }
    return t2profit
}

func max(n int, m int) int{
    if n>m {return n}
    return m
}

func min(n int, m int) int{
    if n>m {return m}
    return n
}