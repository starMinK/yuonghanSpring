package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Minininini!!");
        return "hello";//hello(.html)을 찾아서 여기에 랜더링(연결) 해라.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-spring")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체로 전달하면 json 형식으로 데이터를 반환
    }

    static class Hello {
        private String name;
        //ctrl + n
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}