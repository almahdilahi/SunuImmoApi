/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunuimmo.service;

import com.sunuimmo.model.Bailleur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP
 */
@Stateless
public class BailleurFacade extends AbstractFacade<Bailleur> implements BailleurFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_sunuImmo_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BailleurFacade() {
        super(Bailleur.class);
    }

    @Override
    public int getIdBailleurByNom(String nom) {
        try{
                    return em.createQuery("SELECT b.idBa FROM Bailleur b WHERE b.nomBa =:log ",Integer.class)
                            .setParameter("log", nom)
                            .getSingleResult();

                }catch(Exception e){

                }
            return 0;
    }

    @Override
    public String getNomBailleurById(int id) {
            try{
                    return em.createQuery("SELECT ba.nomBa FROM Bailleur ba WHERE ba.idBa =:log  ",String.class)
                            .setParameter("log", id)
                            .getSingleResult();

                }catch(Exception e){

                }
            return null;
    }
    
}
