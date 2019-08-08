/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunuimmo.service;

import com.sunuimmo.model.Typebailleur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface TypebailleurFacadeLocal {

    void create(Typebailleur typebailleur);

    void edit(Typebailleur typebailleur);

    void remove(Typebailleur typebailleur);

    Typebailleur find(Object id);

    List<Typebailleur> findAll();

    List<Typebailleur> findRange(int[] range);

    int count();
    
}
