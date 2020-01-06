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
import javax.validation.constraints.Size;

/**
 *
 * @author ZORE
 */
@Embeddable
public class BesoinsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 4, max = 4)
    @Column(name = "CODESERVICE")
    private String codeservice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEARTICLE")
    private BigDecimal codearticle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANNEEBESOIN")
    private Short anneebesoin;

    public BesoinsPK() {
    }

    public BesoinsPK(String codeservice, BigDecimal codearticle, Short anneebesoin) {
        this.codeservice = codeservice;
        this.codearticle = codearticle;
        this.anneebesoin = anneebesoin;
    }

    public String getCodeservice() {
        return codeservice;
    }

    public void setCodeservice(String codeservice) {
        this.codeservice = codeservice;
    }

    public BigDecimal getCodearticle() {
        return codearticle;
    }

    public void setCodearticle(BigDecimal codearticle) {
        this.codearticle = codearticle;
    }

    public Short getAnneebesoin() {
        return anneebesoin;
    }

    public void setAnneebesoin(Short anneebesoin) {
        this.anneebesoin = anneebesoin;
    }

   

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BesoinsPK)) {
            return false;
        }
        BesoinsPK other = (BesoinsPK) object;
        if ((this.codeservice == null && other.codeservice != null) || (this.codeservice != null && !this.codeservice.equals(other.codeservice))) {
            return false;
        }
        if ((this.codearticle == null && other.codearticle != null) || (this.codearticle != null && !this.codearticle.equals(other.codearticle))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.BesoinsPK[ codeservice=" + codeservice + ", codearticle=" + codearticle + ", anneebesoin=" + anneebesoin + " ]";
    }
    
}
