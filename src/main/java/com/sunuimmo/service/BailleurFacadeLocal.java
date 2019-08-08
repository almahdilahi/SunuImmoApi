/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunuimmo.service;

import com.sunuimmo.model.Bailleur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface BailleurFacadeLocal {

    void create(Bailleur bailleur);

    void edit(Bailleur bailleur);

    void remove(Bailleur bailleur);

    Bailleur find(Object id);

    List<Bailleur> findAll();

    List<Bailleur> findRange(int[] range);

    int count();
    
    int getIdBailleurByNom(String nom);
    
    String getNomBailleurById(int id);
    
}
