package backend.repository;

import backend.bean.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QueryMember extends JpaRepository<Member, Integer> {

    public List<Member> findAll();

    public Member findByAccountAndPassword(String Account,String Password);


    Optional<Member> findMemberById(int id);

    void deleteMemberById(int id);
}