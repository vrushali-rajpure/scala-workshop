import scala.io.Source

val bookText = Source.fromFile("/Users/vrushali/Boot Camp/scala-basics-13/src/main/resources/aliceInWonderland.txt").mkString.toLowerCase
val stopWordText = Source.fromFile("/Users/vrushali/Boot Camp/scala-basics-13/src/main/resources/stopWords.txt").mkString.toLowerCase

val bookRegex = """[\s|:|.|,|\d|"]+"""
val stopWordRegex = "\\s+"

val allWords: Array[String] = bookText.split(bookRegex)
val stopWords: List[String] = stopWordText.split(stopWordRegex).toList;

val allWordsList = allWords.toList.filterNot(word => stopWords.contains(word))
  .map(word => (word, 1))
  .groupBy(x => x._1)
  .map(x => (x._1, x._2.map(x => x._2).sum))
  .toSeq.sortBy(-_._2).take(10)


val topTen = allWords.toList.filterNot(word => stopWords.contains(word))
  .groupBy(x => x)
  .mapValues(_.length)
  .toList
  .sortBy(-_._2)
  .take(10)
  .foreach(println)

// Scala : lazy and flow based collections