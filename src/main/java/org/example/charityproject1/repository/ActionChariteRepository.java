package org.example.charityproject1.repository;

import org.example.charityproject1.model.ActionCharite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionChariteRepository extends MongoRepository<ActionCharite, String> {
    // Find actions by category ID
    List<ActionCharite> findByCategorieId(String categorieId);

    // Find actions by title (case-insensitive search)
    List<ActionCharite> findByTitre(String titre);

    // Récupérer les actions d’une organisation
    List<ActionCharite> findByOrganisationId(String organisationId);

    List<ActionCharite> findByOrganisationIdOrderByDateCreationDesc(String organisationId);
}