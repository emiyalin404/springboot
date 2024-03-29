package net.javaguides.service;

import java.util.List;

import net.javaguides.entity.Member;

public interface MemberService {

    Member createMember(Member member);

    void UpdateMember(String email,String password);

    List<Member> Login(String memberName, String password);

    void Save(Member member);

    List<Member> searchMember(String memberName);

    List<Member> updatePasswordEmail(String memberName, String email);
}
