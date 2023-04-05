package com.dxvalley.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxvalley.project.models.Member;
import com.dxvalley.project.models.Unions;
import com.dxvalley.project.repositories.MemberRepository;
import com.dxvalley.project.services.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private final MemberRepository memberRepository;
    @Override
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member editMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(Long memberId) {
        return memberRepository.findMemberByMemberId(memberId);
    }

    @Override
    public void deleteMember(Long memberId) {
       memberRepository.deleteById(memberId);
    }

    @Override
    public List<Member> getMembersByUnion(Unions union) {
      return  memberRepository.findMemberByUnion(union);
    }
    
}
