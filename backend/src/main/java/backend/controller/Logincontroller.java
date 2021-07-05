package backend.controller;

import backend.bean.Member;
import backend.service.Loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@Controller
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


    //查全部會員
    @ResponseBody
    @GetMapping (value = "/login")
    public List<Member> getMemberAll() {
        System.out.println(loginservice.findAllMember());
        return loginservice.findAllMember(); // <--查找所有會員
    }

    //登入
    @ResponseBody
    @PostMapping (value = "/login")
    public String getQueryMember(
            @RequestBody Member member,
            HttpServletRequest request
            ) {

        Member user = loginservice.getQueryMember(member);
        HttpSession session = request.getSession();

        String str = "";
        if (user != null) {
            str = "成功登入";
            session.setAttribute("Account",user.getAccount());
            session.setAttribute("ID",user.getId());
            session.setAttribute("Name",user.getName());
            session.setAttribute("str",str);
            return str; // <--返回是否有這位會員
        } else {
            str = "登入失敗";
            session.setAttribute("str",str);
            return "redirect:/login";
        }

    }

}
