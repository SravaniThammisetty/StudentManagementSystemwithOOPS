package StudentManagementSystemwithOOPs;

public class Runner {
    public static void main(String[] args) {
//        Person p1 = new Person("Srav",20,"9182121778","Tadipatri");
//        System.out.println(p1);
//
//        Student s1 = new Student("Sravani",18,"9182121778","Tadipatri",98,85,87,76);
//        s1.calculateTotalMarks();
//        s1.calculatePercentage();
//        s1.calculateGrade();
//        s1.displayStudentInfo();
//        s1.updateInformation("9391500007","Bangalore");
//        s1.displayStudentInfo();
//        s1.updateInformation("Mumbai");
//        s1.displayStudentInfo();
//
//        Teacher t1 = new Teacher("Tammisetty",24,"9949900908","Tadipatri","T107","Maths",3);
//        t1.displayTeacherInfo();
//        t1.updateInformation("8008397772","Ananthapur");
//        t1.displayTeacherInfo();
//        t1.updateInformation("Thane");
//        t1.displayTeacherInfo();
//
//        System.out.println(Person.getTotalPersonCount());
//        System.out.println(Student.getTotalStudentCount());
//        System.out.println(Teacher.getTotalTeacherCount());


        // After builder design pattern
//
//        Student student = new Student.StudentBuilder("Sravani", 15, "9182121778", "Tadpatri")
//                .withMarksObtainedInEnglish(92)
//                .withMarksObtainedInMaths(95)
//                .withMarksObtainedInScience(90)
//                .withRollNumber(28)
//                .build();
//        System.out.println(student);
//        student.displayStudentInfo();




        Student s1 = new RegularStudent.RegularStudentBuilder("srav",18,"1234567890","tad")
                .withRollNumber(24).withMarksObtainedInEnglish(85)
                .withMarksObtainedInMaths(88).withMarksObtainedInScience(90).build();
        s1.displayStudentInfo();

        Student s2 = new SportsStudent.SportsStudentBuilder("tam",18,"1234567891","tadi")
                .withSportsScore(89).withRollNumber(24).withMarksObtainedInEnglish(85)
                .withMarksObtainedInMaths(88).withMarksObtainedInScience(90).build();

        s2.displayStudentInfo();

    }
}
