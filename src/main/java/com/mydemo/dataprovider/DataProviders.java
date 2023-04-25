/**
 * 
 */
package com.mydemo.dataprovider;

import java.util.HashMap;
import java.util.Map;

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
	

	@DataProvider(name="NopSearchProduct")
	public Object[][] getSearchProductData(){
		int rows=obj.getRowCount("SearchProduct");
		int columns=obj.getColumnCount("SearchProduct");
		int actrows=rows-1;
		Object[][] data=new Object[actrows][columns];
		for(int i=0; i<actrows; i++) {
			for(int j=0; j<columns; j++) {
				data[i][j]=obj.getCellData("SearchProduct", j, i+2);
			}
		}
		return data;
	}
	
	@DataProvider(name="NopAddtoCart")
	public Object[][] getNopAddtoCartData(){
		int rows=obj.getRowCount("ProductQuantity");
		int columns=obj.getColumnCount("ProductQuantity");
		int actrows=rows-1;
		Object[][] data=new Object[actrows][columns];
		for(int i=0; i<actrows; i++) {
			for(int j=0; j<columns; j++) {
				data[i][j]=obj.getCellData("ProductQuantity", j, i+2);
			}
		}
		return data;
	}
	
	
	@DataProvider(name="newAcountDetailsData")
	public Object[][] getNopAcountDetailsData(){
		int rows=obj.getRowCount("AccountCreationData");
		int columns=obj.getColumnCount("AccountCreationData");
		int actrows=rows-1;
		Object[][] data=new Object[actrows][1];
		for(int i=0; i<actrows; i++) {
			   Map<String, String> hashMap=new HashMap<>();
			for(int j=0; j<columns; j++) {
				hashMap.put(obj.getCellData("AccountCreationData", j, 1),
						obj.getCellData("AccountCreationData", j, i+2));
			}
			data[i][0]=hashMap;
		}
		return data;
	}
	
	

}
