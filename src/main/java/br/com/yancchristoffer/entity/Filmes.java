/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.yancchristoffer.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "Filmes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filmes.findAll", query = "SELECT f FROM Filmes f")
    , @NamedQuery(name = "Filmes.findByIdfilme", query = "SELECT f FROM Filmes f WHERE f.idfilme = :idfilme")
    , @NamedQuery(name = "Filmes.findByTitulo", query = "SELECT f FROM Filmes f WHERE f.titulo = :titulo")
    , @NamedQuery(name = "Filmes.findByTamanho", query = "SELECT f FROM Filmes f WHERE f.tamanho = :tamanho")
    , @NamedQuery(name = "Filmes.findByGenero", query = "SELECT f FROM Filmes f WHERE f.genero = :genero")
    , @NamedQuery(name = "Filmes.findByResolucao", query = "SELECT f FROM Filmes f WHERE f.resolucao = :resolucao")})
public class Filmes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_filme")
    private Integer idfilme;
    @Column(name = "Titulo")
    private String titulo;
    @Column(name = "Tamanho")
    private Integer tamanho;
    @Column(name = "Genero")
    private String genero;
    @Column(name = "Resolucao")
    private String resolucao;
    @JoinTable(name = "HD_Filme", joinColumns = {
        @JoinColumn(name = "Id_filme", referencedColumnName = "Id_filme")}, inverseJoinColumns = {
        @JoinColumn(name = "Id_HD", referencedColumnName = "Id_HD")})
    @ManyToMany
    private Collection<Hd> hdCollection;

    public Filmes() {
    }

    public Filmes(Integer idfilme) {
        this.idfilme = idfilme;
    }

    public Integer getIdfilme() {
        return idfilme;
    }

    public void setIdfilme(Integer idfilme) {
        this.idfilme = idfilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getResolucao() {
        return resolucao;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }

    @XmlTransient
    public Collection<Hd> getHdCollection() {
        return hdCollection;
    }

    public void setHdCollection(Collection<Hd> hdCollection) {
        this.hdCollection = hdCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfilme != null ? idfilme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filmes)) {
            return false;
        }
        Filmes other = (Filmes) object;
        if ((this.idfilme == null && other.idfilme != null) || (this.idfilme != null && !this.idfilme.equals(other.idfilme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.yancchristoffer.entity.Filmes[ idfilme=" + idfilme + " ]";
    }
    
}
