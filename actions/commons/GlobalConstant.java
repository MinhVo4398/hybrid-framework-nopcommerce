package commons;

import java.io.File;

public class GlobalConstant {
	//DEV
	public static final String PORTAL_DEV_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_DEV_URL = "https://admin-demo.nopcommerce.com";
	
	//TESTING
	public static final String PORTAL_TESTING_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_TESTING_URL = "https://admin-demo.nopcommerce.com";
	
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	
	//Windows / MAC / Linux
	public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles";
	
}
