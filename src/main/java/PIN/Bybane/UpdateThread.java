package PIN.Bybane;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.web.client.RestTemplate;

public class UpdateThread implements Runnable {

    private Object latest;
    private static final int UPDATE_INTERVAL = 10_000;
    private static final String URL = "https://bybanensanntidapiv2.azurewebsites.net/lines";

    public UpdateThread() {
        this.latest = new Object();
    }

    @Override
    public void run() {
        while (true) {

            RestTemplate restTemplate = new RestTemplate();
            String bybanen = restTemplate.getForObject(URL, String.class);

            if (bybanen == null) return;

            JSONParser parser = new JSONParser(bybanen);

            try {
                latest = parser.parse();
                //noinspection BusyWait
                Thread.sleep(UPDATE_INTERVAL);
            }
            catch (ParseException | InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public Object getLatest() {
        return latest;
    }
}
