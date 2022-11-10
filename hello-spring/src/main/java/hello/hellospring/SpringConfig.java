package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
//    private final DataSource dataSource; // JDBC template할 때 사용
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    /*private EntityManager em; // JPA에서 사용

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/

    private final MemberRepository memberRepository;

    @Autowired // 생성자 하나인 경우 생략 가능
    public SpringConfig(MemberRepository memberRepository) { // 스프링 데이터 JPA
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource); // jdbc
//        return new JdbcTemplateMemberRepository(dataSource); // JDBC template
//        return new JpaMemberRepository(em);
//    }
}
