// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package webhook.sample.domain;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import webhook.sample.domain.Notifications;

privileged aspect Notifications_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Notifications.entityManager;
    
    public static final List<String> Notifications.fieldNames4OrderClauseFilter = java.util.Arrays.asList("notification");
    
    public static final EntityManager Notifications.entityManager() {
        EntityManager em = new Notifications().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Notifications.countNotificationses() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Notifications o", Long.class).getSingleResult();
    }
    
    public static List<Notifications> Notifications.findAllNotificationses() {
        return entityManager().createQuery("SELECT o FROM Notifications o", Notifications.class).getResultList();
    }
    
    public static List<Notifications> Notifications.findAllNotificationses(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Notifications o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Notifications.class).getResultList();
    }
    
    public static Notifications Notifications.findNotifications(Long id) {
        if (id == null) return null;
        return entityManager().find(Notifications.class, id);
    }
    
    public static List<Notifications> Notifications.findNotificationsEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Notifications o", Notifications.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Notifications> Notifications.findNotificationsEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Notifications o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Notifications.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Notifications.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Notifications.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Notifications attached = Notifications.findNotifications(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Notifications.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Notifications.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Notifications Notifications.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Notifications merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}