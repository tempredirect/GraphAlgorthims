package graphs

/**
 */
class DirectedWeightedGraph {
  List<Vertex> vertices = []
  Map<Vertex,List<Edge>> edges = [:]

  def leftShift(Vertex v){
    vertices << v
    edges[v] = []
  }

  def addEdge(Vertex v1, Edge e) {
    edges.get(v1) << e
  }

}
