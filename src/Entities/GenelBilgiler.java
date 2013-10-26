/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author oktay
 */
@Entity
public class GenelBilgiler implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    int cityId;
    
    int countryID; 
    
    String cityNameTR;
    
    String cityNameEN;
    
    String cityStateTR;
    
    @OneToMany
    List<Vakit> vakitlist;

    public GenelBilgiler() {
        vakitlist = new ArrayList<>();
        
    }
    
    public void addVakit(Vakit vakit){
        if(!getVakitlist().contains(vakit)){
            getVakitlist().add(vakit);
            vakit.setGenelBilgiler(this);
        }
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getCityNameTR() {
        return cityNameTR;
    }

    public void setCityNameTR(String cityNameTR) {
        this.cityNameTR = cityNameTR;
    }

    public String getCityNameEN() {
        return cityNameEN;
    }

    public void setCityNameEN(String cityNameEN) {
        this.cityNameEN = cityNameEN;
    }

    public String getCityStateTR() {
        return cityStateTR;
    }

    public void setCityStateTR(String cityStateTR) {
        this.cityStateTR = cityStateTR;
    }

    public List<Vakit> getVakitlist() {
        return vakitlist;
    }

    public void setVakitlist(List<Vakit> vakitlist) {
        this.vakitlist = vakitlist;
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
        if (!(object instanceof GenelBilgiler)) {
            return false;
        }
        GenelBilgiler other = (GenelBilgiler) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.GenelBilgiler[ id=" + id + " ]";
    }
    
}
