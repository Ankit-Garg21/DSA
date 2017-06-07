package dr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileRead {

	public JSONFileRead() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main( String args[] ) {
		JSONParser parser = new JSONParser();
        try {
        	String filePath = new File("").getAbsolutePath();
        	Reader reader = new FileReader( filePath + "/src/dr/test.json" );
            Object obj = parser.parse( reader );
            JSONObject jsonObject = ( JSONObject ) obj;
            System.out.println( jsonObject );
            
            JSONObject testCase = ( JSONObject ) jsonObject.get( "Test-Case-1" );
            JSONArray assertions = ( JSONArray ) testCase.get( "ASSERTIONS" );
            System.out.println( assertions );

        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        } catch ( ParseException e ) {
            e.printStackTrace();
        }
	}

}
