package StudentManagementSystemwithOOPs;

public abstract class Person {
    protected String name;
    protected int age;
    protected String phoneNumber;
    protected String address;

    private static int PERSON_COUNTER = 0;

    public Person(String name, int age, String phoneNumber, String address) {
        {
            this.name = name;
            this.age = age;
            this.phoneNumber = phoneNumber;
            this.address = address;
            PERSON_COUNTER++;

        }
    }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }

        public int getAge () {
            return age;
        }

        public void setAge ( int age){
            this.age = age;
        }

        public String getPhoneNumber () {
            return phoneNumber;
        }

        public void setPhoneNumber (String phoneNumber){
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

        public String getAddress () {
            return address;
        }

        public void setAddress (String address){
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


        protected boolean updateInformation (String newPhoneNumber, String newAddress){
            if (validateAddress(newAddress) && validatePhoneNumber(newPhoneNumber)) {
                this.address = newAddress;
                this.phoneNumber = newPhoneNumber;
                System.out.println("Updated with new Address and phone number");
                return true;
            } else {
                System.err.println("Give Valid Address and Phone Number");
                return false;
            }
        }

        protected boolean updateInformation (String newAddress){
            if (validateAddress(newAddress)) {
                this.address = newAddress;
                System.out.println("Updated with new Address");
                return true;
            } else {
                System.err.println("Give Valid Address");
                return false;
            }
        }

        protected boolean updateInformation (String newPhoneNumber,boolean update){
            if (validatePhoneNumber(newPhoneNumber)) {
                this.phoneNumber = newPhoneNumber;
                System.out.println("Updated with phone number");
                return true;
            } else {
                System.err.println("Give Phone Number");
                return false;
            }
        }

        public static int getTotalPersonCount () {
            return PERSON_COUNTER;
        }

        @Override
        public String toString () {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

