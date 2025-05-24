package org.example.charityproject1.model;


import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "actionsCharite")
public class ActionCharite {

    @Id
    private String idAction;

    @NotBlank(message = "Le titre est obligatoire")
    @Size(max = 100, message = "Le titre ne doit pas dépasser 100 caractères")
    private String titre;

    @NotBlank(message = "La description est obligatoire")
    @Size(max = 500, message = "La description ne doit pas dépasser 500 caractères")
    private String description;

    @NotNull(message = "La date est obligatoire")
    private Date dateAction; // Renommé pour correspondre au setter dans le contrôleur
    
    private Date dateCreation; // Date de création de l'action

    @NotBlank(message = "Le lieu est obligatoire")
    @Size(max = 100, message = "Le lieu ne doit pas dépasser 100 caractères")
    private String lieu;

    @Positive(message = "L'objectif de collecte doit être positif")
    private float objectifCollecte;

    @PositiveOrZero(message = "Le montant actuel ne peut pas être négatif")
    private float montantActuel;

    private int nombreParticipants;

    private List<String> mediaUrls;

    @NotNull(message = "La catégorie est obligatoire")
    private String categorie; // Renommé pour correspondre au setter dans le contrôleur
    
    private boolean active; // Indique si l'action est active ou terminée

    private List<String> likedByUsers = new ArrayList<>(); // Initialisation pour éviter NPE

    private List<Utilisateurs> listUsersContribue = new ArrayList<>();
    
    private List<Don> listedons = new ArrayList<>();
    
    private String organisationId; // Renommé pour suivre la convention Java
    
    // Getters et setters mis à jour
    public String getIdAction() {
        return idAction;
    }

    public void setIdAction(String idAction) {
        this.idAction = idAction;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Méthodes pour dateAction (anciennement date)
    public Date getDateAction() {
        return dateAction;
    }

    public void setDateAction(Date dateAction) {
        this.dateAction = dateAction;
    }
    
    // Alias pour maintenir la compatibilité avec le code existant
    public Date getDate() {
        return dateAction;
    }

    public void setDate(Date date) {
        this.dateAction = date;
    }
    
    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public float getObjectifCollecte() {
        return objectifCollecte;
    }

    public void setObjectifCollecte(float objectifCollecte) {
        this.objectifCollecte = objectifCollecte;
    }

    public float getMontantActuel() {
        return montantActuel;
    }

    public void setMontantActuel(float montantActuel) {
        this.montantActuel = montantActuel;
    }

    public int getNombreParticipants() {
        return nombreParticipants;
    }

    public void setNombreParticipants(int nombreParticipants) {
        this.nombreParticipants = nombreParticipants;
    }

    public List<String> getMediaUrls() {
        return mediaUrls;
    }

    public void setMediaUrls(List<String> mediaUrls) {
        this.mediaUrls = mediaUrls;
    }

    // Méthodes pour categorie (anciennement categorieId)
    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    
    // Alias pour maintenir la compatibilité avec le code existant
    public String getCategorieId() {
        return categorie;
    }

    public void setCategorieId(String categorieId) {
        this.categorie = categorieId;
    }
    
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public List<String> getLikedByUsers() {
        return likedByUsers;
    }

    public void setLikedByUsers(List<String> likedByUsers) {
        this.likedByUsers = likedByUsers;
    }

    public List<Utilisateurs> getListUsersContribue() {
        return listUsersContribue;
    }

    public void setListUsersContribue(List<Utilisateurs> listUsersContribue) {
        this.listUsersContribue = listUsersContribue;
    }

    public List<Don> getListedons() {
        return listedons;
    }

    public void setListedons(List<Don> listedons) {
        this.listedons = listedons;
    }

    // Méthodes pour organisationId (anciennement OrganisationId)
    public String getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(String organisationId) {
        this.organisationId = organisationId;
    }

    // Méthode pour ajouter un like - sécurisée contre les NPE
    public void ajouterLike(String userId) {
        if (this.likedByUsers == null) {
            this.likedByUsers = new ArrayList<>();
        }
        if (!this.likedByUsers.contains(userId)) {
            this.likedByUsers.add(userId);
        }
    }

    // Méthode pour supprimer un like - sécurisée contre les NPE
    public void supprimerLike(String userId) {
        if (this.likedByUsers != null) {
            this.likedByUsers.remove(userId);
        }
    }
}