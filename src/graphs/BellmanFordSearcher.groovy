package graphs

/**
 */
class BellmanFordSearcher {
  def distance = [:]
  def predecessor = [:]
  def graph

  def search(start){
    graph.vertices.each { v ->
      distance[v] = Integer.MAX_VALUE
    }
    distance[start] = 0


    graph.vertices.eachWithIndex { u,i ->
      graph.edges[u].each {
        def v = it.vertex
        def weight = it.weight
        def newLength = distance[u] + weight
        def oldLength = distance[v]
        if( newLength < oldLength){
          distance[v] = newLength
          predecessor[v] = u
        }
      }
    }
    return predecessor;
  }
}
