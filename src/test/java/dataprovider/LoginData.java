package dataprovider;

import org.testng.annotations.DataProvider;

import utilities.ExcelUtils;

public class LoginData {

    @DataProvider(name="LoginData")

    public Object[][] getData() throws Exception {

        ExcelUtils excel =

                new ExcelUtils(
                        "src/test/resources/TestData.xlsx");

        int rows = excel.getRowCount("Login");

        int cols = excel.getCellCount("Login");

        Object data[][] = new Object[rows][cols];

        for(int i=1;i<=rows;i++) {

            for(int j=0;j<cols;j++) {

                data[i-1][j] =

                        excel.getCellData("Login", i, j);

            }

        }

        return data;

    }

}