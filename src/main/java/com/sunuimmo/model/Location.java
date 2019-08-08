/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunuimmo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l")
    , @NamedQuery(name = "Location.findByIdL", query = "SELECT l FROM Location l WHERE l.idL = :idL")
    , @NamedQuery(name = "Location.findByDateDebut", query = "SELECT l FROM Location l WHERE l.dateDebut = :dateDebut")
    , @NamedQuery(name = "Location.findByDateFin", query = "SELECT l FROM Location l WHERE l.dateFin = :dateFin")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idL")
    private Integer idL;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateDebut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateFin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idL")
    private List<Paiement> paiementList;
    @JoinColumn(name = "client", referencedColumnName = "idC")
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "bien", referencedColumnName = "idB")
    @ManyToOne(optional = false)
    private Bien bien;
    @JoinColumn(name = "bailleur", referencedColumnName = "idBa")
    @ManyToOne
    private Bailleur bailleur;

    public Location() {
    }

    public Location(Integer idL) {
        this.idL = idL;
    }

    public Location(Integer idL, Date dateDebut, Date dateFin) {
        this.idL = idL;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Integer getIdL() {
        return idL;
    }

    public void setIdL(Integer idL) {
        this.idL = idL;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @XmlTransient
    public List<Paiement> getPaiementList() {
        return paiementList;
    }

    public void setPaiementList(List<Paiement> paiementList) {
        this.paiementList = paiementList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Bien getBien() {
        return bien;
    }

    public void setBien(Bien bien) {
        this.bien = bien;
    }

    public Bailleur getBailleur() {
        return bailleur;
    }

    public void setBailleur(Bailleur bailleur) {
        this.bailleur = bailleur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idL != null ? idL.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.idL == null && other.idL != null) || (this.idL != null && !this.idL.equals(other.idL))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sunuimmo.model.Location[ idL=" + idL + " ]";
    }
    
}
