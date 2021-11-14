package com.bonsaimanager.treeservice.fertilization;

import com.bonsaimanager.treeservice.model.entity.Fertilization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface FertilizationRepository extends JpaRepository<Fertilization, Long> {

    @Query("FROM Fertilization f where f.id = :fertilizationId and f.userId = :userId")
    Optional<Fertilization> findByIdAndUserId(@Param("fertilizationId") long fertilizationId,
                                              @Param("userId") String userId);

    @Query("FROM Fertilization f where f.userId = :userId")
    List<Fertilization> findAllByUserId(@Param("userId") String userId);

    void deleteByIdAndUserId(@Param("fertilizationId") long fertilizationId,
                             @Param("userId") String userId);
}
