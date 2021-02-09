package com.ts;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.dao.CategoryDAO;
import com.dao.FavouriteDAO;
import com.dao.GardenerDAO;
import com.dao.ItemDAO;
import com.dao.StoreDAO;
import com.dao.UserDAO;
import com.dto.CategoryDetails;
import com.dto.FavouriteDetails;
import com.dto.GardenerDetails;
import com.dto.ItemDetails;
import com.dto.StoreDetails;
import com.dto.UserDetails;
import com.ts.db.HibernateTemplate;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it!";
	}

	
	@Path("Hi")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hi() {
		return "Hi Service!";
	}

	
	@Path("registerUser")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerUser(UserDetails user) {
		System.out.println("Data Recieved in User Register : " + user);
		UserDAO userDao = new UserDAO();
		userDao.register(user);
	}

	
	@Path("registerGardener")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerGardener(GardenerDetails gardener) {
		System.out.println("Data Recieved in Gardener Register : " + gardener);
		GardenerDAO gardenerDao = new GardenerDAO();
		gardenerDao.register(gardener);
	}
	
	@Path("getUserByPass/{userEmail}/{userPassword}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object getUserByPass(@PathParam("userEmail") String userEmail,@PathParam("userPassword") String userPassword) {
		System.out.println("Recieved path params: "+userEmail+userPassword); 
		UserDAO userDAO = new UserDAO();
		return userDAO.getUserByPass(userEmail, userPassword);
	} 
	
	@Path("getGardenerByUserPass/{gardenerEmail}/{gardenerPassword}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object getGardenerByUserPass(@PathParam("gardenerEmail") String gardenerEmail,@PathParam("gardenerPassword") String gardenerPassword) {
		System.out.println("Recieved path params: "+gardenerEmail+gardenerPassword); 
		GardenerDAO gardenerDAO = new GardenerDAO();
		return gardenerDAO.getGardenerByUserPass(gardenerEmail, gardenerPassword);
	} 
	
	@Path("uploadImage")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void uploadImage(@FormDataParam("itemImage") InputStream fileInputStream,@FormDataParam("itemImage") FormDataContentDisposition
	formDataContentDisposition, @FormDataParam("itemName") String itemName,@FormDataParam("itemType") String itemType, @FormDataParam("itemDescription") String itemDescription) throws IOException {; 
		int read = 0;
		byte[] bytes = new byte[1024];
		
		String path = this.getClass().getClassLoader().getResource("").getPath();
		
		String pathArr[] = path.split("/WEB-INF/classes/");
		
		FileOutputStream out = new FileOutputStream(new File(pathArr[0]+"/image/", formDataContentDisposition.getFileName()));
				
				
		while((read = fileInputStream.read(bytes)) != -1){	
			
			out.write(bytes,0,read);
		}
		out.flush();
		out.close();
		
		ItemDetails item = new ItemDetails();
		item.setItemName(itemName);
		item.setItemType(itemType);
		item.setItemDescription(itemDescription);
		item.setItemImage(formDataContentDisposition.getFileName());
		ItemDAO itemDao = new ItemDAO();
		itemDao.additem(item);
	}
	@Path("uploadVideo")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void uploadVideo(@FormDataParam("itemVideo") InputStream fileInputStream,@FormDataParam("itemVideo") FormDataContentDisposition
	formDataContentDisposition, @FormDataParam("itemName") String itemName,@FormDataParam("itemType") String itemType, @FormDataParam("itemDescription") String itemDescription) throws IOException {; 
		int read = 0;
		byte[] bytes = new byte[1024];
		
		String path = this.getClass().getClassLoader().getResource("").getPath();
		
		String pathArr[] = path.split("/WEB-INF/classes/");
		
		FileOutputStream out = new FileOutputStream(new File(pathArr[0]+"/image/", formDataContentDisposition.getFileName()));
				
				
		while((read = fileInputStream.read(bytes)) != -1){	
			
			out.write(bytes,0,read);
		}
		out.flush();
		out.close();
		
		ItemDetails item = new ItemDetails();
		item.setItemName(itemName);
		item.setItemType(itemType);
		item.setItemDescription(itemDescription);
		item.setItemVideo(formDataContentDisposition.getFileName());
		ItemDAO itemDao = new ItemDAO();
		itemDao.additem(item);
	}
	@Path("uploadReview")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void uploadImage(@FormDataParam("picture") InputStream fileInputStream,@FormDataParam("picture") FormDataContentDisposition
	formDataContentDisposition, @FormDataParam("name") String name,@FormDataParam("review") String review) throws IOException {; 
		int read = 0;
		byte[] bytes = new byte[1024];
		
		String path = this.getClass().getClassLoader().getResource("").getPath();
		
		String pathArr[] = path.split("/WEB-INF/classes/");
		
		FileOutputStream out = new FileOutputStream(new File(pathArr[0]+"/image/", formDataContentDisposition.getFileName()));
				
				
		while((read = fileInputStream.read(bytes)) != -1){	
			
			out.write(bytes,0,read);
		}
		out.flush();
		out.close();
		
		StoreDetails store = new StoreDetails();
		store.setName(name);
		store.setReview(review);
		store.setPicture(formDataContentDisposition.getFileName());
		StoreDAO storeDao = new StoreDAO();
		storeDao.additem(store);
		
	}
	@Path("getItems")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ItemDetails> getItems() {

		ItemDAO itemDAO = new ItemDAO();
		
		List <ItemDetails> itemList = itemDAO.getAllItemDetailsByImage();
		return itemList;
	}
	
	@Path("getItemVideos")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ItemDetails> getItemVideos() {

		ItemDAO itemDAO = new ItemDAO();
		List <ItemDetails> itemList = itemDAO.getAllItemDetailsByVideo();

		return itemList;
	}
	
	@Path("getAllGardeners")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<GardenerDetails> getAllGardeners() {

		GardenerDAO GardenerDAO = new GardenerDAO();
		
		List <GardenerDetails> gardenerList = GardenerDAO.getAllGardeners();
		return gardenerList;
	}
	
	@Path("getItemByType/{itemType}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ItemDetails> getItems(@PathParam("itemType") String itemType){
		ItemDAO item = new ItemDAO();
		List <ItemDetails> itemList = item.getItemByType(itemType);
		return itemList;
		
	}
	
	@Path("mail/{name}/{emailId}/{Date}/{Time}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String mail(@PathParam("name") String name ,@PathParam("emailId") String emailId ,@PathParam("Date") String Date ,@PathParam("Time") String Time) throws MessagingException {
		String subject="Having an appointment";
		String body= "I am"+" "+name+" "+"Can we have an appointment on"+" "+Time+" "+Date;
		String email= emailId;
		String host = "smtp.gmail.com";
		String from = "aparna8222@gmail.com";
		String pass = "nagendraV";

		Properties props = System.getProperties();

		props.put("mail.smtp.starttls.enable", "true"); // added this line
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		String[] to = {email}; // added this line

		Session session = Session.getDefaultInstance(props, null);
		MimeMessage message1 = new MimeMessage(session);
		message1.setFrom(new InternetAddress(from));

		InternetAddress[] toAddress = new InternetAddress[to.length];

		// To get the array of addresses

		for( int i=0; i < to.length; i++ )
		{
			// changed from a while loop
			toAddress[i] = new InternetAddress(to[i]);
		}

		for( int i=0; i < toAddress.length; i++)
		{
			// changed from a while loop
			message1.addRecipient(Message.RecipientType.TO, toAddress[i]);
		}

		message1.setSubject(subject);
		message1.setText(body);

		Transport transport = session.getTransport("smtp");

		transport.connect(host, from, pass);
		transport.sendMessage(message1, message1.getAllRecipients());

		transport.close();
		System.out.println("Working");
        return "Successful";
    	}
	@Path("confirm/{name}/{userMail}/{Date}/{note}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String confirm(@PathParam("name") String name ,@PathParam("userMail") String userMail ,@PathParam("Date") String Date ,@PathParam("note") String note) throws MessagingException {
		String subject="Confirmation Mail";
		String body= "Dear"+" "+name+" "+";"+"Your Booking slot was"+note;
		String email= userMail;
		String host = "smtp.gmail.com";
		String from = "aparna8222@gmail.com";
		String pass = "nagendraV";

		Properties props = System.getProperties();

		props.put("mail.smtp.starttls.enable", "true"); // added this line
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		String[] to = {email}; // added this line

		Session session = Session.getDefaultInstance(props, null);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));

		InternetAddress[] toAddress = new InternetAddress[to.length];

		// To get the array of addresses

		for( int i=0; i < to.length; i++ )
		{
			// changed from a while loop
			toAddress[i] = new InternetAddress(to[i]);
		}

		for( int i=0; i < toAddress.length; i++)
		{
			// changed from a while loop
			message.addRecipient(Message.RecipientType.TO, toAddress[i]);
		}

		message.setSubject(subject);
		message.setText(body);

		Transport transport = session.getTransport("smtp");

		transport.connect(host, from, pass);
		transport.sendMessage(message, message.getAllRecipients());

		transport.close();
		System.out.println("Working");
        return "Successful";
    	}
	
	@Path("book")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void book(CategoryDetails category) {
		System.out.println("Data Recieved in category : " + category);
		CategoryDAO categoryDao = new CategoryDAO();
		categoryDao.register(category);
	}
	@Path("getGardenerById/{email}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CategoryDetails> getGardenerById(@PathParam("email") String email){
		CategoryDAO item = new CategoryDAO();
		List <CategoryDetails> itemList = item.getGardenerById(email);
		return itemList;
		
	}
	@Path("delete/{categoryId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam("categoryId") int categoryId){
		System.out.println("Data Recieved in delete : " + categoryId);
		HibernateTemplate.delete(categoryId);
		System.out.println("Successfull Deletion");
	}	
	@Path("updateRequest/{categoryId}/{note}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void updateRequest(@PathParam("categoryId") int categoryId,@PathParam("note") String note){
		System.out.println("Data Recieved to Update : ");
		HibernateTemplate.updateRequest(categoryId,note);
		System.out.println("Successfull Updation Request");
	}	
	@Path("updateFavourite/{itemId}/{note}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void updateFavourite(@PathParam("itemId") int itemId,@PathParam("note") String note){
		System.out.println("Data Recieved to Update : ");
		HibernateTemplate.updateFavourite(itemId,note);
		System.out.println("Successfull Updation ");
	}
	
	@Path("updateUser")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Object updateUser(UserDetails editUser) {
		System.out.println("Data Recieved to Update : " + editUser);
		UserDAO userDao = new UserDAO();
		return userDao.update(editUser);
	}
	@Path("updateGardener")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Object updateGardener(GardenerDetails editGardener) {
		System.out.println("Data Recieved to Update : " + editGardener);
		GardenerDAO gardenerDao = new GardenerDAO();
		return gardenerDao.update(editGardener);
	}
	@Path("getReviews")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<StoreDetails> getReviews() {

		StoreDAO storeDAO = new StoreDAO();
		
		List <StoreDetails> storeList = storeDAO.getAllStoreDetails();
		return storeList;
	}
	@Path("AddToFavourite")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void Add(FavouriteDetails favourite) {
		System.out.println("Data Recieved in Gardener Register : " + favourite);
		FavouriteDAO favouriteDao = new FavouriteDAO();
		favouriteDao.register(favourite);
	}
	@Path("getAllFavourites/{itemEmail}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FavouriteDetails> getAllFavourites(@PathParam("itemEmail") String itemEmail) {

		FavouriteDAO favouriteDAO = new FavouriteDAO();
		
		List <FavouriteDetails> favouriteList = favouriteDAO.getAllFavourites(itemEmail);
		return favouriteList;
	}
	@Path("cancel/{itemId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void cancel(@PathParam("itemId") int itemId){
		System.out.println("Data Recieved in delete : " + itemId);
		HibernateTemplate.cancel(itemId);
		System.out.println("Successfull Deletion");
	}	
	
		/*
		 @Path("sms")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
public String sendSms(String messageText,String mobile) {
try {
// Generate apikey from textlocal.in site...
String apiKey = "apikey=" + "GVQvUEFPNlE-TPuzonMGNfHVfkQ6vTMsDd688FMd7i";
String message = "&message=" + messageText;
String sender = "&sender=" + "TXTLCL";
String numbers = "&numbers=" + mobile;

System.out.println("while sedning to "+mobile);
System.out.println("while api key to "+apiKey);
System.out.println("while api message to "+messageText);

// Send data
HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
String data = apiKey + numbers + message + sender;
conn.setDoOutput(true);
conn.setRequestMethod("POST");
conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
conn.getOutputStream().write(data.getBytes("UTF-8"));
final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
final StringBuffer stringBuffer = new StringBuffer();
String line;
while ((line = rd.readLine()) != null) {
stringBuffer.append(line);
}
rd.close();

return stringBuffer.toString();
} catch (Exception e) {
System.out.println("while sending failed "+e);
return "Error "+e;
}
		*/
	
	}
