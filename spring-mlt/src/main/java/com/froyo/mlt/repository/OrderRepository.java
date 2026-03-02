package com.froyo.mlt.repository;

import com.froyo.mlt.model.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    /**
     * Ethan uses @Query with JPQL to implement custom query methods
     * that handle multiple criteria, sorting, and pagination.
     */
    @Query("SELECT o FROM OrderEntity o WHERE o.status = :status AND o.amount > :minAmount")
    Page<OrderEntity> findComplexOrders(
            @Param("status") String status,
            @Param("minAmount") Double minAmount,
            Pageable pageable);

    /**
     * Native query example
     */
    @Query(value = "SELECT * FROM orders WHERE status = ?1", nativeQuery = true)
    List<OrderEntity> findByStatusNative(String status);
}
