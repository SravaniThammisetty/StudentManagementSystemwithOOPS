package StudentManagementSystemwithOOPs;

// Perfect example for Builder Design Pattern

import java.util.Objects;

public abstract class Student extends Person {

    private final int rollNumber;
    private final double marksObtainedInEnglish;
    private final double marksObtainedInMaths;
    private final double marksObtainedInScience;
    protected final double totalMarks;
    protected double percentage;
    protected String grade;

    private static int STUDENT_COUNTER = 0;

    protected Student(StudentBuilder studentBuilder) {
        super(studentBuilder.name, studentBuilder.age, studentBuilder.phoneNumber, studentBuilder.address);
        this.rollNumber = studentBuilder.rollNumber;
        this.marksObtainedInEnglish = studentBuilder.marksObtainedInEnglish;
        this.marksObtainedInMaths = studentBuilder.marksObtainedInMaths;
        this.marksObtainedInScience = studentBuilder.marksObtainedInScience;
        totalMarks = calculateTotalMarks();
        STUDENT_COUNTER++;

    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double getMarksObtainedInEnglish() {
        return marksObtainedInEnglish;
    }

    public double getMarksObtainedInMaths() {
        return marksObtainedInMaths;
    }

    public double getMarksObtainedInScience() {
        return marksObtainedInScience;
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getGrade() {
        return grade;
    }


    public final double calculateTotalMarks(){
        double totalMarks = marksObtainedInEnglish + marksObtainedInMaths + marksObtainedInScience;
        return totalMarks;
    }

    public abstract double calculatePercentage();

    public final String calculateGrade(){
        String grade;
        if(percentage == 0){
            grade = "Couldn't calculate grade";
        }
        else {
            grade = GradePolicy.calculateGrade(percentage);
        }
        return grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNumber == student.rollNumber && Double.compare(marksObtainedInEnglish, student.marksObtainedInEnglish) == 0 && Double.compare(marksObtainedInMaths, student.marksObtainedInMaths) == 0 && Double.compare(marksObtainedInScience, student.marksObtainedInScience) == 0 && Double.compare(totalMarks, student.totalMarks) == 0 && Double.compare(percentage, student.percentage) == 0 && Objects.equals(grade, student.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, rollNumber, marksObtainedInEnglish, marksObtainedInMaths, marksObtainedInScience, totalMarks, percentage, grade);
    }

    public void displayStudentInfo(){

        System.out.println("==================================================");
        System.out.println("-----Student Info-----");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks Obtained: " + marksObtainedInEnglish);
        System.out.println("Marks Obtained: " + marksObtainedInMaths);
        System.out.println("Marks Obtained: " + marksObtainedInScience);
        System.out.println("-----Caluculating Grade-----");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Percentage: " + percentage);
        System.out.println("Grade: " + grade);
        System.out.println("==================================================");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", rollNumber=" + rollNumber +
                ", marksObtainedInEnglish=" + marksObtainedInEnglish +
                ", marksObtainedInMaths=" + marksObtainedInMaths +
                ", marksObtainedInScience=" + marksObtainedInScience +
                ", totalMarks=" + totalMarks +
                ", percentage=" + percentage +
                ", grade='" + grade + '\'' +
                '}';
    }

    public boolean updateInformation(String newPhoneNumber, String newAddress){
        //Need Parent Approval
        System.out.println("Requesting Parent Approval");
        boolean approval = parentApproval();
        if(approval) {
            if (super.updateInformation(newPhoneNumber, newAddress)) {
                System.out.println("Notifying the Parent about successful update of Information..........");
                return true;
            } else {
                System.err.println("Parent didn't approve for information update...........");
                return false;
            }
        }
        return false;
    }

    public boolean updateInformation(String newAddress){
        //Need Parent Approval
        System.out.println("Requesting Parent Approval");
        boolean approval = parentApproval();
        if(approval) {
            if (super.updateInformation(newAddress)) {
                System.out.println("Notifying the Parent about successful update of Information.............");
                return true;
            } else {
                System.err.println("Parent didn't approve for information update..............");
                return false;
            }
        }
        return false;
    }

    public boolean updateInformation(String newPhoneNumber, boolean update){
        //Need Parent Approval
        System.out.println("Requesting Parent Approval");
        boolean approval = parentApproval();
        if(approval) {
            if (super.updateInformation(newPhoneNumber, update)) {
                System.out.println("Notifying the Parent about successful update of Information.........");
                return true;
            } else {
                System.err.println("Parent didn't approve for information update...........");
                return false;
            }
        }
        return false;
    }

    public boolean parentApproval(){
        return true;
    }

    public static int getTotalStudentCount() {
        return STUDENT_COUNTER;
    }


    public abstract static class StudentBuilder {
        //mandatory fields
        private String name;
        private int age;
        private String phoneNumber;
        private String address;

        //optional fields
        private int rollNumber;
        private double marksObtainedInEnglish;
        private double marksObtainedInMaths;
        private double marksObtainedInScience;

        public StudentBuilder(String name, int age, String phoneNumber, String address) {

            if(validateAge(age) && validatePhoneNumber(phoneNumber) && validateAddress(address)) {
                this.name = name;
                this.age = age;
                this.phoneNumber = phoneNumber;
                this.address = address;
            }
        }

        public StudentBuilder withRollNumber(int rollNumber) {
            if(validateRollNumber(rollNumber)) {
                this.rollNumber = rollNumber;
            }
            return this;
        }

        public StudentBuilder withMarksObtainedInEnglish(double marksObtainedInEnglish) {
            if(validateMarks(marksObtainedInEnglish)) {
                this.marksObtainedInEnglish = marksObtainedInEnglish;
            }
            return this;
        }

        public StudentBuilder withMarksObtainedInMaths(double marksObtainedInMaths) {
            if(validateMarks(marksObtainedInMaths)) {
                this.marksObtainedInMaths = marksObtainedInMaths;
            }
            return this;
        }

        public StudentBuilder withMarksObtainedInScience(double marksObtainedInScience) {
            if(validateMarks(marksObtainedInScience)) {
                this.marksObtainedInScience = marksObtainedInScience;
            }
            return this;
        }

        public abstract Student build();

        private boolean validateAge(int age) {
            if (age < 21 && age > 10) {
                return true;
            }
            else{
                System.err.println("Given Invalid Age - Age must be between 21 and 10");
                return false;
            }
        }

        private boolean validatePhoneNumber(String phoneNumber) {
            if (phoneNumber != null && phoneNumber.matches("\\d{10}") ) {
                return true;
            }
            else {
                System.err.println("Given Invalid Phone Number - Phone Number must be 10 digits");
                return false;
            }
        }

        private boolean validateAddress(String address) {
            if (address.isEmpty() || address == null){
                System.err.println("Given Invalid Address - Address should not be empty");
                return false;
            }
            else {
                return true;
            }
        }

        private boolean validateRollNumber(int rollNumber) {
            if (rollNumber <= 100 && rollNumber >= 1) {
                return true;
            }
            else{
                System.err.println("Given Invalid Roll Number - Roll Number must be between 100 and 1");
                return false;
            }
        }

        private boolean validateMarks(double Marks) {
            if (Marks <= 100 && Marks >= 0) {
                return true;
            }
            else {
                System.err.println("Given Invalid Marks - Marks must be between 100 and 100");
                return false;
            }
        }
    }
}
