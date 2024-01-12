package net.javaguides.repository;

import net.javaguides.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CardRepository extends JpaRepository<Card, Long> {

    @Modifying
    @Query("DELETE FROM Card c WHERE c.cardNumber = :cardNumber")
    void  deletecard(@Param("cardNumber")String cardNumber);

}
