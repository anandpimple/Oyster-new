/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oma.domains;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 *
 * @author anandpimple
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
    private Long id;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID",nullable = false,length = 15)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "CREATION_DATE",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Column(name = "MODIFICATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Version
    @Column(name = "VERSION")
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
    
}