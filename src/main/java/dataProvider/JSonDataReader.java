package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import io.cucumber.messages.internal.com.google.gson.Gson;
import managers.FileReaderMng;
import testDataTypes.CustomerDataType;

public class JSonDataReader {

	private final String customerPath = FileReaderMng.getInstance().getConfigReader().getTestData()
			+ FileReaderMng.getInstance().getConfigReader().getTestDataFile_Customer("customer");
	
	private List<CustomerDataType> customerList;
	
	public JSonDataReader() {
		customerList = getCustomerData();
	}
	
	private List<CustomerDataType> getCustomerData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader ( new FileReader ( customerPath ));
			CustomerDataType[] customer = gson.fromJson(bufferReader, CustomerDataType[].class);
			return Arrays.asList(customer);
		} catch ( FileNotFoundException o) {
			throw new RuntimeException ( "JSON file not found at path " + customerPath);
		} finally {
			try { 
				if ( bufferReader != null ) 
					bufferReader.close();
			} catch ( IOException ignore ) {	}
		}
	}
	
	public final CustomerDataType getCustomerByName( String customerName ) {
		return customerList.stream().filter(x -> x.firstName.equalsIgnoreCase( customerName )).findAny().get();
	}
	
	public final CustomerDataType getCredicartByName( String customerName ) {
		for ( CustomerDataType customer : customerList ) {
			if ( customer.firstName.equalsIgnoreCase( customerName )) return customer;
		}
		return null;
	}
	
	public final CustomerDataType getDataByID ( Integer customerID ) {
		// return customerList.stream().filter(x->x.ID.equalsIgnoreCase(customerID)).findAny().get();
		return customerList.stream().filter(x->x.ID.equals(customerID)).findAny().get();
	}
	
}
