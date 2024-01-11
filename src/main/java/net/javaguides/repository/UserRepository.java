package net.javaguides.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.javaguides.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE " +
            " u.userName LIKE CONCAT ( '%' , :query, '%' )" +
            " Or u.updateTime LIKE CONCAT( '%', :query, '%')")
    List<User> searchUsers(String query);

}
