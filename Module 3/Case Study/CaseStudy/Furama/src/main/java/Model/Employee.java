package Model;

public class Employee {
    private int employee_id;
    private String employee_name;
    private String employee_birthday;
    private String employee_id_card;
    private String employee_phone;
    private String employee_email;
    private String employee_degree;
    private String position_id;
    private String employee_salary;

    public Employee(int employee_id, String employee_name, String employee_birthday, String employee_id_card, String employee_phone, String employee_email, String employee_degree, String position_id, String employee_salary) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_birthday = employee_birthday;
        this.employee_id_card = employee_id_card;
        this.employee_phone = employee_phone;
        this.employee_email = employee_email;
        this.employee_degree = employee_degree;
        this.position_id = position_id;
        this.employee_salary = employee_salary;
    }

    public Employee(String name, String birthday, String cardID, String phone, String email, String degree, String position, String salary) {
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_birthday() {
        return employee_birthday;
    }

    public void setEmployee_birthday(String employee_birthday) {
        this.employee_birthday = employee_birthday;
    }

    public String getEmployee_id_card() {
        return employee_id_card;
    }

    public void setEmployee_id_card(String employee_id_card) {
        this.employee_id_card = employee_id_card;
    }

    public String getEmployee_phone() {
        return employee_phone;
    }

    public void setEmployee_phone(String employee_phone) {
        this.employee_phone = employee_phone;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public String getEmployee_degree() {
        return employee_degree;
    }

    public void setEmployee_degree(String employee_degree) {
        this.employee_degree = employee_degree;
    }

    public String getPosition_id() {
        return position_id;
    }

    public void setPosition_id(String position_id) {
        this.position_id = position_id;
    }

    public String getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(String employee_salary) {
        this.employee_salary = employee_salary;
    }
}
