
// Pseudocode for Digital Wallet Transactions Report
transactions = List<Transaction>

grouped = transactions.stream()
    .collect(groupingBy(transaction.merchant, groupingBy(transaction.month)))

for merchant in grouped.keys() {
    for month in grouped[merchant].keys() {
        total = sum(grouped[merchant][month].amount)
        print("Merchant: " + merchant + " Month: " + month + " Total: " + total)
    }
}
