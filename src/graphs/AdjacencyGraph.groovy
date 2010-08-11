package graphs

/**
 * Directed non-weighted graph
 */
class AdjacencyGraph {
  List<Vertex> vertices = []
  Map<Vertex,List<Vertex>> edges = [:]

  def leftShift(Vertex v){
    vertices << v
    edges[v] = []
  }

  def addEdge(Vertex v1, Vertex v2) {
    edges.get(v1) << v2
  }
}
