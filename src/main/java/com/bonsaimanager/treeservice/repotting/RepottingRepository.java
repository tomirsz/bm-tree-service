package com.bonsaimanager.treeservice.repotting;

import com.bonsaimanager.treeservice.model.entity.Repot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface RepottingRepository extends JpaRepository<Repot, Long> {

    @Query("FROM Repot r where r.id = :repotId and r.userId = :userId")
    Optional<Repot> findByIdAndUserId(@Param("repotId") long repotId,
                                      @Param("userId") String userId);

    @Query("FROM Repot r where r.userId = :userId")
    List<Repot> findAllByUserId(@Param("userId") String userId);

    void deleteByIdAndUserId(@Param("repotId") long repotId,
                             @Param("userId") String userId);
}
