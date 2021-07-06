package backend.service;

import backend.bean.Member;
import backend.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import backend.repository.QueryMember;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class Loginservice {

    @Autowired
    private QueryMember queryMember;


    public List<Member> findAllMember(){
        List<Member> list = queryMember.findAll();
        return list;
    }

    public Member getQueryMember(Member member){
        Member m = queryMember.findByAccountAndPassword(member.getAccount(),member.getPassword());
        return m;
    }

    public Member findMemberById(int id){
        return queryMember.findMemberById(id)
                .orElseThrow(() -> new UserNotFoundException("user bt id" + id + "was not find"));
    }


    public Member addMember(Member member){
        member.setMemberCode(UUID.randomUUID().toString());
        return queryMember.save(member);
    }


    public Member updateMember(Member member){
        return queryMember.save(member);
    }



    public void deleteMember(int id){
        queryMember.deleteMemberById(id);
    }
}
