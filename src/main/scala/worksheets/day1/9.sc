
import data.AliceData._

val words = bookText.split(bookRegex)
val stopWords = stopWordText.split(stopWordRegex)

words
  .filterNot(w => stopWords.contains(w))
  .groupBy(x => x)
  .mapValues(_.length)
  .toList
  .sortBy(-_._2)
  .take(10)
  .foreach(println)
