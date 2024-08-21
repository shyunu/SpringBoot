package com.example.jpa;

import com.example.jpa.entity.Member;
import com.example.jpa.entity.MemberMemoDTO;
import com.example.jpa.entity.Memo;
import com.example.jpa.member.repository.MemberRepository;
import com.example.jpa.memo.repository.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class JPACustomTest05 {

    @Autowired
    MemoRepository memoRepository;
    @Autowired
    MemberRepository memberRepository;

//    @Test
//    public void testCode01() {
//        int result = memoRepository.updateTest("구현체를 통해 update", 15L);
//        System.out.println("성공실패:" + result);
//    }

    //member테이블의 예시데이터 삽입
//    @Test
//    public void testCode02() {
//        for(int i =1; i <= 5; i++) {
//            memberRepository.save(
//                    Member.builder()
//                            .id("abc" + i)
//                            .name("admin" + i)
//                            .build()
//                    //sign_date는 JPA대신해서 데이터를 삽입
//            );
//        }
//    }

    //조인테스트1
    @Test
    public void testCode03() {
        List<Memo> list = memoRepository.mtoJoin1(10L);
        for(Memo m : list) {
            System.out.println(m.toString());
        }
    }

    //2개 이상의 엔티티 동시 조회
    @Test
    public void testCode04() {
        List<Object[]> list = memoRepository.mtoJoin2(10L);
        for(Object[] arr : list) {
            System.out.println(Arrays.toString(arr));
        }
    }

    //연관 관계없는 엔티티 조인
    @Test
    public void testCode05() {
        List<Object[]> list = memoRepository.mtoJoin3("admin1");
        for(Object[] arr : list) {
            System.out.println(Arrays.toString(arr));
        }
    }

    //eager조인 vs lazy조인
    @Test
    @Transactional //lazy를 쓰려면 트랜잭션으로 묶어줘야함
    public void testCode06() {
        List<Memo> list = memoRepository.mtoJoin1(10L);
        Memo m = list.get(0); //실제 데이터를 조회할 때 뒤늦게 select가 동작함
        System.out.println(m);
    }

    //성능향상 fetch조인 - 단 한번의 select가 실행됨(로딩전략보다 우선시됨)
    @Test
    public void testCode07() {
        List<Memo> list = memoRepository.mtoJoin4();
        for(Memo m : list) {
            System.out.println(m.toString());
        }
    }

    ////////////////////////////////////////////////////////////////////
    //oneToMany방식
    @Test
    public void testCode08() {
        Member m = memoRepository.otmJoin1("abc1");
        System.out.println(m.toString());
    }

    //oneToMany - fetch조인
    @Test
    public void testCode09() {
        List<Member> list = memoRepository.otmJoin2("abc1");
        for(Member m : list) {
            System.out.println(m.toString());
        }

    }

    ///////////////////////////////////////////////////////////////////
    //DTO로 반환받기
    @Test
    public void testCode10() {
        List<MemberMemoDTO> list = memoRepository.otmJoin3("abc1");

        for(MemberMemoDTO m : list) {
            System.out.println(m.toString());
        }
    }


    // -- 실습 -- //
    @Test
    public void testCode11() {

        Page<MemberMemoDTO> list =
                memoRepository.joinPage("1", PageRequest.of(0,10));

        for(MemberMemoDTO m : list.getContent()) {
            System.out.println(m.toString()); //데이터
        }
        System.out.println("전체게시글수:" + list.getTotalElements());
    }



}
