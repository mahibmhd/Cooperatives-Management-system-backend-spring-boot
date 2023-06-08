package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.Federations;
import com.dxvalley.project.models.Member;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;

public interface MemberService {
    Member addMember (Member member);
    Member editMember (Member member);
    List<Member> getMembers ();
    Member getMemberById(Long memberId);
    List<Member> getMembersByUnion(Unions union);
    List<Member> getMembersByUnionAndGender(Unions union,String geneder);
    List<Member> getMembersByPrCooperativeAndGender(PrCooperative prCooperative, String gender);
    List<Member> getMemberByPrCooperative(PrCooperative prCooperative);
    List<Member> getMemberByFederation(Federations federation);
    List<Member> getMemberByFederationAndGender(Federations federation, String gender); 
    //Member getTypeByName(String typeName);
    void deleteMember( Long memberId);
}
