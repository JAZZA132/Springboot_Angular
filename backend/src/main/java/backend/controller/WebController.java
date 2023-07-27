package backend.controller;

import backend.bean.ChatMessage;
import backend.bean.Hello;
import backend.bean.User;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class WebController {

    @MessageMapping("/hello")
    @SendTo("/topic/hi")
    public Hello greeting(User user) throws Exception {
        return new Hello("Hi, " + user.getName() + "!");
    }

    @ApiOperation(value = "文件代號與版本")
    @PostMapping("/doQueryDocNoVersion")
    public ApiReturn<JSONObject> doQueryDocNoVersion() {
        ApiReturn<JSONObject> result = new ApiReturn<>();

        JSONObject data = new JSONObject();
        data.put("docNoVersion", generalDaoService.selectList("sinopac_aip.dbo.cust.CUST_MF_DOC_INF.SQL5"));

        result.setData(data);
        EventLogUtil.recordEvent(EventTypeEnum.B_MF_DOC, EventActionEnum.QD, "文件代號與版本");

        return result;
    }
    //test
}