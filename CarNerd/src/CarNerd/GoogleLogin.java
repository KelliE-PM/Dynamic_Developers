package CarNerd;

//import java.io.InputStreamReader;

//import com.google.api.client.auth.oauth2.Credential;
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
//import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.util.store.FileDataStoreFactory;
public class GoogleLogin {
	/*
		private static Credential authorize() throws Exception {
		  // load client secrets
		  GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,
		      new InputStreamReader(PlusSample.class.getResourceAsStream("/client_secrets.json")));
		  // set up authorization code flow
		  GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
		      httpTransport, JSON_FACTORY, clientSecrets,
		      Collections.singleton(PlusScopes.PLUS_ME)).setDataStoreFactory(
		      dataStoreFactory).build();
		  // authorize
		  return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
		}
	public static void main(String[] args) {
		try {
		    httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		    dataStoreFactory = new FileDataStoreFactory(DATA_STORE_DIR);
		    // authorization
		    Credential credential = authorize();
		    // set up global Plus instance
		    plus = new Plus.Builder(httpTransport, JSON_FACTORY, credential).setApplicationName(
		        APPLICATION_NAME).build();
		        
		   // ...
		    
		}
	}*/
}