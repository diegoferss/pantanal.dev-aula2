package dev.pantanal.grupo2.features.institution;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface InstitutionRepository  extends CrudRepository<Institution, String>{
  public List<Institution> findAll();
}
