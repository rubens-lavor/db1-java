package application;

import original.PasswordMeterV1;

import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        PasswordMeterV1 password = new PasswordMeterV1();
        password.checkPassword("12*35*6a");
        System.out.print(password.toString());
    }
}
