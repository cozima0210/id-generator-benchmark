package controllers

import javax.inject.{Inject, Singleton}
import models.Test1Repository
import play.api.mvc.{Action, AnyContent, InjectedController}

import scala.concurrent.ExecutionContext

@Singleton
class Test1Controller @Inject()(test1Repository: Test1Repository)(implicit ec: ExecutionContext)
  extends InjectedController {

  def get: Action[AnyContent] = Action {
    Ok
  }

  def create: Action[AnyContent] = Action.async { implicit request =>
    test1Repository.create("hoge").map(_ => Ok)
  }
}
