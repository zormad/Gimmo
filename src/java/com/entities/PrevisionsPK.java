/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ZORE
 */
@Embeddable
public class PrevisionsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CODESTRUCTURE")
    private String codestructure;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEARTICLE")
    private BigDecimal codearticle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANNEEPREVISION")
    private Short anneeprevision;

    public PrevisionsPK() {
    }

    public PrevisionsPK(String codestructure, BigDecimal codearticle, Short anneeprevision) {
        this.codestructure = codestructure;
        this.codearticle = codearticle;
        this.anneeprevision = anneeprevision;
    }

    public String getCodestructure() {
        return codestructure;
    }

    public void setCodestructure(String codestructure) {
        this.codestructure = codestructure;
    }

    public BigDecimal getCodearticle() {
        return codearticle;
    }

    public void setCodearticle(BigDecimal codearticle) {
        this.codearticle = codearticle;
    }

    public Short getAnneeprevision() {
        return anneeprevision;
    }

    public void setAnneeprevision(Short anneeprevision) {
        this.anneeprevision = anneeprevision;
    }

    
}
