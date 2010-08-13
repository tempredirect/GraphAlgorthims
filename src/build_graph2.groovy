import graphs.*

def graph = new DirectedWeightedGraph();

5.times {
  graph << new Vertex(name:"node-${it}")
}

graph.addEdge(graph.vertices[0],new Edge(graph.vertices[1], 2))
graph.addEdge(graph.vertices[0],new Edge(graph.vertices[4], 4))
graph.addEdge(graph.vertices[1],new Edge(graph.vertices[2], 4))
graph.addEdge(graph.vertices[2],new Edge(graph.vertices[3], 5))
graph.addEdge(graph.vertices[2],new Edge(graph.vertices[1], 4))
graph.addEdge(graph.vertices[3],new Edge(graph.vertices[0], 8))
graph.addEdge(graph.vertices[4],new Edge(graph.vertices[3], 7))

[new DijkstraSearch(graph:graph)].each { searcher  ->
  def pred = searcher.search(graph.vertices[0])

  println "**** ${searcher.class.name}"
  pred.each{ k,v ->
    println "${k.name} -> ${v.name} distance:${searcher.distance[k]}"
  }
}




