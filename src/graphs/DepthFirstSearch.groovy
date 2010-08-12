package graphs

/**
 */
class DepthFirstSearch {
  def graph
  def color = [:]
  def discovered = [:]
  def finished = [:]
  def predecessor = [:]
  def counter = 0

  def DepthFirstSearch(graph){
    this.graph = graph;
  }

  def search(s){

    graph.vertices.each {
      color[it] = Marker.WHITE;
      discovered[it] = -1
      finished[it] = -1
    }

    counter = 0

    visit(s)

    for( v in graph.vertices ){
      if( color[v] == Marker.WHITE)
        visit(v)
    }
    return predecessor
  }

  def visit(u) {
    color[u] = Marker.GREY
    discovered[u] = ++counter
    graph.edges[u].each { v ->
      if( color[v] == Marker.WHITE){
        predecessor[v] = u
        visit(v)
      }
    }
    color[u] = Marker.BLACK
    finished[u] = ++counter
  }
}
