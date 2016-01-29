package net.blairdye.templates.embeddedjetty;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;

import org.apache.log4j.Logger;

public class SubmitToServletApp {
	private static final Logger logger = Logger.getLogger(SubmitToServletApp.class);
	private static final String USER_AGENT = "SubmitToServletApp";
	private static final String TEST_NAME = "testName";
	private static final String DESTINATION_URL = "destinationUrl";
	public static void main(String[] args) throws Exception{
		// load properties
		
		//call samlgenerator with properties
		
		//send saml response to destination
		
		//log response
		//listKeyStore();
		if(args.length == 0 || args[0] == null){
			logger.error("No arguments found.");
			logger.error(usage());
			return;
		}
		
	   	Properties prop = new Properties();
    	InputStream input = null;
    	
    	try {
        
    		String filename = "submittoservlet.properties";
    		//input = SamlMonitorApp.class.getClassLoader().getResourceAsStream(filename);
    		input = new FileInputStream(args[0]);
    		if(input==null){
    			logger.error("Sorry, unable to find " + filename);
    		    return;
    		}
    		
    		

    		//load a properties file from class path, inside static method
    		prop.load(input);
    		final String testName = prop.getProperty(TEST_NAME);
    		logger.debug(TEST_NAME+":"+testName);

    		final String destinationUrl = prop.getProperty(DESTINATION_URL);
    		logger.debug(TEST_NAME+":"+testName);
    		
    		
    		sendPost(DESTINATION_URL,"");
    		
    	} catch (IOException ex) {
    		logger.error(ex);
        } catch (Exception ce) {
    		logger.error(ce);
        }finally{
        	if(input!=null){
        		try {
				input.close();
			} catch (IOException e) {
				logger.error(e);
				
			}
        	}
        }
 
    }
	
	private static void sendPost(String url, String urlParameters) throws RuntimeException{
		try{
			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
	
			//add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	
			
			
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
	
			int responseCode = con.getResponseCode();
			logger.debug("Sending 'POST' request to URL : " + url);
			logger.debug("Post parameters : " + urlParameters);
			logger.info("Response Code : " + responseCode);
	
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//print result
			logger.info(response.toString());
		}catch(Exception e){
			logger.error(e);
			throw new RuntimeException("Could not POST SAML to "+url);
		}
	}
	
	private static String usage(){
		return "java -jar {jarname} {propertiesfile}";
	}

}
