// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package webhook.sample.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import webhook.sample.domain.Notifications;

privileged aspect Notifications_Roo_Jpa_Entity {
    
    declare @type: Notifications: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Notifications.id;
    
    @Version
    @Column(name = "version")
    private Integer Notifications.version;
    
    public Long Notifications.getId() {
        return this.id;
    }
    
    public void Notifications.setId(Long id) {
        this.id = id;
    }
    
    public Integer Notifications.getVersion() {
        return this.version;
    }
    
    public void Notifications.setVersion(Integer version) {
        this.version = version;
    }
    
}
