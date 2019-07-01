import com.google.inject.AbstractModule
import models.IdGenerator

class GuiceModule extends AbstractModule {

  override def configure() {
    bind(classOf[IdGenerator]).toInstance(IdGenerator())
  }

}
