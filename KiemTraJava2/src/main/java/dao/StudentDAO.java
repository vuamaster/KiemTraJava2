package dao;

import connection.MyConnection;
import model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public List<Student> getAll(){
        final String sql = "SELECT * FROM `students`";
        List<Student> studentList = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Student s = new Student();
                s.setId(rs.getString("id"));
                s.setFullName(rs.getString("full_name"));
                s.setGender(rs.getInt("gender"));
                s.setBirthDay(rs.getString("birth_day"));
                s.setAddress(rs.getString("address"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setDiemGPA(rs.getDouble("diemGPA"));
                studentList.add(s);
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return studentList;
    }
    public Student getBuyId (String id){
        final String sql = "SELECT * FROM `students` WHERE `id` ="+"'"+id+"'";
        Student s = null;
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                s = new Student();
                s.setId(rs.getString("id"));
                s.setFullName(rs.getString("full_name"));
                s.setGender(rs.getInt("gender"));
                s.setBirthDay(rs.getString("birth_day"));
                s.setAddress(rs.getString("address"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setDiemGPA(rs.getDouble("diemGPA"));
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }
    public void insert(Student s){
        final  String sql =String.format("INSERT INTO `students` (`id`, `full_name`, `gender`, `birth_day`, `address`, `phone`, `email`, `diemGPA`) VALUES ('%s', '%s', '%d', '%s', '%s', '%s', '%s', '%f')",
                s.getId(),s.getFullName(), s.getGender(), s.getBirthDay(),s.getAddress(),s.getPhone(),s.getEmail(),s.getDiemGPA()
                );
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);
            if (rs == 0){
                System.out.println("thêm thất bại");
            }
            stmt.close();
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(Student s, String id){
        Student tmp = getBuyId(id);
        if(tmp == null){
            throw new RuntimeException("sinh viên không tồn tại!");
        }
        final String sql = String.format("UPDATE `students` SET `full_name` = '%s', `gender` = '%d', `birth_day` = '%s', `address` = '%s', `phone` = '%s', `email` = '%s', `diemGPA` = '%f' WHERE (`id` = '%s')",
                s.getFullName(),s.getGender(),s.getBirthDay(),s.getAddress(),s.getPhone(),s.getEmail(),s.getDiemGPA(),id
                );
        System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);
            if (rs == 0){
                System.out.println("Cập nhật thất bại");
            }
            stmt.close();
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delete(String id){
        Student s = getBuyId(id);
        if (s == null){
            throw new RuntimeException("sinh viên không tồn tại!");
        }
        final String sql = "DELETE FROM `students` WHERE `id` = "+"'"+id+"'";
        System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);
            if (rs == 0){
                System.out.println("xóa thất bại!");
            }
            stmt.close();
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
