/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author oktay
 */
@Entity
public class Vakit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
   @ManyToOne
   GenelBilgiler genelBilgiler;
    
    String icerik;

    public void setGenelBilgiler(GenelBilgiler genelBilgiler) {
        this.genelBilgiler = genelBilgiler;
        
        genelBilgiler.addVakit(this);
    }

    public GenelBilgiler getGenelBilgiler() {
        return genelBilgiler;
    }

    
    
    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Vakit)) {
            return false;
        }
        Vakit other = (Vakit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Vakit[ id=" + id + " ]";
    }
    
}
