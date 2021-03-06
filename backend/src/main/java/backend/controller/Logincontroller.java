package backend.controller;

import backend.bean.Member;
import backend.service.Loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        m.setId(1);
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
//    @ResponseBody
//    @GetMapping (value = "/login")
//    public List<Member> getMemberAll() {
//        System.out.println(loginservice.findAllMember());
//        return loginservice.findAllMember(); // <--查找所有會員
//    }

    //查全部會員
    @GetMapping(value = "/login")
    public ResponseEntity<List<Member>> getAllMember(){
        List<Member> members = loginservice.findAllMember();
        return  new ResponseEntity<>(members, HttpStatus.OK);
    }

    //查詢單一會員BYId
    @GetMapping(value = "/login/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable("id") Integer id){
        Member member = loginservice.findMemberById(id);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    //新增會員
    @PostMapping("/register")
    public ResponseEntity<Member> addMember(@RequestBody Member member){
        System.out.println("register  :  " + member);
        Member newMember = loginservice.addMember(member);
        return new ResponseEntity<>(newMember, HttpStatus.CREATED);
    }

    //編輯會員
    @PutMapping("/login/{id}")
    public ResponseEntity<Member> updateMember(@RequestBody Member member){
        System.out.println("update :  "  + member);
        Member updateMember = loginservice.updateMember(member);
        return new ResponseEntity<>(updateMember, HttpStatus.OK);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable("id") Integer id){
        loginservice.deleteMember(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //登入
    @ResponseBody
    @PostMapping (value = "/login")
    public ResponseEntity<?> getQueryMember(
            @RequestBody Member member,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {

            Member user = loginservice.getQueryMember(member);
            HttpSession session = request.getSession();

            Map<String, Object> map = new HashMap<>();

            if (user != null) {
                session.setAttribute(user.getAccount(), user.getAccount());
                session.setAttribute(String.valueOf(user.getId()), user.getId());
                session.setAttribute(user.getName(), user.getName());
                session.setAttribute(user.getPassword(),user.getPassword());
                map.put("user",user);
                map.put("Cstatus", "成功");
                map.put("status", true);
            } else {
                map.put("status", false);
                map.put("Cstatus", "登入失敗");
            }
            System.out.println(map);
//        response.addHeader("Access-Control-Allow-Credentials", "true");
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
//        response.addHeader("Access-Control-Allow-Headers", "Content-Type,X-CAF-Authorization-Token,sessionToken,X-TOKEN");
//        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
//            response.setStatus(HttpStatus.NO_CONTENT.value());
//        }

//        response.sendRedirect("/member");
        //重導向失敗
        return new ResponseEntity<>(map,HttpStatus.OK);
    }

}
