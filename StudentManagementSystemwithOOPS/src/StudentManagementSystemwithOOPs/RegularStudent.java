package StudentManagementSystemwithOOPs;

public class RegularStudent extends Student{

    protected RegularStudent(StudentBuilder studentBuilder){
        super(studentBuilder);
        percentage = calculatePercentage();
        grade = calculateGrade();
    }

    @Override
    public double calculatePercentage() {
        double percentage = totalMarks / 3.0;
        return percentage;
    }

    public static class RegularStudentBuilder extends StudentBuilder{

        public RegularStudentBuilder(String name, int age, String phoneNumber, String address){
            super(name, age, phoneNumber, address);
        }

        @Override
        public Student build() {
            Student regstudent = new RegularStudent(this);
            return regstudent;
        }


    }
}
