/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunuimmo.service;

import com.sunuimmo.model.Paiement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface PaiementFacadeLocal {

    void create(Paiement paiement);

    void edit(Paiement paiement);

    void remove(Paiement paiement);

    Paiement find(Object id);

    List<Paiement> findAll();

    List<Paiement> findRange(int[] range);

    int count();
    
}
