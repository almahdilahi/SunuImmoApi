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
import javax.persistence.Id;
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
@Table(name = "typepaiement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typepaiement.findAll", query = "SELECT t FROM Typepaiement t")
    , @NamedQuery(name = "Typepaiement.findByIdTP", query = "SELECT t FROM Typepaiement t WHERE t.idTP = :idTP")
    , @NamedQuery(name = "Typepaiement.findByNomTP", query = "SELECT t FROM Typepaiement t WHERE t.nomTP = :nomTP")})
public class Typepaiement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTP")
    private Integer idTP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomTP")
    private String nomTP;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typePaiement")
    private List<Paiement> paiementList;

    public Typepaiement() {
    }

    public Typepaiement(Integer idTP) {
        this.idTP = idTP;
    }

    public Typepaiement(Integer idTP, String nomTP) {
        this.idTP = idTP;
        this.nomTP = nomTP;
    }

    public Integer getIdTP() {
        return idTP;
    }

    public void setIdTP(Integer idTP) {
        this.idTP = idTP;
    }

    public String getNomTP() {
        return nomTP;
    }

    public void setNomTP(String nomTP) {
        this.nomTP = nomTP;
    }

    @XmlTransient
    public List<Paiement> getPaiementList() {
        return paiementList;
    }

    public void setPaiementList(List<Paiement> paiementList) {
        this.paiementList = paiementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTP != null ? idTP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typepaiement)) {
            return false;
        }
        Typepaiement other = (Typepaiement) object;
        if ((this.idTP == null && other.idTP != null) || (this.idTP != null && !this.idTP.equals(other.idTP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sunuimmo.model.Typepaiement[ idTP=" + idTP + " ]";
    }
    
}
