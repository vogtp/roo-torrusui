// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.unibas.roo.torrus.server.domain;

import ch.unibas.roo.torrus.server.domain.Settings;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

privileged aspect Settings_Roo_Jpa_Entity {
    
    declare @type: Settings: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Settings.id;
    
    @Version
    @Column(name = "version")
    private Integer Settings.version;
    
    public Long Settings.getId() {
        return this.id;
    }
    
    public void Settings.setId(Long id) {
        this.id = id;
    }
    
    public Integer Settings.getVersion() {
        return this.version;
    }
    
    public void Settings.setVersion(Integer version) {
        this.version = version;
    }
    
}
