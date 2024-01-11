package net.javaguides.repository;

import net.javaguides.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByMemberId(Long memberId);

    @Query("SELECT o FROM Order o "+
            " JOIN Pay p "+
            "ON o.payId = p.payId "+
            " WHERE p.payId = :payId")
    List<Order>findpayId(@Param("payId") Long payId);

}
