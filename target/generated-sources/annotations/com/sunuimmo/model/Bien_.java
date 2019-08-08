package com.sunuimmo.model;

import com.sunuimmo.model.Bailleur;
import com.sunuimmo.model.Location;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-23T18:17:10")
@StaticMetamodel(Bien.class)
public class Bien_ { 

    public static volatile ListAttribute<Bien, Location> locationList;
    public static volatile SingularAttribute<Bien, Bailleur> proprietaire;
    public static volatile SingularAttribute<Bien, byte[]> photo1;
    public static volatile SingularAttribute<Bien, String> nomB;
    public static volatile SingularAttribute<Bien, Integer> prix;
    public static volatile SingularAttribute<Bien, Integer> idB;
    public static volatile SingularAttribute<Bien, byte[]> photo2;
    public static volatile SingularAttribute<Bien, byte[]> photo3;
    public static volatile SingularAttribute<Bien, Integer> etat;
    public static volatile SingularAttribute<Bien, byte[]> photo4;

}