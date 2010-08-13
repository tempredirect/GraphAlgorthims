package graphs

/**
 */
class DijkstraSearch {
  def distance = [:]
  def predecessor = [:]
  def graph

  def search(start){
    graph.vertices.each { v ->
      distance[v] = Integer.MAX_VALUE
    }
    distance[start] = 0

    def pq = new PriorityQueue()
    graph.vertices.each { v ->
      pq << new Edge(v, distance[v])
    }

    while( !pq.empty){
      def e = pq.poll()
      def u = e.vertex
      graph.edges[u].each {
        def weight = it.weight
        def v = it.vertex
        def newLength = distance[u] + weight
        def oldLength = distance[v]
        if( newLength > oldLength
          || oldLength == Integer.MAX_VALUE){
          pq.remove(new Edge(v, oldLength))
          pq << new Edge(v, newLength)
          distance[v] = newLength
          predecessor[v] = u
        }
      }
    }
    return predecessor
  }
}
