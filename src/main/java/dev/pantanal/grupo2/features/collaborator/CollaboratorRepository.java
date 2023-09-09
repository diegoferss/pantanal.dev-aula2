package dev.pantanal.grupo2.features.collaborator;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dev.pantanal.grupo2.features.collaborator.Collaborator;
import dev.pantanal.grupo2.features.collaborator.Collaborator;

public interface CollaboratorRepository extends CrudRepository<Collaborator, String>{
  public List<Collaborator> findAll();
}
