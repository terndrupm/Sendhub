import java.io.IOException;

import us.monoid.web.*;
import static us.monoid.web.Resty.*;

public class AddContact {

    final static String SH_API_HOSTNAME = "api.sendhub.com";
    String apiKey = "[apiKey]";
	String userName = "[admin phone number]";

    public static void main(String[] args) throws IOException {
    	System.out.println("starting..");

        String contactsUrl = "https://" + SH_API_HOSTNAME + "/v1/contacts/?username=" + USERNAME + "&api_key=" + API_KEY;

        Resty r = new Resty();

        String contact = "{\"name\":\"BBBBBdsfB\", \"number\": \"555556666\"}";

        //r.alwaysSend("Content-Type", "application/json");

        String resp = r.text(contactsUrl, new Content("application/json", contact.getBytes())).toString();

        System.out.println("result=" + resp);

        System.out.println("done.");
    }   
}