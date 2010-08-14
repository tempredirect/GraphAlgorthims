import graphs.*

def graph = new DirectedWeightedGraph();

5.times {
  graph << new Vertex(name:"node-${it}")
}

graph.addEdge(graph.vertices[0],new Edge(graph.vertices[1], 2))
graph.addEdge(graph.vertices[0],new Edge(graph.vertices[4], 4))
graph.addEdge(graph.vertices[1],new Edge(graph.vertices[2], 3))
graph.addEdge(graph.vertices[2],new Edge(graph.vertices[3], 5))
graph.addEdge(graph.vertices[2],new Edge(graph.vertices[4], 1))
graph.addEdge(graph.vertices[3],new Edge(graph.vertices[0], 8))
graph.addEdge(graph.vertices[4],new Edge(graph.vertices[3], 7))

[new DijkstraSearch(graph:graph)].each { searcher  ->
  def pred = searcher.search(graph.vertices[0])

  println "**** ${searcher.class.name}"
  searcher.distance.each{ k,v ->

    println "${graph.vertices[0]} -> ${k.name},  distance:${v}"
    def current = k
    while( current != graph.vertices[0] && current != null ){
      println "   ${current.name} -> ${pred[current].name},  distance:${graph.edges[pred[current]].find{it.vertex == current}.weight}"
      current = pred[current]
    }
  }
}




