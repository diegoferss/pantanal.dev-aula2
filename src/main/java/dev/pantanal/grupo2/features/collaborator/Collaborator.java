package dev.pantanal.grupo2.features.collaborator;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import dev.pantanal.grupo2.features.institution.Institution;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Collaborator {

  public enum InstitutionType {
    NON_PROFIT("Sem fins lucrativos"),
    MEDICAL("Saúde"),
    FOOD("Comida");

    public final String label;

    private InstitutionType(String label) {
      this.label = label;
    }

    @JsonCreator
    public static InstitutionType fromString(String text) {
      for (InstitutionType institutionType : InstitutionType.values()) {
        if(institutionType.label.equalsIgnoreCase(text)) {
          return institutionType;
        }
      }

      return null;
    }

    @JsonValue
    public String toString() {
      return this.label.toString();
    }
  }

  @Id
  private String id;

  @Basic
  @Column
  private String name;

  @Basic
  @Column 
  private String company;

  @Basic
  @Column
  private Number investmentMoney;

  @ManyToMany
  @JoinTable(
      name = "collaborator_institution",
      joinColumns = @JoinColumn(name = "collaborator_id"),
      inverseJoinColumns = @JoinColumn(name = "institution_id")
  )
  private Set<Institution> institutions = new HashSet<>();
}