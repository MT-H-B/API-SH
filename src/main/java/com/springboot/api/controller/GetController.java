package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.apache.logging.log4j.util.StringBuilders;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    //@RequestMapping으로 GET API 구현
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello World";
    }

    //매개변수 없는 GET 메서드 구현
    @GetMapping(value="/name")
    public String getName() {
        return "Flature";
    }

    //@PathVariable을 활용한 GET 메서드 구현
    @GetMapping(value="/variable1/{variable}")
    public String variable1(@PathVariable("variable") String variable) {
        return variable;
    }

    //@PathVariable에 변수명을 매핑하는 방법
    @GetMapping(value="/variable2/{variable}")
    public String variable2(@PathVariable("variable") String var) {
        return var;
    }

    //@RequestParam을 활용한 GET 메서드 구현
    @GetMapping(value="/requset1")
    public String getRequsetParam1(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    //RequestParam과 Map을 조합한 GET 메서드 구현
    @GetMapping(value="/request2")
    public String getRequsetParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map ->{
            sb.append(map.getKey()+" "+map.getValue()+"\n");
        });

        return sb.toString();
    }

    //DTO 객체를 활용한 GET 메서드 구현
    @GetMapping(value="/request3")
    public String getRequsetParam3(MemberDto memberDto) {
        return memberDto.toString();
    }
}
