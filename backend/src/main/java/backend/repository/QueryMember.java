package backend.repository;

import backend.bean.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface QueryMember extends JpaRepository<Member, Integer> {

    public List<Member> findAll();

    public Member findByAccountAndPassword(String Account,String Password);


    Optional<Member> findMemberById(Integer id);

    void deleteMemberById(Integer id);

//    @Modifying(clearAutomatically = true)
    @Query(value = "update test.member m set m.name=? where m.user_id=1")
    default void updatem(String name) {
        System.out.println(13);
    }

}
