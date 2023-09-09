package dev.pantanal.grupo2.features.institution;


import java.util.HashSet;
import java.util.Set;

import dev.pantanal.grupo2.features.collaborator.Collaborator;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
  @Column
  private Number monetaryGoal;

  @ManyToMany(mappedBy = "institutions")
    private Set<Collaborator> collaborators = new HashSet<>();
}
