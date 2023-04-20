/**
 * 
 */
package com.mydemo.dataprovider;

import org.testng.annotations.DataProvider;

import com.mydemo.utility.NewExcelLibrary;

/**
 * @author Dinesh
 *
 */
public class DataProviders {
	
	NewExcelLibrary obj=new NewExcelLibrary();
	
	@DataProvider(name="NopLoginData")
	public Object[][] getNopLogindata(){
		int rows=obj.getRowCount("Sheet1");
		int columns=obj.getColumnCount("Sheet1");
		int actrows=rows-1;
		Object[][] data=new Object[actrows][columns];
		for(int i=0; i<actrows; i++) {
			for(int j=0; j<columns; j++) {
				data[i][j]=obj.getCellData("Sheet1", j, i+2);
			}
		}
		return data;
	}
	
	
	@DataProvider(name="NopAddressData")
	public Object[][] getNopAddressdata(){
		int rows=obj.getRowCount("Billing_Address");
		int columns=obj.getColumnCount("Billing_Address");
		int actrows=rows-1;
		Object[][] data=new Object[actrows][columns];
		for(int i=0; i<actrows; i++) {
			for(int j=0; j<columns; j++) {
				data[i][j]=obj.getCellData("illing_Address", j, i+2);
			}
		}
		return data;
	}
	
	

}
