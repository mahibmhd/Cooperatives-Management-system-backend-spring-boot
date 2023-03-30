package com.dxvalley.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findMemberByMemberId(Long memberId);
}
