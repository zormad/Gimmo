/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ZORE
 */
public class BesoinId { 
    @Basic(optional = false)
    @NotNull
    //@Column(name = "ANNEEBESOIN")
    private int anneebesoin;
    @Basic(optional = false)
    @NotNull
    //@Column(name = "CODESERVICE")
    private String codeservice;
    @Basic(optional = false)
    @NotNull
    //@Column(name = "CODEARTICLE")
    private BigDecimal codearticle;
}
