import graphs.*
/**
 */

def graph = new AdjacencyGraph()

(0..8).each {
  graph << new Vertex(name:"node-${it}")
}

println graph.vertices

// p144 Algorthims in a Nutshell
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

def pred = new DepthFirstSearch(graph).search(graph.vertices[0])

pred.each{ k,v ->
  println "${k.name} -> ${v.name}"
}

println "Route from ${graph.vertices[5]} -> ${graph.vertices}"
def current = graph.vertices[5]
while( current != graph.vertices[0] && current != null ){
  println "${current} -> ${pred[current]}"
  current = pred[current]
}