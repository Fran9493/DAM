package com.franciscojosegarciacutillas.appinstituto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

/**
 *
 * @author Fran
 */
@Entity
@Table(name = "empresas")
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByEmpresaId", query = "SELECT e FROM Empresa e WHERE e.empresaId = :empresaId"),
    @NamedQuery(name = "Empresa.findByNombreEmpresa", query = "SELECT e FROM Empresa e WHERE e.nombreEmpresa = :nombreEmpresa"),
    @NamedQuery(name = "Empresa.findBySector", query = "SELECT e FROM Empresa e WHERE e.sector = :sector")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "empresa_id")
    private Integer empresaId;
    @Basic(optional = false)
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;
    @Basic(optional = false)
    @Column(name = "sector")
    private String sector;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    @JsonIgnore
    private List<Practica> practicaList;

    public Empresa() {
    }

    public Empresa(Integer empresaId) {
        this.empresaId = empresaId;
    }

    public Empresa(Integer empresaId, String nombreEmpresa, String sector) {
        this.empresaId = empresaId;
        this.nombreEmpresa = nombreEmpresa;
        this.sector = sector;
    }

    public Integer getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Integer empresaId) {
        this.empresaId = empresaId;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public List<Practica> getPracticaList() {
        return practicaList;
    }

    public void setPracticaList(List<Practica> practicaList) {
        this.practicaList = practicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empresaId != null ? empresaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.empresaId == null && other.empresaId != null) || (this.empresaId != null && !this.empresaId.equals(other.empresaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empresa con ID = " + empresaId + ", Nombre = " + nombreEmpresa + ", Sector = " + sector;
    }

}
