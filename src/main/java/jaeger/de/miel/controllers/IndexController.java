package jaeger.de.miel.controllers;

import jaeger.de.miel.model.Hello;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class IndexController {

    @RequestMapping("/hello")
    public Hello hello(@RequestParam(name="name", defaultValue = "world") String name) {
        System.out.println("Hello from /hello endpoint");
        Hello h = new Hello();
        if (name.isEmpty()) h.setGreeting("Hello world");
        else h.setGreeting("Hello " + name);
        return h;
    }

    @RequestMapping("/ping")
    public String ping() {
        System.out.println("Hello from /ping endpoint");
        return "pong";
    }

    @RequestMapping("/helloworld-api")
    public String root() {
        System.out.println("Hello from / endpoint (root)");
        return "root";
    }

}
