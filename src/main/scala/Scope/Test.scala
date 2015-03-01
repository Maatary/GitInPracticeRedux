package test

/**
 * Created by maatary on 2/23/15.
 */




object Test {


  object Wildcard {

    def x = "Wildcard Import x"

  }

  object Explicit {

    def x = "explicit import x"

  }

  def testSamePackage() = {
    println(x)
  }

  def testWildcardImport() = {
    import Wildcard._

    println(x)
  }

  def testExplicitImport(): Unit = {

    import Explicit.x
    import  Wildcard._
    println(x)

  }

  def testInlineDefinition() {
    val x = "Inline definition x"
    import Explicit.x
    import Wildcard._
    println(x)
  }

  def main(args : Array[String]) : Unit = {
    testSamePackage()
    testWildcardImport()
    testExplicitImport()
    testInlineDefinition()
  }

}


