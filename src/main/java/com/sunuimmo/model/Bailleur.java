/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunuimmo.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "bailleur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bailleur.findAll", query = "SELECT b FROM Bailleur b")
    , @NamedQuery(name = "Bailleur.findByIdBa", query = "SELECT b FROM Bailleur b WHERE b.idBa = :idBa")
    , @NamedQuery(name = "Bailleur.findByNomBa", query = "SELECT b FROM Bailleur b WHERE b.nomBa = :nomBa")
    , @NamedQuery(name = "Bailleur.findByAdresse", query = "SELECT b FROM Bailleur b WHERE b.adresse = :adresse")
    , @NamedQuery(name = "Bailleur.findByTel", query = "SELECT b FROM Bailleur b WHERE b.tel = :tel")})
public class Bailleur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBa")
    private Integer idBa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomBa")
    private String nomBa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "adresse")
    private String adresse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tel")
    private int tel;
    @JoinColumn(name = "type", referencedColumnName = "idTB")
    @ManyToOne(optional = false)
    private Typebailleur type;
    @OneToMany(mappedBy = "bailleur")
    private List<Location> locationList;
    @OneToMany(mappedBy = "proprietaire")
    private List<Bien> bienList;

    public Bailleur() {
    }

    public Bailleur(Integer idBa) {
        this.idBa = idBa;
    }

    public Bailleur(Integer idBa, String nomBa, String adresse, int tel) {
        this.idBa = idBa;
        this.nomBa = nomBa;
        this.adresse = adresse;
        this.tel = tel;
    }

    public Integer getIdBa() {
        return idBa;
    }

    public void setIdBa(Integer idBa) {
        this.idBa = idBa;
    }

    public String getNomBa() {
        return nomBa;
    }

    public void setNomBa(String nomBa) {
        this.nomBa = nomBa;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public Typebailleur getType() {
        return type;
    }

    public void setType(Typebailleur type) {
        this.type = type;
    }

    @XmlTransient
    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    @XmlTransient
    public List<Bien> getBienList() {
        return bienList;
    }

    public void setBienList(List<Bien> bienList) {
        this.bienList = bienList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBa != null ? idBa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bailleur)) {
            return false;
        }
        Bailleur other = (Bailleur) object;
        if ((this.idBa == null && other.idBa != null) || (this.idBa != null && !this.idBa.equals(other.idBa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sunuimmo.model.Bailleur[ idBa=" + idBa + " ]";
    }
    
}
