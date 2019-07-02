package models

import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

case class Test2(
  id:   Id[Test2],
  name: String
) extends HasId[Test2]

@Singleton
class Test2Repository @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) {

  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  private class Test2Table(tag: Tag) extends Table[Test2](tag, "test2") {

    def id = column[Id[Test2]]("id", O.PrimaryKey)

    def name = column[String]("name")

    def * = (id, name) <> (Test2.tupled, Test2.unapply)
  }

  private val test2 = TableQuery[Test2Table]

  def create(id: Id[Test2], name: String): Future[Int] = db.run {
    test2.map(t => (t.id, t.name)) += (id, name)
  }

}
