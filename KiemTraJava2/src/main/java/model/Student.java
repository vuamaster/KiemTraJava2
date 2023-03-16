package model;

public class Student implements Comparable<Student> {
    private String id;
    private String fullName;
    private int gender;
    private String birthDay;
    private String address;
    private String phone;
    private String email;
    private double diemGPA;

    public Student() {
    }

    public Student(String id, String fullName, int gender, String birthDay, String address, String phone, String email, double diemGPA) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.birthDay = birthDay;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.diemGPA = diemGPA;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getDiemGPA() {
        return diemGPA;
    }

    public void setDiemGPA(double diemGPA) {
        this.diemGPA = diemGPA;
    }

    @Override
    public int compareTo(Student o) {
        if(this.diemGPA > o.diemGPA){
            return 1;
        } else if (this.diemGPA<o.diemGPA) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Student[" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", gender=" + gender +
                ", birthDay='" + birthDay + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", diemGPA=" + diemGPA +
                ']';
    }
}
