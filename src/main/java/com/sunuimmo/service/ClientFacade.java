/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunuimmo.service;

import com.sunuimmo.model.Client;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_sunuImmo_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }

    @Override
    public Client getUser(String login, int password) {
try{
            return em.createQuery("SELECT c FROM Client c WHERE c.email =:log AND c.tel =:pwd",Client.class)
                    .setParameter("log", login)
                    .setParameter("pwd", password)
                    .getSingleResult();
                    
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public int getIdClientByNom(String nom) {
try{
            return em.createQuery("SELECT c.idC FROM Client c WHERE c.email =:log ",Integer.class)
                    .setParameter("log", nom)
                    .getSingleResult();
                    
        }catch(Exception e){
            
        }
    return 0;
    }

    @Override
    public Client getClientByINE(int ine) {
       System.out.println("INE:"+em);
try{
            return em.createQuery("SELECT c FROM Client c WHERE c.INE =:log",Client.class)
                    .setParameter("log", ine)
                    .getSingleResult();
                    
        }catch(Exception e){
            return null;
        }    }
    
}
