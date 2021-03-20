package database;

import java.sql.*;

public class DbConnectivity{
    private String url = "jdbc:mysql://localhost:3306/Practical";
    private String uname = "root";
    private String pass = "";
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public void add(int rollno, String name, String mobile, String email){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, uname, pass);
            String query = "insert into Student(ROLLNO, NAME, MOBILE, EMAIL) values (?,?,?,?)";
            PreparedStatement p = con.prepareStatement(query);
            p.setInt(1,rollno);
            p.setString(2,name);
            p.setString(3,mobile);
            p.setString(4, email);
            p.executeUpdate();
            System.out.println("Record is Inserted...");
            con.close();
        }catch (Exception e){
            System.out.println("Something went wrong Record is not inserted...");
            System.out.println("Refer the following error : " + e);
        }

    }

    public void update(int rollno, String name, String mobile, String email){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, uname, pass);
            String query = "update Student set NAME = ?, MOBILE = ?, EMAIL = ? where ROLLNO = ?";
            PreparedStatement p = con.prepareStatement(query);
            p.setString(1,name);
            p.setString(2,mobile);
            p.setString(3,email);
            p.setInt(4, rollno);
            p.executeUpdate();
            System.out.println("Record is Updated...");
            con.close();
        }catch (Exception e){
            System.out.println("Something went wrong Record is not Updated...");
            System.out.println("Refer the following error : " + e);
        }
    }

    public void viewByRollNo(int rollNo){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, uname, pass);
            String query = "select * from Student where ROLLNO = "+rollNo;
            st = con.createStatement();
            rs = st.executeQuery(query);

            while(rs.next()){
                System.out.print("RollNo -> "+ rs.getInt(1) );
                System.out.print(" Name -> "+ rs.getString(2) );
                System.out.print(" Mobile -> "+ rs.getString(3) );
                System.out.print(" Email -> "+ rs.getString(4) );
                System.out.println();
            }
            con.close();
        }catch (Exception e){
            System.out.println("Something went wrong...");
            System.out.println("Refer the following error : " + e);
        }
    }

    public void showAllRecord(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, uname, pass);
            String query = "select * from Student";
            st = con.createStatement();
            rs = st.executeQuery(query);

            System.out.println("--------------List of Students----------------");
            while(rs.next()){
                System.out.print("RollNo -> "+ rs.getInt(1));
                System.out.print(" Name -> "+ rs.getString(2) );
                System.out.print(" Mobile -> "+ rs.getString(3) );
                System.out.print(" Email -> "+ rs.getString(4) );
                System.out.println();
            }

            con.close();
        }catch (Exception e){
            System.out.println("Something went wrong...");
            System.out.println("Refer the following error : " + e);
        }
    }

}
