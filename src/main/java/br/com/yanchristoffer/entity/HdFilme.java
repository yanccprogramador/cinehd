/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.yanchristoffer.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yan
 */
@Entity
@Table(name = "HD_Filme")
@XmlRootElement
public class HdFilme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_HD")
    private Integer idHD;
    @Id
    @Column(name = "Id_filme")
    private Integer idFilme;

    public HdFilme(Integer idHD, Integer idFilme) {
        this.idHD = idHD;
        this.idFilme = idFilme;
    }

    public HdFilme() {
    }

    public Integer getIdHD() {
        return idHD;
    }

    public void setIdHD(Integer idHD) {
        this.idHD = idHD;
    }

    public Integer getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Integer idFilme) {
        this.idFilme = idFilme;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHD != null ? idHD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HdFilme)) {
            return false;
        }
        HdFilme other = (HdFilme) object;
        if ((this.idHD == null && other.idHD != null) || (this.idHD != null && !this.idHD.equals(other.idHD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.yancchristoffer.entity.Hd[ idHD=" + idHD + " ]";
    }
    
}
