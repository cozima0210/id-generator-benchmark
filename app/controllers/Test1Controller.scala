package controllers

import javax.inject.Singleton
import models.Test1
import play.api.mvc.InjectedController

@Singleton
class Test1Controller extends InjectedController {

  def get = Action {
    Ok
  }

  def create = Action { implicit request =>
    Test1.create("hoge")
    Ok
  }
}
