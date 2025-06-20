package C1221165_50.demo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.CollationKey;
import java.util.Collection;

@Service
public class orderService {
    private final JdbcTemplate jdbc;
    String sqlQuery;


    public orderService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // operations
    //get All Students
    public Collection<order> getAllStudents(){
        sqlQuery="select * from students";
        return jdbc.query(sqlQuery,new BeanPropertyRowMapper<>(order.class));
    }


    // create student
    public void createStudent(order std){
        sqlQuery="insert into students values(? , ? , ? , ? , ?)";
        jdbc.update(sqlQuery,std.getOrderId(),std.getOrderName(),std.getPrice());
    }



    public void updateStudent(order std, int orderId){
        sqlQuery="update students set orderID=?, orderNaame=?,price=?";
        jdbc.update(sqlQuery,std.getOrderName(),std.getPrice(),orderId);
    }
}