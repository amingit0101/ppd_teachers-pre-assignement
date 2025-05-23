package service.collegedean;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.collegedean.*;


public class Managment_Class {
    String url = "jdbc:mysql://localhost:3306/ppd";
    String username = "root";
    String dbPassword = "someonedhry@123";
    public void addUser(User user){
        
        String sql = "INSERT INTO users (user_id, password, account_type,persone_id) VALUES (?, ?, ?,?)";
        try (Connection conn = DriverManager.getConnection(url, username, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getUser_type());
            stmt.setInt(4, user.getPersone_id());
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User inserted successfully!");
            }
            
   
    }
    catch (SQLException e) {
        e.printStackTrace();
    }
    }
    public void addDepatmentDean(Departement_Dean departement_dean){
        String sql =  "INSERT INTO departement_dean (DD_ID, personal_info, User_account) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, username, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, departement_dean.getId());
            stmt.setInt(2, departement_dean.getPersonel_info());
            stmt.setInt(3, departement_dean.getUser_id());
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Departement Dean inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updatestatus(int status){
        String sql = "UPDATE college_dean SET Status = ? WHERE CD_ID = 0";
        try (Connection conn = DriverManager.getConnection(url, username, dbPassword);
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, status);
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("status updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setdepratment(int id,int dep_id){
        deleteDeandep(dep_id) ;
        String sql = "UPDATE departement SET DD_id = ? WHERE D_ID = ?";
        try (Connection conn = DriverManager.getConnection(url, username, dbPassword);
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setInt(2, dep_id);
            int rowsInserted = stmt.executeUpdate();
            System.out.println("id : "+ id);
            System.out.println("dep_id : "+ dep_id);
            if (rowsInserted > 0) {
                System.out.println("status updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int check(int id) {
        String sql = "SELECT DD_id FROM departement WHERE D_id = ?";
        try (Connection conn = DriverManager.getConnection(url, username, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
    
            if (rs.next()) {
                int dd_id = rs.getInt("DD_id");
                if (rs.wasNull()) {
                    return -1; 
                } else {
                    return dd_id;
                }
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return -1; 
    }
    public void deleteDeandep(int id) {
        int dd_id = check(id) ;
        if(dd_id == -1){
            System.out.println("this departement has no dean");
            return ; 
        }
        else{
            String sql = "DELETE FROM departement_dean WHERE DD_ID = ?";
            try (Connection conn = DriverManager.getConnection(url, username, dbPassword);
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, dd_id);
                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Departement Dean deleted successfully!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public List<String> getdepartemenname() {
        String sql = "SELECT D_name FROM departement";
        List<String> departementNames = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, dbPassword);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                departementNames.add(rs.getString("D_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departementNames;
    }
    public int getDD_ID(int personal_info){
        String sql = "SELECT DD_ID FROM departement_dean dn JOIN persone p ON dn.personal_info = p.Person_id WHERE p.Person_id = ?";
        try (Connection conn = DriverManager.getConnection(url, username, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, personal_info);
            ResultSet rs = stmt.executeQuery();
            System.out.println("get DD : "+ personal_info);
            if (rs.next()) {
                System.out.println("DD_ID: " + rs.getInt("DD_ID"));
                return rs.getInt("DD_ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1 ; 
    }
    public String getDepartement(int id) {
        String sql = "SELECT D_name FROM departement WHERE DD_id = ?";
        try (Connection conn = DriverManager.getConnection(url, username, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            System.out.println("get dep");
            System.out.println("id: " + id);

            if (rs.next()) {
                System.out.println("D_name: " + rs.getString("D_name"));
                return rs.getString("D_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }
    public Persone  getPersonByEmail(String email) {
        String sql = "SELECT * FROM persone WHERE email = ?";
        try (Connection conn = DriverManager.getConnection(url, username, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Persone persone = new Persone(rs.getString("name"), rs.getString("Phone"), rs.getString("email"), rs.getDate("birthday").toLocalDate(), rs.getInt("diplome_id"));
                persone.setId(rs.getInt("Person_id"));
                return persone;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }

    public String getPassword(String email){
        Persone persone = getPersonByEmail(email) ; 
        String sql = "SELECT u.password FROM users u JOIN persone p ON u.persone_id = p.Person_id WHERE p.Person_id = ?" ; 
        try (Connection conn = DriverManager.getConnection(url, username, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, persone.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1)  ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }
    public void addPerson(Persone persone){
        String sql =  "INSERT INTO persone (Person_id, name, Phone, birthday, email, diplome_id)  VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, username, dbPassword);
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, persone.getId());
            stmt.setString(2, persone.getNome());
            stmt.setString(3, persone.getPhone());
            stmt.setDate(4, java.sql.Date.valueOf(persone.getBithday()));
            stmt.setString(5, persone.getEmail());
            stmt.setInt(6, persone.getDeplome_id());
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Departement Dean inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean emailExists(String email) {
        String query = "SELECT 1 FROM persone WHERE email = ? LIMIT 1";

        try (Connection conn = DriverManager.getConnection(url, username, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); 

        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }

    public void updateDepartementdean(Persone persone,User user,Departement_Dean dean){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, username, dbPassword);
            conn.setAutoCommit(false); 

            String sql1 = "SELECT Person_id FROM persone WHERE email = ?";
            stmt = conn.prepareStatement(sql1);
            stmt.setString(1, persone.getEmail());
            rs = stmt.executeQuery();

            if (!rs.next()) {
                System.out.println("persone with this email not found!");
                return;
            }

            int personId = rs.getInt("Person_id");
            rs.close();
            stmt.close();

            String sql2 = "SELECT User_account FROM departement_dean WHERE personal_info = ?";
            stmt = conn.prepareStatement(sql2);
            stmt.setInt(1, personId);
            rs = stmt.executeQuery();

            int userId = -1;
            if (rs.next()) {
                userId = rs.getInt("User_account");
            }

            rs.close();
            stmt.close();

            // 3. حذف من departement_dean
            String deleteDean = "DELETE FROM departement_dean WHERE personal_info = ?";
            stmt = conn.prepareStatement(deleteDean);
            stmt.setInt(1, personId);
            stmt.executeUpdate();
            stmt.close();

            // 4. حذف من users إن وجد
            if (userId != -1) {
                String deleteUser = "DELETE FROM users WHERE user_id = ?";
                stmt = conn.prepareStatement(deleteUser);
                stmt.setInt(1, userId);
                stmt.executeUpdate();
                stmt.close();
            }

            // 5. حذف من persone
            String deletePerson = "DELETE FROM persone WHERE Person_id = ?";
            stmt = conn.prepareStatement(deletePerson);
            stmt.setInt(1, personId);
            stmt.executeUpdate();
            stmt.close();

            conn.commit(); // تنفيذ المعاملة
            addPerson(persone);
            addUser(user);
            addDepatmentDean(dean);            

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback(); // التراجع إذا حصل خطأ
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }
    }
    public int getLastPersoneID(){
        String sql = "select * from persone" ; 
        try (Connection conn = DriverManager.getConnection(url, username, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                rs.last() ;
                return rs.getInt("Person_id") ; 
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; 
    }
    public int getLastUserID(){
        String sql = "select * from users" ; 
        try (Connection conn = DriverManager.getConnection(url, username, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                rs.last() ;
            return rs.getInt("user_id") ; 
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; 
    }
    public int getLastIDepDeanID(){
        String sql = "select * from departement_dean" ; 
        try (Connection conn = DriverManager.getConnection(url, username, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                rs.last() ;
            return rs.getInt("DD_ID") ; 
            }   
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; 
    }
    public List<deplome> getalldeplomes() {
        List<deplome> diplomes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, dbPassword)) {
            String query = "SELECT dep_id, dep_name FROM diplome";
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                
                while (rs.next()) {
                    int depId = rs.getInt("dep_id");
                    String depName = rs.getString("dep_name");
                    diplomes.add(new deplome(depId, depName)); 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return diplomes;
    }
}