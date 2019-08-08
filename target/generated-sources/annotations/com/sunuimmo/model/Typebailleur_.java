package com.sunuimmo.model;

import com.sunuimmo.model.Bailleur;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-23T18:17:10")
@StaticMetamodel(Typebailleur.class)
public class Typebailleur_ { 

    public static volatile SingularAttribute<Typebailleur, Integer> idTB;
    public static volatile SingularAttribute<Typebailleur, String> nomTB;
    public static volatile ListAttribute<Typebailleur, Bailleur> bailleurList;

}