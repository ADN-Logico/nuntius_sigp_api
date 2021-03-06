/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.adnlogico.nuntius.multitenant.tenant.progress;

import ao.adnlogico.nuntius.multitenant.tenant.department.Department;
import ao.adnlogico.nuntius.multitenant.tenant.step.Step;
import ao.adnlogico.nuntius.multitenant.tenant.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * To track a progress of process each progress have many steps and on progress
 * parent.
 *
 * @author Sebastião Paulo
 */
@Entity
@Table(name = "progress")
public class Progress implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "fk_parent_progress")
    private Progress fkParent;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkParent")
    private Collection<Progress> progressCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProgress")
    private Collection<Step> stepsCollection;
    @JoinColumn(name = "fk_department", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Department fkDepartment;
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User fkUser;

    public Progress()
    {
    }

    public Progress(Long id)
    {
        this.id = id;
    }

    public Progress(Long id, String name, String description, Progress fkParent)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.fkParent = fkParent;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @JsonIgnore
    public Collection<Progress> getProgressCollection()
    {
        return progressCollection;
    }

    public void setProgressCollection(Collection<Progress> progressCollection)
    {
        this.progressCollection = progressCollection;
    }

    @JsonIgnoreProperties({"fkParent, progressCollection"})
    public Progress getFkParent()
    {
        return fkParent;
    }

    public void setFkParent(Progress fkParent)
    {
        this.fkParent = fkParent;
    }

    @JsonIgnore
    public Collection<Step> getStepsCollection()
    {
        return stepsCollection;
    }

    public void setStepsCollection(Collection<Step> stepsCollection)
    {
        this.stepsCollection = stepsCollection;
    }

    public Department getFkDepartment()
    {
        return fkDepartment;
    }

    public void setFkDepartment(Department fkDepartment)
    {
        this.fkDepartment = fkDepartment;
    }

    public User getFkUser()
    {
        return fkUser;
    }

    public void setFkUser(User fkUser)
    {
        this.fkUser = fkUser;
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
        if (!(object instanceof Progress)) {
            return false;
        }
        Progress other = (Progress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entities.Progress[ id=" + id + " ]";
    }

}
