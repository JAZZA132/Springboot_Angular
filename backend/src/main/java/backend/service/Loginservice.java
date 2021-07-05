package backend.service;

import backend.bean.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import backend.repository.QueryMember;

import java.util.List;

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

    public Member addMember(Member member){
        return queryMember.save(member);
    }


    public Member updateMember(Member member){
        return queryMember.save(member);
    }

//    public void deleteMember(int ID){
//        queryMember.deleteMemberByID(ID);
//    }
}
