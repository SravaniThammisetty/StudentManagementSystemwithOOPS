package StudentManagementSystemwithOOPs;

public class SportsStudent extends Student{

    private double sportsScore;

    private SportsStudent(StudentBuilder studentBuilder) {
        super(studentBuilder);
        this.sportsScore = ((SportsStudentBuilder) studentBuilder).sportsScore;
        percentage = calculatePercentage();
        grade = calculateGrade();
    }

    @Override
    public double calculatePercentage() {
        double academicPercentage = getTotalMarks()/3.0;
        double finalPercentage = (academicPercentage * 0.8) + (sportsScore * 0.2) ;
        return finalPercentage;
    }

    public static class SportsStudentBuilder extends StudentBuilder{

        private double sportsScore;

        public SportsStudentBuilder (String name, int age, String phoneNumber, String address) {
            super(name,age,phoneNumber,address);

        }

        public SportsStudentBuilder withSportsScore(double sportsScore) {
            if(sportsScore >= 0 && sportsScore <= 100){
                this.sportsScore = sportsScore;
            }
            return this;
        }

        @Override
        public Student build() {
            Student spostudent = new SportsStudent(this);
            return spostudent;
        }


    }


}
