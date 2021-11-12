package testDataTypes;

public class CustomerDataType {

	public Integer ID;
	
	public String firstName;
	public String lastName;
	public Integer age;
	public String emailAddress;
	public Address address;
	public PhoneNumber phoneNumber;
	public CreditCart creditCart;
	
	public class Address {
		public String streetAddress;
		public String city;
		public String postCode;
		public String state;
		public String country;
		public String county;
		}
	
	public class PhoneNumber {
		public String home;
		public String mob;
		}
	
	public class CreditCart {
		public String number;
		public String month;
		public String year;
		public String cuvNro;
		}
	
}
