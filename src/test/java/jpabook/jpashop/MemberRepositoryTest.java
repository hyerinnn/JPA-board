package jpabook.jpashop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Rollback(false)
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional  // 테스트에 있으면 테스트끝나자마자 롤백을 시킴 -> 그래서 데이터 조회가 안됨 -> @Rollback(false)붙이면 됨
    public void testMember() throws Exception{

        Member member  = new Member();
        member.setUsername("memberA");

        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        assertThat(findMember.getId()).isEqualTo(member.getId());

    }
}