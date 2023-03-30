package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.Member;

public interface MemberService {
    Member addMember (Member member);
    Member editMember (Member member);
    List<Member> getMembers ();
    Member getMemberById(Long memberId);
    //Member getTypeByName(String typeName);
    void deleteMember( Long memberId);
}
