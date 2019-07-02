package models

import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

case class Test1(
  id:   Id[Test1],
  name: String
) extends HasId[Test1]

@Singleton
class Test1Repository @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) {

  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  private class Test1Table(tag: Tag) extends Table[Test1](tag, "test1") {

    def id = column[Id[Test1]]("id", O.PrimaryKey, O.AutoInc)

    def name = column[String]("name")

    def * = (id, name) <> (Test1.tupled, Test1.unapply)
  }

  private val test1 = TableQuery[Test1Table]

  def create(name: String): Future[Test1] = db.run {
    (test1.map(_.name)
      returning test1.map(_.id)
      into ((name, id) => Test1(id, name))) += name
  }

}
