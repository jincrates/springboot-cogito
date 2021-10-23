package com.jincrates.cogito.service;

import com.jincrates.cogito.entity.Member;

import java.util.List;

public interface MemberService {

    List<Member> findAll();

    Member findByEmail(String email);
}
