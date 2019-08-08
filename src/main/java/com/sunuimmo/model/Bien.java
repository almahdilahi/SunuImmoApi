/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunuimmo.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "bien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bien.findAll", query = "SELECT b FROM Bien b")
    , @NamedQuery(name = "Bien.findByIdB", query = "SELECT b FROM Bien b WHERE b.idB = :idB")
    , @NamedQuery(name = "Bien.findByNomB", query = "SELECT b FROM Bien b WHERE b.nomB = :nomB")
    , @NamedQuery(name = "Bien.findByPrix", query = "SELECT b FROM Bien b WHERE b.prix = :prix")
    , @NamedQuery(name = "Bien.findByEtat", query = "SELECT b FROM Bien b WHERE b.etat = :etat")})
public class Bien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idB")
    private Integer idB;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomB")
    private String nomB;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix")
    private int prix;
    @Lob
    @Column(name = "photo1")
    private byte[] photo1;
    @Lob
    @Column(name = "photo2")
    private byte[] photo2;
    @Lob
    @Column(name = "photo3")
    private byte[] photo3;
    @Lob
    @Column(name = "photo4")
    private byte[] photo4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "etat")
    private int etat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bien")
    private List<Location> locationList;
    @JoinColumn(name = "proprietaire", referencedColumnName = "idBa")
    @ManyToOne
    private Bailleur proprietaire;

    public Bien() {
    }

    public Bien(Integer idB) {
        this.idB = idB;
    }

    public Bien(Integer idB, String nomB, int prix, int etat) {
        this.idB = idB;
        this.nomB = nomB;
        this.prix = prix;
        this.etat = etat;
    }

    public Integer getIdB() {
        return idB;
    }

    public void setIdB(Integer idB) {
        this.idB = idB;
    }

    public String getNomB() {
        return nomB;
    }

    public void setNomB(String nomB) {
        this.nomB = nomB;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public byte[] getPhoto1() {
        return photo1;
    }

    public void setPhoto1(byte[] photo1) {
        this.photo1 = photo1;
    }

    public byte[] getPhoto2() {
        return photo2;
    }

    public void setPhoto2(byte[] photo2) {
        this.photo2 = photo2;
    }

    public byte[] getPhoto3() {
        return photo3;
    }

    public void setPhoto3(byte[] photo3) {
        this.photo3 = photo3;
    }

    public byte[] getPhoto4() {
        return photo4;
    }

    public void setPhoto4(byte[] photo4) {
        this.photo4 = photo4;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    @XmlTransient
    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    public Bailleur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Bailleur proprietaire) {
        this.proprietaire = proprietaire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idB != null ? idB.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bien)) {
            return false;
        }
        Bien other = (Bien) object;
        if ((this.idB == null && other.idB != null) || (this.idB != null && !this.idB.equals(other.idB))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sunuimmo.model.Bien[ idB=" + idB + " ]";
    }
    
}
