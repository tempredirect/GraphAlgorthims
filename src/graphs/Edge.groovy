package graphs

/**
 */
class Edge implements Comparable<Edge> {
  Vertex vertex
  int weight

  def Edge(vertex, weight) {
    this.vertex = vertex;
    this.weight = weight;
  }


  int compareTo(Edge o2) {
    def r = this.weight.compareTo(o2.weight);
    return r == 0 ? this.vertex.compareTo(o2.vertex) : r
  }


  public String toString ( ) {
  return "Edge{" +
  "vertex=" + vertex.name +
  ", weight=" + weight +
  '}' ;
  }}
