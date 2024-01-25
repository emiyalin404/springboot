package net.javaguides.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Modifying
    @Query("UPDATE Member m SET m.password = :password WHERE m.email = :email")
    void UpdateMember(@Param("email") String email, @Param("password") String password);

    List<Member> findByMemberId(Long memberId);

    @Query("SELECT m FROM Member m WHERE m.memberName = :member_name")
    List<Member> searchMember(@Param("member_name")String memberName);

    @Query("SELECT m FROM Member m WHERE m.memberName = :member_name AND "+
            " m.email = :email")
    List<Member> UpdatePasswordEmail(@Param("member_name") String memberName, @Param("email") String email);

}
