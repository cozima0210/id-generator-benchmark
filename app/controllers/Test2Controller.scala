package controllers

import javax.inject.{Inject, Singleton}
import models.{Id, IdGenerator, Test2, Test2Repository}
import play.api.mvc.{Action, AnyContent, InjectedController}

import scala.concurrent.ExecutionContext

@Singleton
class Test2Controller @Inject()(test2Repository: Test2Repository)(
  implicit ec:                                   ExecutionContext,
  idGenerator:                                   IdGenerator)
  extends InjectedController {

  def create: Action[AnyContent] = Action.async { implicit request =>
    test2Repository.create(Id.generate[Test2], "hoge").map(_ => Ok)
  }
}
