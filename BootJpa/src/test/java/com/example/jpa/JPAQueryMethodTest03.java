package com.example.jpa;

import com.example.jpa.entity.Memo;
import com.example.jpa.memo.repository.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class JPAQueryMethodTest03 {

    //쿼리메서드 JPA인터페이스의 메서드 모형을 보고 SQL을 대신 실행시킨다. (다양한 select구문활용)
    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testCode01() {
//        Memo m = memoRepository.findByWriterAndText("example10", "sample10");
//        System.out.println(m.toString());
        List<Memo> list = memoRepository.findByMnoLessThan(20L); //20보다 미만
        System.out.println(list.toString());
    }

    @Test
    public void testCode02() {
        /* 1번 */
        Memo m1 = memoRepository.findByMno(11L);
        System.out.println(m1.toString());

        /* 2번 */
        List<Memo> list1 = memoRepository.findByMnoBetween(10L,20L);
        System.out.println(list1.toString());

        /* 3번 */
        List<Memo> list2 = memoRepository.findByWriterLike("%" + 10 + "%");
        System.out.println(list2.toString());

        /* 4번 */
        List<Memo> list3 = memoRepository.findByWriterOrderByWriterDesc("example1");
        System.out.println(list3.toString());

        /* 5번 */
        List<Memo> list4 = memoRepository.findByMnoIn(Arrays.asList(10L,20L,30L,40L,50L));
        System.out.println(list4.toString());
    }

    //쿼리메서드의 마지막 매개변수에 Pageable을 주면 페이징처리한다.
    @Test
    public void testCode07() {
        //쿼리메서드 + 페이지 결합
        Pageable pageable = PageRequest.of(0,10, Sort.by("mno").descending());
        List<Memo> list = memoRepository.findByMnoLessThanEqual(50L, pageable);

        for(Memo m : list) {
            System.out.println(m.toString());
        }
    }
}
