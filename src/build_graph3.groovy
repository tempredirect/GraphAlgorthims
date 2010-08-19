import graphs.*

def graph = new DirectedWeightedGraph();

5.times {
  graph << new Vertex(name:"${it}")
}

graph.addEdge(graph.vertices[0],new Edge(graph.vertices[1], 2))
graph.addEdge(graph.vertices[0],new Edge(graph.vertices[4], 4))
graph.addEdge(graph.vertices[1],new Edge(graph.vertices[2], 3))
graph.addEdge(graph.vertices[2],new Edge(graph.vertices[3], 5))
graph.addEdge(graph.vertices[2],new Edge(graph.vertices[4], 1))
graph.addEdge(graph.vertices[3],new Edge(graph.vertices[0], 8))
graph.addEdge(graph.vertices[4],new Edge(graph.vertices[3], 7))

[new FloydWarshallSearcher(graph:graph)]
        .each { searcher  ->
  searcher.search()

  println "**** ${searcher.class.name}"

  searcher.printDistanceMatrix()
}




