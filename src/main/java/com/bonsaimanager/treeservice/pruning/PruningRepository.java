package com.bonsaimanager.treeservice.pruning;

import com.bonsaimanager.treeservice.model.entity.Prune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface PruningRepository extends JpaRepository<Prune, Long> {

    @Query("FROM Prune p where p.id = :pruningId and p.userId = :userId")
    Optional<Prune> findByIdAndUserId(@Param("pruningId") long pruningId,
                                      @Param("userId") String userId);

    @Query("FROM Prune p where p.userId = :userId")
    List<Prune> findAllByUserId(@Param("userId") String userId);

    void deleteByIdAndUserId(@Param("pruningId") long pruningId,
                             @Param("userId") String userId);
}
