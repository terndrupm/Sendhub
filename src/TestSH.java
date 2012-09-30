	import static us.monoid.web.Resty.data;
import static us.monoid.web.Resty.form;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import us.monoid.web.Resty;
	
public class TestSH {
	String apiKey = "192553fe14fd6c744fa094f1824faf6ac3c63ec3";
	String userName = "8504435145";
	  public static void main(String[] args)
	  throws Exception
	  {

			//https://api.sendhub.com/v1/inbox/?username=8504435145&api_key=192553fe14fd6c744fa094f1824faf6ac3c63ec3
	    new TestSH();
	  }

	  
	  public TestSH()
	  {
	    try
	    {
	     // String myUrl = "http://api.sendhub.com/v1/inbox/?username=8504435145&api_key=192553fe14fd6c744fa094f1824faf6ac3c63ec3";
	     // String myUrl = "http://api.sendhub.com/v1/message/?username=8504435145&api_key=192553fe14fd6c744fa094f1824faf6ac3c63ec3";
	      // if your url can contain weird characters you will want to 
	      // encode it here, something like this:
	      // myUrl = URLEncoder.encode(myUrl, "UTF-8");

	     //String results = getInbox();
	    //	String results = sendMessage();
	    	//String results = getContacts();
	    String results = registerContact();
	    	//String results = contactGroup();
	      System.out.println(results);
	    }
	    catch (Exception e)
	    {
	      // deal with the exception in your "controller"
	    }
	  }
	  
	  
	  private String contactGroup()
	  throws Exception
	  {
	    URL url = null;
	    BufferedReader reader = null;
	    StringBuilder stringBuilder;
		String desiredUrl = "http://api.sendhub.com/v1/contacts/?username=8504435145&api_key=192553fe14fd6c744fa094f1824faf6ac3c63ec3";

	    OutputStreamWriter out = null;
	    try
	    {
	      url = new URL(desiredUrl);
	      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	     //String data = "{\"contacts\": [40102],\"text\": \""+message+"\"}";
	     String data = "{\"id\": [69979]}";
	      connection.setRequestMethod("GET");
	      connection.setDoOutput(true);
	      connection.setRequestProperty("Content-Type", "application/json");  
	      connection.getOutputStream().write(data.getBytes());  
	      connection.getOutputStream().flush(); 

	      // give it 15 seconds to respond
	      connection.setReadTimeout(3*1000);
	      connection.connect();
	      
	      // read the output from the server
	      reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	      stringBuilder = new StringBuilder();

	      String line = null;
	      while ((line = reader.readLine()) != null)
	      {
	        stringBuilder.append(line + "\n");
	      }
	      return stringBuilder.toString();
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw e;
	    }
	    finally
	    {
	      // close the reader; this can throw an exception too, so
	      // wrap it in another try/catch block.
	      if (reader != null)
	      {
	        try
	        {
	          reader.close();
	        }
	        catch (IOException ioe)
	        {
	          ioe.printStackTrace();
	        }
	      }
	    }
	  }
	  
	  
	  private String registerContact()
	  throws Exception
	  {
		 URI uri = null;
	    BufferedReader reader = null;
	    StringBuilder stringBuilder;
		String url = "http://api.sendhub.com/v1/contacts/?username=8504435145&api_key=192553fe14fd6c744fa094f1824faf6ac3c63ec3";

	    OutputStreamWriter out = null;
	    try
	    {
	      /*
	    	url = new URL(desiredUrl);
	      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	      

	     String data = "{\"name\": \"contact\", \"number\": \"8505443986\"}";
	      
	      connection.setRequestMethod("POST");
	      connection.setDoOutput(true);
	      connection.setRequestProperty("Content-Type", "application/json");  
	      connection.getOutputStream().write(data.getBytes());  
	      connection.getOutputStream().flush(); 

	      // give it 15 seconds to respond
	      connection.setReadTimeout(15*1000);
	      connection.connect();
	      
	      // read the output from the server
	      reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	      stringBuilder = new StringBuilder();

	      String line = null;
	      while ((line = reader.readLine()) != null)
	      {
	        stringBuilder.append(line + "\n");
	      }
	      */
	    	uri = new URI(url.toString());
	    	new Resty().json(uri, form(data("name", "New"),
	                data("number", "8505443776")));
	      return "";
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw e;
	    }
	    finally
	    {
	      // close the reader; this can throw an exception too, so
	      // wrap it in another try/catch block.
	      if (reader != null)
	      {
	        try
	        {
	          reader.close();
	        }
	        catch (IOException ioe)
	        {
	          ioe.printStackTrace();
	        }
	      }
	    }
	  }

