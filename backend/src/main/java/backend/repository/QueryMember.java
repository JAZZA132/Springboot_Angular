package backend.repository;

import backend.bean.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueryMember extends JpaRepository<Member,String> {

    public List<Member> findAll();

    public Member findByAccountAndPassword(String Account,String Password);

//    void deleteMemberByID(int id);
}
