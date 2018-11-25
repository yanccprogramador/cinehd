/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.yanchristoffer.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yan
 */
@Entity
@Table(name = "compartilhamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compartilhamentos.findAll", query = "SELECT c FROM Compartilhamentos c")
    , @NamedQuery(name = "Compartilhamentos.findById", query = "SELECT c FROM Compartilhamentos c WHERE c.id = :id")
    , @NamedQuery(name = "Compartilhamentos.findByHd", query = "SELECT c FROM Compartilhamentos c WHERE c.hd = :hd")
    , @NamedQuery(name = "Compartilhamentos.findByFilme", query = "SELECT c FROM Compartilhamentos c WHERE c.filme = :filme")})
public class Compartilhamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "hd")
    private String hd;
    @Column(name = "filme")
    private String filme;

    public Compartilhamentos() {
    }

    public Compartilhamentos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compartilhamentos)) {
            return false;
        }
        Compartilhamentos other = (Compartilhamentos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.yanchristoffer.entity.Compartilhamentos[ id=" + id + " ]";
    }
    
}
