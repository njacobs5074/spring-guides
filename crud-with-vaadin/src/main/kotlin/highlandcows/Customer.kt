package highlandcows

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
class Customer {
  @Id
  @GeneratedValue
  val id: Long? = null

  var firstName: String? = null
  var lastName: String? = null

  protected constructor() {}

  constructor(firstName: String?, lastName: String?) {
    this.firstName = firstName
    this.lastName = lastName
  }

  override fun toString(): String {
    return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName)
  }
}