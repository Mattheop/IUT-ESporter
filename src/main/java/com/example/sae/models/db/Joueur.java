package com.example.sae.models.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.Objects;

public class Joueur {

    @Id
    private Integer id;
    @NotBlank(message = "{feedback.emptyfield}")
    private String prenom;

    @NotBlank(message = "{feedback.emptyfield}")
    private String nom;

    @NotBlank(message = "{feedback.emptyfield}")
    private String pseudo;
    @NotBlank(message = "{feedback.emptyfield}")
    private String nationnalite;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "{feedback.pastorpresentdate}")
    @NotNull(message = "{feedback.emptydate}")
    private LocalDate entree_pro;

    private AggregateReference<Ecurie, Integer> ecurie;

    public Joueur() {
    }

    public Joueur(String prenom, String nom, String pseudo, String nationnalite) {
        this(prenom, nom, pseudo, nationnalite, LocalDate.now());
    }

    public Joueur(String prenom, String nom, String pseudo, String nationnalite, LocalDate entree_pro) {
        this.prenom = prenom;
        this.nom = nom;
        this.pseudo = pseudo;
        this.nationnalite = nationnalite;
        this.entree_pro = entree_pro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getNationnalite() {
        return nationnalite;
    }

    public void setNationnalite(String nationnalite) {
        this.nationnalite = nationnalite;
    }

    public LocalDate getEntree_pro() {
        return entree_pro;
    }

    public void setEntree_pro(LocalDate entree_pro) {
        this.entree_pro = entree_pro;
    }

    public void setEcurie(AggregateReference<Ecurie, Integer> ecurie) {
        this.ecurie = ecurie;
    }

    public AggregateReference<Ecurie, Integer> getEcurie() {
        return ecurie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joueur joueur = (Joueur) o;
        return Objects.equals(id, joueur.id) && Objects.equals(prenom, joueur.prenom) && Objects.equals(nom, joueur.nom) && Objects.equals(pseudo, joueur.pseudo) && Objects.equals(nationnalite, joueur.nationnalite) && Objects.equals(entree_pro, joueur.entree_pro) && Objects.equals(ecurie.getId(), joueur.ecurie.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prenom, nom, pseudo, nationnalite, entree_pro, ecurie);
    }

    public String toString() {
        return "Player{" + "id=" + id + ", prenom='" + prenom + '\'' + ", nom='" + nom + '\'' + ", pseudo='" + pseudo + '\'' + ", nationnalite='" + nationnalite + '\'' + ", entree_pro=" + entree_pro + '}';
    }
}
