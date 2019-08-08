package com.sunuimmo.model;

import com.sunuimmo.model.Bien;
import com.sunuimmo.model.Location;
import com.sunuimmo.model.Typebailleur;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-23T18:17:10")
@StaticMetamodel(Bailleur.class)
public class Bailleur_ { 

    public static volatile ListAttribute<Bailleur, Location> locationList;
    public static volatile ListAttribute<Bailleur, Bien> bienList;
    public static volatile SingularAttribute<Bailleur, String> adresse;
    public static volatile SingularAttribute<Bailleur, String> nomBa;
    public static volatile SingularAttribute<Bailleur, Integer> tel;
    public static volatile SingularAttribute<Bailleur, Integer> idBa;
    public static volatile SingularAttribute<Bailleur, Typebailleur> type;

}