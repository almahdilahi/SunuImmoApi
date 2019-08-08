package com.sunuimmo.model;

import com.sunuimmo.model.Location;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-23T18:17:10")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> profession;
    public static volatile SingularAttribute<Client, Integer> ine;
    public static volatile ListAttribute<Client, Location> locationList;
    public static volatile SingularAttribute<Client, String> nomcomplet;
    public static volatile SingularAttribute<Client, String> adresse;
    public static volatile SingularAttribute<Client, Integer> idC;
    public static volatile SingularAttribute<Client, byte[]> photo;
    public static volatile SingularAttribute<Client, Integer> tel;
    public static volatile SingularAttribute<Client, Date> datenaiss;
    public static volatile SingularAttribute<Client, String> email;

}