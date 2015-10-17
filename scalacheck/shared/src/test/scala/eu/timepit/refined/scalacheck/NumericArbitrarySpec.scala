package eu.timepit.refined
package scalacheck

import eu.timepit.refined.api.Refined
import eu.timepit.refined.auto._
import eu.timepit.refined.numeric.{ Greater, Interval, Less }
import eu.timepit.refined.scalacheck.numericArbitrary._
import eu.timepit.refined.scalacheck.TestUtils._
import eu.timepit.refined.util.time.Minute
import org.scalacheck.Prop._
import org.scalacheck.Properties

class NumericArbitrarySpec extends Properties("NumericArbitrary") {

  property("Less.positive") = checkArbitrary[Refined, Int, Less[W.`100`.T]]

  property("Less.negative") = checkArbitrary[Refined, Int, Less[W.`-100`.T]]

  property("Greater.positive") = checkArbitrary[Refined, Int, Greater[W.`100`.T]]

  property("Greater.negative") = checkArbitrary[Refined, Int, Greater[W.`-100`.T]]

  property("Interval") = checkArbitrary[Refined, Int, Interval[W.`0`.T, W.`100`.T]]

  property("Interval.alias") = forAll { m: Minute =>
    m >= 0 && m <= 59
  }
}