/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunuimmo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "paiement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paiement.findAll", query = "SELECT p FROM Paiement p")
    , @NamedQuery(name = "Paiement.findByIdP", query = "SELECT p FROM Paiement p WHERE p.idP = :idP")
    , @NamedQuery(name = "Paiement.findByMontant", query = "SELECT p FROM Paiement p WHERE p.montant = :montant")})
public class Paiement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idP")
    private Integer idP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant")
    private int montant;
    @JoinColumn(name = "typePaiement", referencedColumnName = "idTP")
    @ManyToOne(optional = false)
    private Typepaiement typePaiement;
    @JoinColumn(name = "idL", referencedColumnName = "idL")
    @ManyToOne(optional = false)
    private Location idL;

    public Paiement() {
    }

    public Paiement(Integer idP) {
        this.idP = idP;
    }

    public Paiement(Integer idP, int montant) {
        this.idP = idP;
        this.montant = montant;
    }

    public Integer getIdP() {
        return idP;
    }

    public void setIdP(Integer idP) {
        this.idP = idP;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Typepaiement getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(Typepaiement typePaiement) {
        this.typePaiement = typePaiement;
    }

    public Location getIdL() {
        return idL;
    }

    public void setIdL(Location idL) {
        this.idL = idL;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idP != null ? idP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paiement)) {
            return false;
        }
        Paiement other = (Paiement) object;
        if ((this.idP == null && other.idP != null) || (this.idP != null && !this.idP.equals(other.idP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sunuimmo.model.Paiement[ idP=" + idP + " ]";
    }
    
}
