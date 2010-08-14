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
  }


  boolean equals(o) {
    if (this.is(o)) return true;

    if (getClass() != o.class) return false;

    Edge edge = (Edge) o;

    if (weight != edge.weight) return false;
    if (vertex != edge.vertex) return false;

    return true;
  }

  int hashCode() {
    int result;

    result = (vertex != null ? vertex.hashCode() : 0);
    result = 31 * result + weight;
    return result;
  }
}


