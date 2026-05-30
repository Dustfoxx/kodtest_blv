package kodtest.Countries;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
class Visitor {
  private @Id
  @GeneratedValue Long id;
  private String name;

  Visitor(){}

  Visitor(String name) { this.name = name;}

  public Long getId() { return this.id; }

  public String getName() { return this.name; }

  public void setId(Long id) { this.id = id; }

  public void setName(String name) { this.name = name; }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(this instanceof Visitor)) {
      return false;
    }
    Visitor visitor = (Visitor) object;
    return Objects.equals(this.id, visitor.id) && Objects.equals(this.name, visitor.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name);
  }

  @Override
  public String toString() {
    return "Visitor{"
        + "id=" + this.id + ", name=" + this.name + "}";
  }
}