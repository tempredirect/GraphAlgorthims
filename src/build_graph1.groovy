import graphs.*
/**
 */

def graph = new AdjacencyGraph()

8.times {
  graph << new Vertex(name:"node-${it}")
}

println graph.vertices

/*
    1-----------2-------6
    |           |
    |     5     |       8
    |     |     |       |
    0-----4-----3       7
*/
// p144 Algorithms in a Nutshell
graph.addEdge(graph.vertices[0],graph.vertices[1])
graph.addEdge(graph.vertices[0],graph.vertices[4])
graph.addEdge(graph.vertices[1],graph.vertices[2])
graph.addEdge(graph.vertices[2],graph.vertices[3])
graph.addEdge(graph.vertices[2],graph.vertices[6])
graph.addEdge(graph.vertices[3],graph.vertices[4])
graph.addEdge(graph.vertices[3],graph.vertices[2])
graph.addEdge(graph.vertices[4],graph.vertices[0])
graph.addEdge(graph.vertices[4],graph.vertices[5])
graph.addEdge(graph.vertices[4],graph.vertices[3])
graph.addEdge(graph.vertices[5],graph.vertices[4])
graph.addEdge(graph.vertices[6],graph.vertices[2])
graph.addEdge(graph.vertices[7],graph.vertices[8])
graph.addEdge(graph.vertices[8],graph.vertices[7])

[new DepthFirstSearch(graph),new BreadthFirstSearch(graph)].each { searcher  ->
  def pred = searcher.search(graph.vertices[0])

  println "**** ${searcher.class.name}"
  pred.each{ k,v ->
    println "${k.name} -> ${v.name}"
  }

  println "Route from ${graph.vertices[5]} -> ${graph.vertices}"
    def current = graph.vertices[5]
    while( current != graph.vertices[0] && current != null ){
      println "${current} -> ${pred[current]}"
      current = pred[current]
  }
}