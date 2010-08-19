package graphs

/**
 */
class FloydWarshallSearcher {
  def distance = [:]
  def predecessor = [:]
  def graph

  def search(){
    graph.vertices.each {u ->
      distance[u] = [:]
      predecessor[u] = [:]
      graph.vertices.each{v ->
        distance[u][v] = Integer.MAX_VALUE as Long
      }
      distance[u][u] = 0L
      graph.edges[u].each{e ->
        distance[u][e.vertex] = e.weight as Long
        predecessor[u][e.vertex] = u
      }
    }
//    println "Starting state"
//    printDistanceMatrix()

    // here comes the cubic bit
    graph.vertices.each {t ->
      graph.vertices.each {u ->
        graph.vertices.each {v ->
          Long newLength = distance[u][t] + distance[t][v]
          if( newLength < distance[u][v]){
            distance[u][v] = newLength
            predecessor[u][v] = predecessor[t][v]
          }
        }
      }
//      println "after ${t.name}"
//      printDistanceMatrix()
    }
    return predecessor
  }

  def printDistanceMatrix() {
    print "".padLeft(5)
    graph.vertices.each {x ->
      print x.name.padLeft(5)
    }
    println ""

    graph.vertices.each {y ->
      print y.name.padLeft(5)
      graph.vertices.each {x ->
        def d = distance[y][x]
        if( d == Integer.MAX_VALUE){
          d = "∞"
        }
        print d.toString().padLeft(5)
      }
      println ""
    }
  }
}
