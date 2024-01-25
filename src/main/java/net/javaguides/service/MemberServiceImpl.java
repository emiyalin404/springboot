package net.javaguides.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.entity.Member;
import net.javaguides.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
    }

    @Override
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void UpdateMember(String email,String password) {
        memberRepository.UpdateMember(email,password);
    }

    @Override
    public List<Member> Login(String memberName, String password) {
        return memberRepository.Login(memberName, password);
    }

    @Override
    public List<Member> searchMember(String memberName) {
        return memberRepository.searchMember(memberName);
    }
    @Override
    public void Save(Member member) {
        memberRepository.save(member);
    }

    @Override
    public List<Member> updatePasswordEmail(String memberName, String email) {
        return memberRepository.UpdatePasswordEmail(memberName, email);
    }


}
