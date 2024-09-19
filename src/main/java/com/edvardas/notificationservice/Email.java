package Email;

import lombok.Data;

import java.util.Scanner;

@Data
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String department;
    private int mailboxCapacity;
    private int defaultPasswordLength;
    private String alternateEmail;
    private String CompanySuffix = "aeycompany.com";

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.department = setDepartment();

        this.defaultPasswordLength = 8;

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + CompanySuffix;
    }

    private String setDepartment() {
        System.out.print("Department Codes: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter Department Code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        return switch (depChoice) {
            case 1 -> Department.SALES.toString().toLowerCase();
            case 2 -> Department.DEVELOPMENT.toString().toLowerCase();
            case 3 -> Department.ACCOUNTING.toString().toLowerCase();
            default -> "";
        };
    }



    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName + "\n" +
                "COMPANY EMAIL: " + email + "\n" +
                "MAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }


}
