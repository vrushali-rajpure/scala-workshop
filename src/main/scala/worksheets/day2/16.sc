

sealed abstract class Day(name: String) {

}

object Day {
  case object Weekday extends Day("WD") {

  }
  case object Weekend extends Day("WW")
}

def m(day: Day) = {}

m(Day.Weekday)
m(Day.Weekend)

Day.Weekend
Day.Weekday
