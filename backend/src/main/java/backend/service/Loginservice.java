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

    public List<Member> getQuery(){
        List<Member> list = queryMember.findAll();
        list.stream().forEach(p -> System.out.println(p.toString()));
        return list;
    }
}
