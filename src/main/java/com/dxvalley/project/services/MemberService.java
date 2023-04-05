package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.Member;
import com.dxvalley.project.models.Unions;

public interface MemberService {
    Member addMember (Member member);
    Member editMember (Member member);
    List<Member> getMembers ();
    Member getMemberById(Long memberId);
    List<Member> getMembersByUnion(Unions union);
    //Member getTypeByName(String typeName);
    void deleteMember( Long memberId);
}
