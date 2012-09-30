import java.io.IOException;

import us.monoid.json.JSONObject;
import us.monoid.web.Content;
import us.monoid.web.Resty;
import static us.monoid.web.Resty.put;

public class UpdateContact {

    final static String SH_API_HOSTNAME = "api.sendhub.com";
    final static String USERNAME = "8504435145";
    final static String API_KEY = "192553fe14fd6c744fa094f1824faf6ac3c63ec3";

    public static void main(String[] args) throws IOException {
    	try{
    	System.out.println("starting..");
    	int sid = 330846;
    	String email = "terndrupm@lessmob.com";
    	String phone = "8505443987";

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

