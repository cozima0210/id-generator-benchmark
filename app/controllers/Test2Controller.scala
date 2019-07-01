package controllers

import javax.inject.{Inject, Singleton}
import models.{IdGenerator, Test2}
import play.api.mvc.InjectedController

@Singleton
class Test2Controller @Inject()(implicit idGenerator: IdGenerator) extends InjectedController {

  def create = Action { implicit request =>
    Test2.create("hoge")
    Ok
  }
}
