package PIN.Bybane;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is a template class for testing
 */
@RestController
public class RESTapi {

    private final UpdateThread data;

    public RESTapi() {
        data = new UpdateThread();
        Thread thread = new Thread(data);
        thread.setDaemon(true);
        thread.start();
    }

    @GetMapping("/hi")
    String all() {
        return "hello world";
    }

    @PostMapping("/magicbutpost")
    Integer magicbutpost(@RequestBody Integer newINT) {
        return newINT;
    }

    @GetMapping("/bybanen")
    Object getLatestData() {
        return data.getLatest();
    }

}
