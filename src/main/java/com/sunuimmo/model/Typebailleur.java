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
@Table(name = "typebailleur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typebailleur.findAll", query = "SELECT t FROM Typebailleur t")
    , @NamedQuery(name = "Typebailleur.findByIdTB", query = "SELECT t FROM Typebailleur t WHERE t.idTB = :idTB")
    , @NamedQuery(name = "Typebailleur.findByNomTB", query = "SELECT t FROM Typebailleur t WHERE t.nomTB = :nomTB")})
public class Typebailleur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTB")
    private Integer idTB;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomTB")
    private String nomTB;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    private List<Bailleur> bailleurList;

    public Typebailleur() {
    }

    public Typebailleur(Integer idTB) {
        this.idTB = idTB;
    }

    public Typebailleur(Integer idTB, String nomTB) {
        this.idTB = idTB;
        this.nomTB = nomTB;
    }

    public Integer getIdTB() {
        return idTB;
    }

    public void setIdTB(Integer idTB) {
        this.idTB = idTB;
    }

    public String getNomTB() {
        return nomTB;
    }

    public void setNomTB(String nomTB) {
        this.nomTB = nomTB;
    }

    @XmlTransient
    public List<Bailleur> getBailleurList() {
        return bailleurList;
    }

    public void setBailleurList(List<Bailleur> bailleurList) {
        this.bailleurList = bailleurList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTB != null ? idTB.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typebailleur)) {
            return false;
        }
        Typebailleur other = (Typebailleur) object;
        if ((this.idTB == null && other.idTB != null) || (this.idTB != null && !this.idTB.equals(other.idTB))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sunuimmo.model.Typebailleur[ idTB=" + idTB + " ]";
    }
    
}
