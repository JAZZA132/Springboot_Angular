package backend.controller;

import backend.bean.Member;
import backend.service.Loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Logincontroller {

    @Autowired
    private Loginservice loginservice;


    @ResponseBody
    @GetMapping(value = "/hello/{account}")
    public Member getHello(@PathVariable String account) {
        System.out.println(account);
        Member m = new Member();
        m.setId("1");
        m.setName("jason");
        m.setAccount(account);

        return m; // <--這邊的字串最後會顯示在前端頁面
    }

//    @ResponseBody
//    @PostMapping (value = "/hello")
//    public Member getpost(@RequestBody Member test) {
//        System.out.println(test);
//        Member m = new Member();
//        m.setId("1");
//        m.setName("jason");
//        //m.setName("jason");m.setName("jason");m.setName("jason");m.setName("jason");
//        return m; // <--這邊的字串最後會顯示在前端頁面
//    }


    @PostMapping (value = "/hello")
    public Member getMember(@RequestBody Member member) {

        loginservice.getQuery();
        return member; // <--這邊的字串最後會顯示在前端頁面
    }

}
