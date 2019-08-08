/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunuimmo.service;

import com.sunuimmo.model.Typebailleur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP
 */
@Stateless
public class TypebailleurFacade extends AbstractFacade<Typebailleur> implements TypebailleurFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_sunuImmo_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypebailleurFacade() {
        super(Typebailleur.class);
    }
    
}
