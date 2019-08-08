package com.sunuimmo.model;

import com.sunuimmo.model.Bailleur;
import com.sunuimmo.model.Bien;
import com.sunuimmo.model.Client;
import com.sunuimmo.model.Paiement;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-23T18:17:10")
@StaticMetamodel(Location.class)
public class Location_ { 

    public static volatile SingularAttribute<Location, Integer> idL;
    public static volatile SingularAttribute<Location, Date> dateDebut;
    public static volatile ListAttribute<Location, Paiement> paiementList;
    public static volatile SingularAttribute<Location, Client> client;
    public static volatile SingularAttribute<Location, Bailleur> bailleur;
    public static volatile SingularAttribute<Location, Date> dateFin;
    public static volatile SingularAttribute<Location, Bien> bien;

}