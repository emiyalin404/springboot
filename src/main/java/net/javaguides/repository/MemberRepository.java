package net.javaguides.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.javaguides.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("SELECT m FROM Member m WHERE" +
            " m.memberName = :member_name AND " +
            " m.password = :password ")
    List<Member> Login(@Param("member_name") String memberName, @Param("password") String password);

    List<Member> findByMemberId(Long memberId);
}