	  private String sendMessage()
	  throws Exception
	  {
	    URL url = null;
	    BufferedReader reader = null;
	    StringBuilder stringBuilder;
		String desiredUrl = "http://api.sendhub.com/v1/messages/?username=8504435145&api_key=192553fe14fd6c744fa094f1824faf6ac3c63ec3";

	    OutputStreamWriter out = null;
	    try
	    {
	      url = new URL(desiredUrl);
	      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	      
	     String message = "LESS Update\\n Day:$1.24\\n Month:$85.23\\n Budget:79%\\nPoints\\n Day: 100\\n Month: 650\\n Rank: 10";
	     StringBuffer joinMessage = new StringBuffer();
	     joinMessage.append("Reply with 'y' to receive LESS updates.\\n");
	     joinMessage.append("Earn Points Matt:\\n");
	     joinMessage.append("50 if you reply with 'y'.\\n");
	     joinMessage.append("100 for friends that enter 'XuVRt' at lessmob.com");
	     message = joinMessage.toString();
	     

	     //String data = "{\"contacts\": [40102],\"text\": \""+message+"\"}";
	     String data = "{\"contacts\": [69979],\"text\": \""+message+"\"}";
	      connection.setRequestMethod("POST");
	      connection.setDoOutput(true);
	      connection.setRequestProperty("Content-Type", "application/json");  
	      connection.getOutputStream().write(data.getBytes());  
	      connection.getOutputStream().flush(); 

	      // give it 15 seconds to respond
	      connection.setReadTimeout(15*1000);
	      connection.connect();
	      
	      // read the output from the server
	      reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	      stringBuilder = new StringBuilder();

	      String line = null;
	      while ((line = reader.readLine()) != null)
	      {
	        stringBuilder.append(line + "\n");
	      }
	      return stringBuilder.toString();
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw e;
	    }
	    finally
	    {
	      // close the reader; this can throw an exception too, so
	      // wrap it in another try/catch block.
	      if (reader != null)
	      {
	        try
	        {
	          reader.close();
	        }
	        catch (IOException ioe)
	        {
	          ioe.printStackTrace();
	        }
	      }
	    }
	  }
	  
	  //This works
  private String getInbox() throws Exception
	  {
		String desiredUrl = "http://api.sendhub.com/v1/inbox/?username=8504435145&api_key=192553fe14fd6c744fa094f1824faf6ac3c63ec3";
	    URL url = null;
	    BufferedReader reader = null;
	    StringBuilder stringBuilder;
	   
	    OutputStreamWriter out = null;
	    try
	    {
	      url = new URL(desiredUrl);
	      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	      connection.setRequestMethod("GET");

	      connection.setReadTimeout(15*1000);
	      connection.connect();
	      
	      reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	      stringBuilder = new StringBuilder();

	      String line = null;
	      while ((line = reader.readLine()) != null)
	      {
	        stringBuilder.append(line + "\n");
	      }
	      return stringBuilder.toString();
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw e;
	    }
	    finally
	    {
	      if (reader != null)
	      {
	        try
	        {
	          reader.close();
	        }
	        catch (IOException ioe)
	        {
	          ioe.printStackTrace();
	        }
	      }
	    }
  }
  
  private String getContacts() throws Exception
  {
	String desiredUrl = "http://api.sendhub.com/v1/contacts/?username=8504435145&api_key=192553fe14fd6c744fa094f1824faf6ac3c63ec3";
    URL url = null;
    BufferedReader reader = null;
    StringBuilder stringBuilder;
   
    OutputStreamWriter out = null;
    try
    {
      url = new URL(desiredUrl);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");

      connection.setReadTimeout(15*1000);
      connection.connect();
      
      reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      stringBuilder = new StringBuilder();

      String line = null;
      while ((line = reader.readLine()) != null)
      {
        stringBuilder.append(line + "\n");
      }
      return stringBuilder.toString();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw e;
    }
    finally
    {
      if (reader != null)
      {
        try
        {
          reader.close();
        }
        catch (IOException ioe)
        {
          ioe.printStackTrace();
        }
      }
    }
}
}

/*
Here's our solution to this:
Create a group with the name 'Meter' and the text to join keyword/slug 'y'. Add a contact via the api, send that contact a message 'Reply with y to signup to alerts'. If the recipient replies with 'y' (only) then they'll be automatically added to your Meter group. Does that work?

*/