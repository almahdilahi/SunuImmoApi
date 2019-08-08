package com.sunuimmo.model;

import com.sunuimmo.model.Paiement;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-23T18:17:10")
@StaticMetamodel(Typepaiement.class)
public class Typepaiement_ { 

    public static volatile SingularAttribute<Typepaiement, Integer> idTP;
    public static volatile ListAttribute<Typepaiement, Paiement> paiementList;
    public static volatile SingularAttribute<Typepaiement, String> nomTP;

}