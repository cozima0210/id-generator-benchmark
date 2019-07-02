package models

import com.google.common.io.BaseEncoding
import com.google.common.primitives.Longs
import slick.lifted.MappedTo

case class Id[A <: HasId[A]](value: Long) extends MappedTo[Long] {

  override def toString: String = BaseEncoding.base32Hex.encode(Longs.toByteArray(value))

}

object Id {

  def generate[A <: HasId[A]](implicit idGenerator: IdGenerator): Id[A] = Id[A](idGenerator.generate)

  def from[A <: HasId[A]](string: String): Id[A] = {
    val bytes = BaseEncoding.base32Hex.decode(string)
    val id    = Longs.fromByteArray(java.util.Arrays.copyOf(bytes, 8))
    Id[A](id)
  }
}

trait HasId[A <: HasId[A]] {
  val id: Id[A]
}
