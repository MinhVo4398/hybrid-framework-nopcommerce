package commons;

import java.io.File;

public class GlobalConstants {
	//DEV
	public static final String PORTAL_DEV_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_DEV_URL = "https://admin-demo.nopcommerce.com";
	
	//TESTING
	public static final String PORTAL_TESTING_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_TESTING_URL = "https://admin-demo.nopcommerce.com";
	
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String OS_NAME = System.getProperty("os.name");
	
	//Windows / MAC / Linux
	public static final String UPLOAD_FILE= PROJECT_PATH + File.separator + "uploadFiles" +  File.separator;
	
	//Trỏ về thư mục mặc định của User
	//Window : Downloads
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	
	public static final String BROWSER_LOG= PROJECT_PATH + File.separator + "browserLogs";
	
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
	
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGImages" +File.separator;
	
	// Database Account / User/ Pass / Port
	public static final String DB_DEV_URL = "32.18.252.185:9860"; 
	public static final String DB_DEV_USER = "automationfc"; 
	public static final String DB_DEV_PASS = "P@ss0rld111222";
	
	public static final String DB_TEST_URL = "32.18.195.23:9860"; 
	public static final String DB_TEST_USER = "automationfc"; 
	public static final String DB_TEST_PASS = "P@ss0rld111222";
	
	public static final long SHORT_TIMEOUT =5;
	public static final long LONG_TIMEOUT = 30;
	public static final long RETRY_TEST_FAIL = 3;
	
	// Trang Admin LivetechPanda
	public static final String ADMIN_LIVETECH_PANDA ="http://live.techpanda.org/index.php/backendlogin/customer/";

	// BROWSERSTACK
	public static final String BROWSER_USERNAME ="minhv_LRHhFN";
	public static final String BROWSER_AUTOMATIC_KEY="6rptsktqU2QgH3WSXBZE";
	public static final String BROSWER_STACK_URL = "https://" + BROWSER_USERNAME + ":" + BROWSER_AUTOMATIC_KEY + "@hub-cloud.browserstack.com/wd/hub";

	// SAUCELAB
	public static final String SAUCELAB_USERNAME ="oauth-minhvo4398-662d3";
	public static final String SAUCELAB_AUTOMATE_KEY="07e6e1b4-7725-485c-b11d-0434604b8910";
	public static final String SAUCELAB_URL = "https://" + SAUCELAB_USERNAME + ":" + SAUCELAB_AUTOMATE_KEY + "@ondemand.apac-southeast-1.saucelabs.com:443/wd/hub";

	//CROSS_BROWSER_TESTING ( DO KO CO ACCOUNT NEN DIEN THONG TIN AO)
	public static final String CROSS_USERNAME ="dam@automationfc.com".replaceAll("@","%40");
	public static final String CROSS_ACCESS_KEY ="u87f3344224455";
	public static final String CORSS_URRL ="http://" + CROSS_USERNAME + ":" + CROSS_ACCESS_KEY	 + "@hub.crossbrowsertesting:80/wd/hub";

}
