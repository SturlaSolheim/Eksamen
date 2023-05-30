package entities;

public class Office {
	
	private int officeCode;
	private String city;
	private String phone;
	private String adressLine1;
	private String adressLine2;
	private String state;
	private String country;
	private String postalCode;
	private String territory;
	
	public Office(int IOC, String IC, String IP, String IA, String IA2, String IS, String ICO, String IPC, String IT) {
		
		officeCode = IOC;
		city = IC;
		phone = IP;
		adressLine1 = IA;
		adressLine2 = IA2;
		state = IS;
		country = ICO;
		postalCode = IPC;
		territory = IT;
		
	}
}
