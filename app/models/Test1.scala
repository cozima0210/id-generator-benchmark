package models

import scalikejdbc._

case class Test1(
  id:   Id[Test1],
  name: String
) extends HasId[Test1]

object Test1 extends SQLSyntaxSupport[Test1] {

  override def tableName = "test1"

  def defaultAlias = syntax("t1")

  def create(name: String)(implicit s: DBSession = autoSession): Int = {

    val c = column
    withSQL(insert.into(Test1).namedValues(c.name -> name)).update().apply()
  }
}
