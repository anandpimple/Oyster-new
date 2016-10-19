package gov.tfl.oyster.repositories.lookupservice;

import gov.tfl.oyster.domains.lookupservice.LookupTypeVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by dev on 17/10/16.
 */
@Repository
public interface LookupRepository extends JpaRepository<LookupTypeVO, Long>{
    @Query(value = "SELECT vo FROM LookupTypeVO vo where vo.description = :typeName")
    Optional<LookupTypeVO> findLookupTypeByName(@Param("typeName") String typeName);
}
