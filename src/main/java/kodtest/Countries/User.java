package Countries;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
class User {
  private @Id @GeneratedValue Long id;
  private String name;

  User(String name) { this.name = name; }

  public Long getId() { return this.id; }

  public String getName() { return this.name; }

  public void setId(Long id) { this.id = id; }

  public void setName(String name) { this.name = name; }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(this instanceof User)) {
      return false;
    }
    User user = (User) object;
    return Objects.equals(this.id, user.id) && Objects.equals(this.name, user.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name);
  }

  @Override
  public String toString() {
    return "User{"
        + "id=" + this.id + ", name=" + this.name + "}";
  }
}