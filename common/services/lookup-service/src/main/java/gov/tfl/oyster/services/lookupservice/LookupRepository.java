package gov.tfl.oyster.services.lookupservice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by dev on 17/10/16.
 */
@Repository
@Qualifier(value = "lookupRepository" )
public interface LookupRepository extends JpaRepository<LookupTypeVO, Long>{
    @Query(name = "FindLookupByNameAndType")
    Optional<LookupVO> findLookupByNameAndType(@Param("name") String name, @Param("typeName") String typeName);
    @Query(name = "FindLookupTypeByName")
    Optional<LookupTypeVO> findLookupTypeByName(@Param("typeName") String typeName);
}
