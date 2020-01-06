/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Equipementreparation;
import com.entities.Equipementsortis;
import com.entities.Typeintervention;
import com.models.EquipementreparationFacade;
import com.models.TypeinterventionFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author ZORE
 */
@Named(value = "reparationBean")
@SessionScoped
public class ReparationBean implements Serializable {
private Typeintervention type=new Typeintervention();
private Equipementreparation reparation=new Equipementreparation();
@Inject
private EquipementreparationFacade facade;
@Inject
private TypeinterventionFacade typefacade;
private Equipementsortis equipementsortis=new Equipementsortis();


    public ReparationBean() {
    }
    
}
