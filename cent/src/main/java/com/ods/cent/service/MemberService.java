package com.ods.cent.service;

import com.ods.cent.domain.Member;
import com.ods.cent.helper.CommonPageInfo;
import com.ods.cent.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MemberService {

    @Autowired
    private MemberRepository repository;

    public List<Member> findAll(){
        return repository.findAll();
    }

    public Member save(Member member) {
        return repository.save(member);
    }

//    public void createDummy(){
//        for(int i=0; i<200; i++){
//            Member member = new Member();
//            member.setUsername("user"+i+"@naver.com");
//            member.setPassword("12345678");
//            repository.save(member);
//        }
//    }

//    public CommonPageInfo<Member> findAll(Pageable pageable) {
//        Page<Member> all = repository.findAll(pageable);
//        return new CommonPageInfo<Member>(all);
//    }
}
