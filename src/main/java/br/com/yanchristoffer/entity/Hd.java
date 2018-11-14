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
@Table(name = "HD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hd.findAll", query = "SELECT h FROM Hd h")
    , @NamedQuery(name = "Hd.findByIdHD", query = "SELECT h FROM Hd h WHERE h.idHD = :idHD")
    , @NamedQuery(name = "Hd.findByTamanho", query = "SELECT h FROM Hd h WHERE h.tamanho = :tamanho")
    , @NamedQuery(name = "Hd.findByNome", query = "SELECT h FROM Hd h WHERE h.nome = :nome")})
public class Hd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_HD")
    private Integer idHD;
    @Column(name = "Tamanho")
    private Integer tamanho;
    @Column(name = "Nome")
    private String nome;
    @ManyToMany(mappedBy = "hdCollection")
    private Collection<Filmes> filmesCollection;
    @JoinColumn(name = "Id_Usuario", referencedColumnName = "Id_Usuario")
    @ManyToOne
    private Usuario idUsuario;

    public Hd() {
    }

    public Hd(Integer idHD) {
        this.idHD = idHD;
    }

    public Integer getIdHD() {
        return idHD;
    }

    public void setIdHD(Integer idHD) {
        this.idHD = idHD;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Filmes> getFilmesCollection() {
        return filmesCollection;
    }

    public void setFilmesCollection(Collection<Filmes> filmesCollection) {
        this.filmesCollection = filmesCollection;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof Hd)) {
            return false;
        }
        Hd other = (Hd) object;
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
