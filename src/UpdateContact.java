import java.io.IOException;

import us.monoid.json.JSONObject;
import us.monoid.web.Content;
import us.monoid.web.Resty;
import static us.monoid.web.Resty.put;

public class UpdateContact {

    final static String SH_API_HOSTNAME = "api.sendhub.com";
    String apiKey = "[apiKey]";
	String userName = "[admin phone number]";

    public static void main(String[] args) throws IOException {
    	try{
    	System.out.println("starting..");
    	int sid = [sendhub_id];
    	String email = "[user's name]";
    	String phone = "[new phone number]";

        String contactsUrl = "https://" + SH_API_HOSTNAME + "/v1/contacts/"+sid+"/?username=" + USERNAME + "&api_key=" + API_KEY;

        Resty r = new Resty();

        String contact = "{\"id\": \""+sid+"\", \"name\":\""+email+"\", \"number\": \""+phone+"\"}";

        //r.alwaysSend("Content-Type", "application/json");
        String resp = r.text(contactsUrl, put(new Content("application/json", contact.getBytes()))).toString();

        JSONObject jsonObj = new JSONObject(resp);
		   
		   String id = (String) jsonObj.get("id");
		   
        
        System.out.println("result=" + resp);
        System.out.println("done.");
    	} catch (Exception e){
			e.printStackTrace();
		} finally {
			try{
			
			} catch (Exception e){
			}
		}
    }   
}

