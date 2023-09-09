package dev.pantanal.grupo2.features.institution;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/institution")
public class InstitutionController {

  @Autowired
  private InstitutionRepository repository;

  @GetMapping
  public Collection<Institution> getAllInstitutions() {
    return this.repository.findAll();
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Institution> getInstitution(@PathVariable(value = "id", required = true) String id) {
    var institution = this.repository.findById(id);

    if(institution.isPresent()) return ResponseEntity.ok(institution.get());

    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<Institution> createInstitution(@RequestBody(required = true) Institution institution) {
    this.repository.save(institution);

    return ResponseEntity.status(HttpStatus.CREATED).body(institution);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<?> deleteInstitution(@PathVariable(value = "id", required = true) String id) {
    var institution = this.repository.findById(id);

    if(institution.isPresent()) {
      this.repository.delete(institution.get());
      return ResponseEntity.ok().build();
    }

    return ResponseEntity.notFound().build();
  }
}
