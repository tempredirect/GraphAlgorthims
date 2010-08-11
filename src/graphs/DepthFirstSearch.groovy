package graphs

/**
 */
class DepthFirstSearch {
  def color = [:]
  def depth = [:]
  def f = [:]
  def counter = 0
  def pred = [:]

  def search(graph,s){

    graph.vertices.each {
      color[it] = Marker.WHITE;
      depth[it] = -1
      f[it] = -1
    }

    counter = 0

    visit(graph,s)
    return pred
  }

  def visit(graph, u) {
    color[u] = Marker.GREY
    depth[u] = ++counter
    graph.edges[u].each { v ->
      if( color[v] == Marker.WHITE){
        pred[v] = u
        visit(graph, v)
      }
    }
    color[u] = Marker.BLACK
    f[u] = ++counter
  }
}
