package pageUIs.liveTech.admin;

public class AdminCustomnerPageUI {
		public static final String 	POP_UP ="xpath=//div[@id='message-popup-window']";
		public static final String ClOSE_POP_UP ="xpath=//a[@title='close']";
		public static final String TEXTBOX_BY_HEADER ="xpath=//span[text()='%s']/ancestor::tr/following-sibling::tr/th[4]//input";
		
		public static final String SEARCH_BUTTON ="xpath=//button[@title='Search']";
		
		public static final String NAME_AND_EMAIL ="xpath=//td[contains(text(),'%s')]/following-sibling::td[contains(text(),'%s')]";
}
