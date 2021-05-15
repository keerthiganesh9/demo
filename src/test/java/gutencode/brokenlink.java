package gutencode;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class brokenlink {

	public static boolean Testlink(String url) throws MalformedURLException, IOException {

		HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
		con.setRequestMethod("HEAD");
		con.connect();
		int statusCode = con.getResponseCode();
		if (statusCode >= 400) {
			System.out.println("The current link is broken and there is no readable data present !!!");
			return false;
		} else

			System.out.println("All the data is present in this current book link and Happy Reading !!!");
		return true;

		
	}

}
