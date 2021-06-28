package MA.automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mypages.LoginPage;

import MA.generics.Excel;

public class TestClass {
   
  
	@Test(dataProvider="getData")
   void testDataProvider(String un,String pw) {
	   System.out.println(un+" "+pw);
   }
   
    
    @DataProvider
    public Object[][] getData() throws IOException {
    	Properties prop=new Properties();
		String currentLoc=System.getProperty("user.dir");
		FileInputStream fis=new FileInputStream(currentLoc+"/TestData/ConstantValues.properties");
		prop.load(fis);
		
    	Excel excel=new Excel(prop.getProperty("xlPath"));
    	Object[][] data=new Object[3][2];
    	data[0][0] = excel.getCellData("invalidCredentials", 1, 0);
    	data[0][1] = excel.getCellData("invalidCredentials", 1, 1);
    	
    	data[1][0] = excel.getCellData("invalidCredentials", 2, 0);
    	data[1][1] = excel.getCellData("invalidCredentials", 2, 1);
    	
    	data[2][0] = excel.getCellData("invalidCredentials", 3, 0);
    	data[2][1] = excel.getCellData("invalidCredentials", 3, 1);
    	
    	return data;
    
    }
}
