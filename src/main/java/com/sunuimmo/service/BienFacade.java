/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunuimmo.service;

import com.sunuimmo.model.Bien;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP
 */
@Stateless
public class BienFacade extends AbstractFacade<Bien> implements BienFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_sunuImmo_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BienFacade() {
        super(Bien.class);
    }

    @Override
    public int getIdBienByNom(String nom) {
    try{
                return em.createQuery("SELECT b.idB FROM Bien b WHERE b.nomB =:log ",Integer.class)
                        .setParameter("log", nom)
                        .getSingleResult();

            }catch(Exception e){

            }
        return 0;
    }
    
}
