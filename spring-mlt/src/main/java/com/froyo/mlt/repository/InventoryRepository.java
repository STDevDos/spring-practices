package com.froyo.mlt.repository;

import com.froyo.mlt.model.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import jakarta.persistence.LockModeType;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {

    /**
     * Alex implements pessimistic locking using @Lock(LockModeType.PESSIMISTIC_WRITE)
     * to manage concurrent access and prevent data inconsistencies in high-concurrency scenarios.
     */
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<InventoryEntity> findById(Long id);
}

