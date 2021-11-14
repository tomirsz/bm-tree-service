package com.bonsaimanager.treeservice.trees;

import com.bonsaimanager.treeservice.model.dto.PdfRequest;
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
interface TreeRepository extends JpaRepository<Tree, Long> {

    @Query("FROM Tree t where t.id = :treeId and t.userId = :userId")
    Optional<Tree> findByIdAndUserId(@Param("treeId") long treeId,
                                     @Param("userId") String userId);

    @Query("FROM Tree t where t.userId = :userId")
    List<Tree> findAllByUserId(@Param("userId") String userId);

    void deleteByIdAndUserId(@Param("treeId") long treeId,
                             @Param("userId") String userId);

    @Query("SELECT new com.bonsaimanager.treeservice.model.dto.PdfRequest(t.id, t.latinName, t.name) " +
            "FROM Tree t where t.id IN (:treesId) and t.userId = :userId")
    List<PdfRequest> getPdfRequest(@Param("treesId") List<Long> treesId,
                                   @Param("userId") String userId);
}
