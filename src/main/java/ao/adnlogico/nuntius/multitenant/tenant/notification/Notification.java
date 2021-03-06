/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.adnlogico.nuntius.multitenant.tenant.notification;

import ao.adnlogico.nuntius.multitenant.tenant.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Sebastião Paulo
 */
@Entity
@Table(name = "notifications")
public class Notification implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "content")
    private int content;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "entity")
    private String entity;
    @Basic(optional = false)
    @Column(name = "entity_id")
    private int entityId;
    @Basic(optional = false)
    @Column(name = "created_at")
    private int createdAt;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "notifications")
    private Collection<User> users;

    public Notification()
    {
    }

    public Notification(Long id)
    {
        this.id = id;
    }

    public Notification(Long id, int content, String type, String entity, int entityId, int createdAt)
    {
        this.id = id;
        this.content = content;
        this.type = type;
        this.entity = entity;
        this.entityId = entityId;
        this.createdAt = createdAt;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public int getContent()
    {
        return content;
    }

    public void setContent(int content)
    {
        this.content = content;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getEntity()
    {
        return entity;
    }

    public void setEntity(String entity)
    {
        this.entity = entity;
    }

    public int getEntityId()
    {
        return entityId;
    }

    public void setEntityId(int entityId)
    {
        this.entityId = entityId;
    }

    public int getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(int createdAt)
    {
        this.createdAt = createdAt;
    }

    @JsonIgnore
    public Collection<User> getNotificationUsersCollection()
    {
        return users;
    }

    public void setNotificationUsersCollection(Collection<User> notificationUsersCollection)
    {
        this.users = notificationUsersCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entities.Notifications[ id=" + id + " ]";
    }

}
