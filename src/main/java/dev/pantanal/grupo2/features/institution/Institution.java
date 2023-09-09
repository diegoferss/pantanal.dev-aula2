package dev.pantanal.grupo2.features.institution;


import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Institution {
  @Id
  private String id;

  @Basic
  @Column
  private String name;

  @Basic
  @Column 
  private String description;

  @Basic
  @Column(columnDefinition = "double")
  private Number monetaryGoal;
}
