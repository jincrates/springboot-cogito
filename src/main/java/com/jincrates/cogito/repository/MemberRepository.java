package com.jincrates.cogito.repository;

import com.jincrates.cogito.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository  extends JpaRepository<Member, String> {
}
