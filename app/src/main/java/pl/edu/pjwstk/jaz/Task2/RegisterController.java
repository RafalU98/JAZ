package pl.edu.pjwstk.jaz.Zadanie2;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegisterController {

    @PostMapping("/register")
    public void  login(@RequestBody RegisterRequest registerRequest) {
        //zarejestrowac

    }
}
