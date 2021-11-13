package com.bonsaimanager.treeservice.spraying;

import com.bonsaimanager.treeservice.model.entity.Spraying;
import com.bonsaimanager.treeservice.model.entity.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
interface SprayingRepository extends JpaRepository<Spraying, Long> {

    @Query("FROM Spraying s where s.id = :sprayingId and s.userId = :userId")
    Optional<Spraying> findByIdAndUserId(@Param("sprayingId") long sprayingId,
                                         @Param("userId") String userId);

    @Query("FROM Spraying s where s.userId = :userId")
    List<Spraying> findAllByUserId(@Param("userId") String userId);

    @Query("FROM Spraying s where s.id = :sprayingId and s.userId = :userId")
    void deleteById(@Param("sprayingId") long sprayingId,
                    @Param("userId") String userId);
}
