/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zinbite.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Haluan
 */
@Entity
@Table(name = "produk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produk.findAll", query = "SELECT p FROM Produk p"),
    @NamedQuery(name = "Produk.findByProductID", query = "SELECT p FROM Produk p WHERE p.productID = :productID"),
    @NamedQuery(name = "Produk.findByName", query = "SELECT p FROM Produk p WHERE p.name = :name")})
public class Produk implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductID")
    private Integer productID;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    
    
    public Produk() {
    }

    public Produk(Integer productID) {
        this.productID = productID;
    }

    public Produk(Integer productID, String name) {
        this.productID = productID;
        this.name = name;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productID != null ? productID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produk)) {
            return false;
        }
        Produk other = (Produk) object;
        if ((this.productID == null && other.productID != null) || (this.productID != null && !this.productID.equals(other.productID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zinbite.Produk[ productID=" + productID + " ]";
    }
    
}
