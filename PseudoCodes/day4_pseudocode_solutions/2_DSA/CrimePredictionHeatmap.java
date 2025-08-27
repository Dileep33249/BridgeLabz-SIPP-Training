
// Pseudocode for Crime Prediction Heatmap
graph = Map<Zone, List<Zone>>
riskData = Map<Zone, int> // crime counts

DFS(zone, visited) {
    mark zone visited
    totalRisk = riskData[zone]
    for neighbor in graph[zone] {
        if not visited[neighbor] {
            totalRisk += DFS(neighbor, visited)
        }
    }
    return totalRisk
}

for each zone in graph {
    visited = {}
    riskScore = DFS(zone, visited)
    print(zone + " risk: " + riskScore)
}
