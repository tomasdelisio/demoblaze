package data;

import org.testng.annotations.DataProvider;
import utils.ExcelUtils;
import java.io.File;

public class Data {
    /*** VARIABLES ***/
    private static final String base_path = System.getProperty("user.dir") 
        + File.separator + "src" 
        + File.separator + "test" 
        + File.separator + "resources" 
        + File.separator + "data";

    /*** METHODS ***/
    // Read Excel
    public Object[][] data(String path, String sheet) {
        new ExcelUtils(path, sheet);

        int row_count = ExcelUtils.getRowCount();
        int col_count = ExcelUtils.getColCount();

        Object[][] dt = new Object[row_count - 1][col_count];

        for (int i = 1; i < row_count; i++) {
            for (int j = 0; j < col_count; j++) {
                String cell_data = ExcelUtils.getCellData(i, j);
                dt[i - 1][j] = cell_data;
            }
        }

        return dt;
    }

    // Login Cases
    @DataProvider(name = "Login")
    public Object[][] getDataLogin() {
        return data(base_path + File.separator + "login" + File.separator + "login.xlsx", "Data");
    }

    @DataProvider(name = "LoginUsernameIncorrect")
    public Object[][] getDataLoginUsrIncorrect() {
        return data(base_path + File.separator + "login" + File.separator + "loginUsernameIncorrect.xlsx", "Data");
    }

    @DataProvider(name = "LoginPasswordIncorrect")
    public Object[][] getDataLoginPassIncorrect() {
        return data(base_path + File.separator + "login" + File.separator + "loginPasswordIncorrect.xlsx", "Data");
    }

    @DataProvider(name = "LoginUsernameOrPasswordNull")
    public Object[][] getDataLoginUsrOrPassNull() {
        return data(base_path + File.separator + "login" + File.separator + "loginUsernameOrPasswordNull.xlsx", "Data");
    }

    @DataProvider(name = "LoginUsernameAndPasswordNull")
    public Object[][] getDataLoginUsrAndPassNull() {
        Object[][] dt = data(base_path + File.separator + "login" + File.separator + "loginUsernameAndPasswordNull.xlsx", "Data");
        if (dt == null || dt.length == 0) {
            dt = new Object[][]{{"", ""}};
        }
        return dt;
    }

    @DataProvider(name = "LoginAPI")
    public Object[][] getDataLoginAPI() {
        return data(base_path + File.separator + "loginAPI" + File.separator + "login.xlsx", "Data");
    }

    @DataProvider(name = "LoginUsernameIncorrectAPI")
    public Object[][] getDataLoginUsrIncorrectAPI() {
        return data(base_path + File.separator + "login" + File.separator + "loginUsernameIncorrect.xlsx", "Data");
    }

    @DataProvider(name = "LoginPasswordIncorrectAPI")
    public Object[][] getDataLoginPassIncorrectAPI() {
        return data(base_path + File.separator + "login" + File.separator + "loginPasswordIncorrect.xlsx", "Data");
    }

    // Register Cases
    @DataProvider(name = "Register")
    public Object[][] getDataRegister() {
        return data(base_path + File.separator + "register" + File.separator + "register.xlsx", "Data");
    }

    @DataProvider(name = "RegisterUsernameExistent")
    public Object[][] getDataRegisterUsrExistent() {
        return data(base_path + File.separator + "register" + File.separator + "registerUsernameExistent.xlsx", "Data");
    }

    @DataProvider(name = "RegisterUsernameOrPasswordNull")
    public Object[][] getDataRegisterUsrOrPassNull() {
        return data(base_path + File.separator + "register" + File.separator + "registerUsernameOrPasswordNull.xlsx", "Data");
    }

    @DataProvider(name = "RegisterUsernameAndPasswordNull")
    public Object[][] getDataRegisterUsrAndPassNull() {
        Object[][] dt = data(base_path + File.separator + "register" + File.separator + "registerUsernameAndPasswordNull.xlsx", "Data");
        if (dt == null || dt.length == 0) {
            dt = new Object[][]{{"", ""}};
        }
        return dt;
    }
}
