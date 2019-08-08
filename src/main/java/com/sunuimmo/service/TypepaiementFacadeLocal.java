/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunuimmo.service;

import com.sunuimmo.model.Typepaiement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface TypepaiementFacadeLocal {

    void create(Typepaiement typepaiement);

    void edit(Typepaiement typepaiement);

    void remove(Typepaiement typepaiement);

    Typepaiement find(Object id);

    List<Typepaiement> findAll();

    List<Typepaiement> findRange(int[] range);

    int count();
    
}
