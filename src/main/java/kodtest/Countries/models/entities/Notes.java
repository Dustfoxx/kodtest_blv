package kodtest.Countries.models.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Notes {
  private @Id
  @GeneratedValue Long id;
  @OneToOne()
  @JoinColumn(name = "user_id")
  private Visitor user;
  @OneToOne()
  @JoinColumn(name = "country_id")
  private Country country;
  private String note;

  public Notes(){}

  public Notes(String note, Visitor user_id, Country country_id) {
    this.note = note;
    this.user = user_id;
    this.country = country_id;
  }

  public Long getId() { return this.id; }
  public Visitor getUserId() { return this.user; }
  public Country getCountryId() { return this.country; }
  public String getNote() { return this.note; }

  public void setId(Long id) { this.id = id; }
  public void setUserId(Visitor user) { this.user = user; }
  public void setCountryId(Country country) { this.country = country; }
  public void setNote(String note) { this.note = note; }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof Notes)) {
      return false;
    }
    Notes note = (Notes) object;
    return Objects.equals(this.id, note.id) && Objects.equals(this.note, note.note)
            && Objects.equals(this.user, note.user) && Objects.equals(this.country, note.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.note, this.user, this.country);
  }

  @Override
  public String toString() {
    return "Notes{"
        + "id=" + this.id + ", note=" + this.note + ", user_id=" + this.user + ", country_id=" + this.country + "}";
  }
}