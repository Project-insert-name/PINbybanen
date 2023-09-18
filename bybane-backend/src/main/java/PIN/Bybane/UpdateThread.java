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
        //noinspection InfiniteLoopStatement
        while (true) {

            RestTemplate restTemplate = new RestTemplate();
            String apiData = restTemplate.getForObject(URL, String.class);

            if (apiData == null) {
                throw new NullPointerException("apiData is null");
            }
            else {
                JSONParser parser = new JSONParser(apiData);

                try {
                    latest = parser.parse();
                    //noinspection BusyWait
                    Thread.sleep(UPDATE_INTERVAL);
                }
                catch (ParseException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public Object getLatest() {
        return latest;
    }
}
