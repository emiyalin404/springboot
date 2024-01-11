package net.javaguides.service;

import java.util.List;

import net.javaguides.entity.Member;

public interface MemberService {

    Member createMember(Member member);

    List<Member> Login(String memberName, String password);
}
