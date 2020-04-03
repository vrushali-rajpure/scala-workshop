
sealed trait Day
object Day {
  case object Weekday extends Day
  case object Weekend extends Day
}

sealed trait Customer
object Customer {
  case object Reward extends Customer
  case object Regular extends Customer
}

case class Category(customer: Customer, day: Day)

case class BookingRequest(customer: Customer, days: List[Day]) {
  def categories: List[Category] = days.map(day => Category(customer, day))
}

case class Hotel(name: String, rating: Int, rateCard: Map[Category , Int]) {
  def getCost(bookingRequest: BookingRequest): Int =
    bookingRequest.categories.map(rateCard).sum
}

class HotelService(hotels: List[Hotel]) {
  def findBestHotel(bookingRequest: BookingRequest): String =
    hotels.minBy(h => (h.getCost(bookingRequest), -h.rating)).name
}
