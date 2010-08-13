package graphs

/**
 */
@Immutable
class Vertex implements Comparable<Vertex>{
  String name

  int compareTo(Vertex other) {
    return this.name.compareTo(other.name)
  }
}
