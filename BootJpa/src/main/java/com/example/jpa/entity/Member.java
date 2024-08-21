package com.example.jpa.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MEMBER")
@Getter
@Setter
//@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class) //JPA 엔티티를 관리하는 영역에서 자동으로 변수에 적용해주는 역할
//오티딩 기능을 활성화시키려면 main클래스 @EnableJpaAutoding을 추가한다.
public class Member {
    @Id //pk라는 의미
    private String id;
    @Column(nullable = false, length = 50) //null허용x, 길이50
    private String name;

    @CreatedDate //JPA를 통해서 인서트 시에 날짜가 자동 입력된다.
    @Column(updatable = false) //이 컬럼이 JPA에 의해서 자동으로 변경되는 것을 방지한다.
    private LocalDateTime signDate;


    //원투매니 단방향 조인 - 그냥 사용하게 되면 연관관계의 주인이 1이 되면서 맵핑 테이블이 자동 생성된다
    //연관관계의 주인이란? - FK를 관리하는 주체
//    @OneToMany(fetch = FetchType.EAGER) //OnetoMany dafault 조인 방식은 lazy
//    @JoinColumn(name = "member_id") //N테이블의 member_id를 FK로 조인을 걸겠다 (적지않으면 맵핑테이블 자동생성)
//    private final List<Memo> list = new ArrayList<>();

    //양방향 맵핑
    //toString 한쪽에서 지운다
    @OneToMany(mappedBy = "member") //mappedBy:1쪽에서 지정하고, 연관관계의 주인을 나타내는 키워드(N쪽의 키워드)
    private final List<Memo> list = new ArrayList<>();
}
