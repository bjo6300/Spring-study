package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    // 스프링 데이터 JPA
    // 스프링 데이터 JPA가 자동으로 @Bean을 등록해준다.
    // JpaRepository 안에 기본기능으로 나머지 구현되어있다.
    // JPQL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name); // 인터페이스 함수 이름의 규칙성만으로 구현가능(기본기능) ex) findByNameAndId
}
