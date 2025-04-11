package StudentManagementSystemwithOOPs;

public final class Teacher extends Person{

    private String empID;
    private String subject;
    private int yearsOfExperience;
    private double salary;

    private static final double BASE_SALARY = 30000;
    private static final double EXPERIENCE_BONUS = 2000;
    private static int TEACHER_COUNTER = 0;

    public Teacher(String name, int age, String phoneNumber, String address, String empID, String subject, int yearsOfExperience) {
        super(name, age, phoneNumber, address);
        if (validateAge(age) && validateEmpID(empID) && validateSubject(subject) && validateYearsOfExperience(yearsOfExperience)) {
            this.empID = empID;
            this.subject = subject;
            this.yearsOfExperience = yearsOfExperience;
            calculateSalary();      // This method will be executed automatically when constructor is called no need to call this explicitly in runner class once it is added like this constructor
            TEACHER_COUNTER++;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(validateAge(age)){
            this.age = age;
        }
    }

    public boolean validateAge(int age) {
        if (age >= 21 && age <= 65) {
            return true;
        } else {
            System.err.println("Given Invalid Teacher Age - Age must be between 21 and 10");
            return false;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(validatePhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.matches("\\d{10}") ) {
            return true;
        }
        else {
            System.err.println("Given Invalid Phone Number - Phone Number must be 10 digits");
            return false;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (validateAddress(address)){
            this.address = address;
        }
    }

    public boolean validateAddress(String address) {
        if (address.isEmpty() || address == null){
            System.err.println("Given Invalid Address - Address should not be empty");
            return false;
        }
        else {
            return true;
        }
    }

    public String getEmpID() {
        return empID;
    }

    public boolean validateEmpID(String empID) {
        if (empID.matches("T\\d{3}")) {
            return true;
        } else {
            System.err.println("Given Invalid EmpID - ");
            return false;
        }
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        if (validateSubject(subject)) {
            this.subject = subject;
        }
    }

    public boolean validateSubject(String subject) {
        if (!subject.isEmpty()) {
            return true;
        } else {
            System.err.println("Given Invalid Subject - Subject cannot be empty");
            return false;
        }
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        if(validateYearsOfExperience(yearsOfExperience)) {
            this.yearsOfExperience = yearsOfExperience;
        }
    }

    public boolean validateYearsOfExperience(int yearsOfExperience) {
        if (yearsOfExperience >= 0 && yearsOfExperience <= 35) {
            return true;
        } else {
            System.err.println("Given Invalid Teacher YearsOfExperience - YearsOfExperience must be between 0 and 35");
            return false;
        }
    }

    protected final void calculateSalary() {
        salary = BASE_SALARY + (yearsOfExperience * EXPERIENCE_BONUS);
    }

    public void displayTeacherInfo() {

        System.out.println("==================================================");
        System.out.println("-----Teacher Info-----");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Employee ID: " + empID);
        System.out.println("Subject: " + subject);
        System.out.println("Years of Experience: " + yearsOfExperience);
        System.out.println("-----Calculate Salary-----");
        System.out.println("Salary: " + "$" + salary);
        System.out.println("==================================================");
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", empID='" + empID + '\'' +
                ", subject='" + subject + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                ", salary=" + salary +
                '}';
    }
    public boolean updateInformation(String newPhoneNumber, String newAddress){
        //Need HR Approval
        System.out.println("Requesting HR Approval");
        boolean approval = hRApproval();
        if(approval) {
            if (super.updateInformation(newPhoneNumber, newAddress)) {
                System.out.println("Notifying Teacher that info is Updated Successfully");
                return true;
            }
        }
        return false;
    }

    public boolean updateInformation(String newAddress){
        //Need HR Approval
        System.out.println("Requesting HR Approval");
        boolean approval = hRApproval();
        if(approval) {
            if (super.updateInformation(newAddress)) {
                System.out.println("Notifying Teacher that info is Updated Successfully");
                return true;
            }
        }
        return false;
    }

    public boolean updateInformation(String newPhoneNumber, boolean update){
        //Need HR Approval
        System.out.println("Requesting HR Approval");
        boolean approval = hRApproval();
        if(approval) {
            if (super.updateInformation(newPhoneNumber, update)) {
                System.out.println("Notifying Teacher that info is Updated Successfully");
                return true;
            }
        }
        return false;
    }

    public static int getTotalTeacherCount() {
        return TEACHER_COUNTER;
    }

    public boolean hRApproval(){
        System.out.println("HR provided Approval");
        return true;
    }
}

