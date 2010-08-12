package graphs

/**
 */
class BreadthFirstSearch {
  def graph
  def color = [:]
  def discovered = [:]
  def finished = [:]
  def predecessor = [:]
  def counter = 0

  def BreadthFirstSearch(graph){
    this.graph = graph
  }

  def search(start){
    graph.vertices.each {
      color[it] = Marker.WHITE;
      discovered[it] = -1
      finished[it] = -1
    }

    counter = 0

    def queue = new ArrayDeque()
    queue << start

    while( !queue.isEmpty()){
      def u = queue.removeFirst()
      graph.edges[u].each { v ->
        if( color[v] == Marker.WHITE){
          discovered[v] = discovered[u] + 1
          predecessor[v] = u
          color[v] = Marker.GREY
          queue << v
        }
      }
      color[u] = Marker.BLACK
    }
    return predecessor
  }
}
