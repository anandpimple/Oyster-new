package gov.tfl.oyster.domains.common;

import javax.annotation.Generated;
import javax.persistence.*;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by dev on 17/10/16.
 */
@MappedSuperclass
public abstract  class AbstractBaseVO implements BaseVO {

    /**
     * Used to keep track of identity when not yet in the database
     */
    protected UUID factId;

    private LocalDateTime createDate = generateBaseVoCreateDate();
    private LocalDateTime lastModified;

    /**
     * init the required properties of a Fact. Use init
     * instead of constructor as instances are copied during processing .
     */
    public void init() {
		/*
		 * The database identity codes before the factid so we check if the instance
		 * has been to the database.
		 */
        if (factId == null && isNew()) {
            factId = UUID.randomUUID();
        }
    }



    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
		/*
		 * Check if the instance is in the database. If so use the hashcode based upon the
		 * persisted state.
		 */
        final int prime = 31;
        int result = 1;

        if(factId != null) {
            result = result + factId.hashCode();
        }else if (!isNew()) {
            result = result + getId().intValue();
        }

        result = prime * result;
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
		/*
		 * Check if the instance is in the database. If so use the equals based upon the
		 * persisted state.
		 */

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AbstractBaseVO)) {
            return false;
        }

        //CH Also check the class
        if(!obj.getClass().equals(this.getClass())){
            return false;
        }

        final AbstractBaseVO other = (AbstractBaseVO) obj;
        if(factId != null && other.factId != null){
            return factId.equals(other.factId);
        }

        if(!isNew() && !other.isNew()){
            return getId().equals(other.getId());
        }

        return false;
    }

    private Long id;

    /**
     * Sets the ID
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * returns the ID
     *
     * @return id
     */
    @Id
    public Long getId() {
        return id;
    }

    /**
     * Checks whether New record
     *
     * @return <code>true</code> if the id is null;
     * <code>false</code> if the id is not null.
     */
    @Transient
    @Override
    public boolean isNew() {
        return (this.id == null);
    }

    /**
     * Create date is set on creation of the Java object
     * and then reset when first persisted.
     * @return the createDate
     */
    @Column(name="CREATE_DATE")
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * Last modified is set with the JVM time when an object is saved
     * @return the lastModified
     */
    @Column(name="LAST_MODIFIED")
    public LocalDateTime getLastModified() {
        return lastModified;
    }

    /**
     * @param lastModified the lastModified to set
     */
    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    /**
     * Default toString implementation
     * @return String information for object
     */
    public String toString() {
        //return "Class: " + this.getClass().getSimpleName() + " " + this.getId();
        StringBuffer ret = new StringBuffer();
        ret.append("======= " + getClass().getName() + " =======");
        ret.append("\n");
        ret.append("ID: " + ((BaseVO)this).getId() + "\n");

        Method[] methods = getClass().getMethods();
        int len = methods.length;
        for (int i = 0; i < len; i++) {
            try {
                if (methods[i].getParameterTypes().length == 0 && (methods[i].getName().startsWith("get") || methods[i].getName().startsWith("is"))) {

                    //BF Print out field level variables - but not collections to avoid triggering lazy loading
                    if(	!(Collection.class.isAssignableFrom(methods[i].getReturnType())) &&
                            !(Map.class.isAssignableFrom(methods[i].getReturnType()))	&&
                            !(BaseVO.class.isAssignableFrom(methods[i].getReturnType())) ) {
                        ret.append(methods[i].getName() + " \t \t " + methods[i].invoke(this, (Object[])null));
                        ret.append("\n");
                    }


                }
            } catch (Exception ex) {
                ret.append(methods[i].getName() + " - " + ex);
                ret.append("\n");
                continue;
            }
        }

        ret.append("======= " + getClass().getName() + " =======");
        ret.append("\n");
        return ret.toString();
    }
}
