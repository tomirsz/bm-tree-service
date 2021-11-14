package com.bonsaimanager.treeservice.irrigation;

import com.bonsaimanager.treeservice.model.entity.Irrigation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface IrrigationRepository extends JpaRepository<Irrigation, Long> {

    @Query("FROM Irrigation i where i.id = :irrigationId and i.userId = :userId")
    Optional<Irrigation> findByIdAndUserId(@Param("irrigationId") long irrigationId,
                                           @Param("userId") String userId);

    @Query("FROM Irrigation i where i.userId = :userId")
    List<Irrigation> findAllByUserId(@Param("userId") String userId);

    void deleteByIdAndUserId(@Param("irrigationId") long irrigationId,
                             @Param("userId") String userId);
}
