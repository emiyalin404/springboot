package net.javaguides.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.entity.Member;
import net.javaguides.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
    }

    @Override
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public List<Member> Login(String memberName, String password) {
        return memberRepository.Login(memberName, password);
    }

}
