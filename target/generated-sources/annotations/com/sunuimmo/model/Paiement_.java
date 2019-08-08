package com.sunuimmo.model;

import com.sunuimmo.model.Location;
import com.sunuimmo.model.Typepaiement;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-23T18:17:10")
@StaticMetamodel(Paiement.class)
public class Paiement_ { 

    public static volatile SingularAttribute<Paiement, Location> idL;
    public static volatile SingularAttribute<Paiement, Integer> idP;
    public static volatile SingularAttribute<Paiement, Typepaiement> typePaiement;
    public static volatile SingularAttribute<Paiement, Integer> montant;

}