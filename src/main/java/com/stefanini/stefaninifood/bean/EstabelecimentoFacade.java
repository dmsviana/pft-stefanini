/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stefanini.stefaninifood.bean;

import com.stefanini.stefaninifood.entity.Estabelecimento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dmviana
 */
@Stateless
public class EstabelecimentoFacade extends AbstractFacade<Estabelecimento> {

    @PersistenceContext(unitName = "stefaninifood")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstabelecimentoFacade() {
        super(Estabelecimento.class);
    }
    
}
