package PIN.Bybane;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RESTapi {
    //This is a template class for testing

    @GetMapping("/hi")
    String all() {
        return "hello world";
    }

    @PostMapping("/magicbutpost")
    Integer magicbutpost(@RequestBody Integer newINT) {
        return newINT;
    }

}
