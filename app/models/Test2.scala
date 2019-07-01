package models

import scalikejdbc._

case class Test2(
  id:   Id[Test2],
  name: String
) extends HasId[Test2]

object Test2 extends SQLSyntaxSupport[Test2] {

  override def tableName = "test2"

  def defaultAlias = syntax("t2")

  def create(name: String)(implicit g: IdGenerator, s: DBSession = autoSession): Int = {

    val c = column
    withSQL(insert.into(Test2).namedValues(c.id -> Id[Test2].value, c.name -> name)).update().apply()
  }
}
