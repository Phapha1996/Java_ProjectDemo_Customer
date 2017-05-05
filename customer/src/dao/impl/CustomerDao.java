package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import dao.intf.Daoitf;
import exception.DaoException;
import utils.JdbcUtils;
import bean.Customer;

public class CustomerDao implements Daoitf {
	
	private Connection con = null;
	private PreparedStatement st = null;
	private ResultSet rs = null;
	
	/* (non-Javadoc)
	 * @see dao.impl.Daoitf#add(bean.Customer)
	 */
	public void add(Customer customer){
		
		try {
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO customer(id,name,gender,birthday,cellphone,email,preference,type,description) VALUES(?,?,?,?,?,?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setString(1, customer.getId());
			st.setString(2, customer.getName());
			st.setString(3, customer.getGender());
			st.setDate(4,  new java.sql.Date(customer.getBirthday().getTime()));
			st.setString(5, customer.getCellphone());
			st.setString(6, customer.getEmail());
			st.setString(7, customer.getPreference());
			st.setString(8, customer.getType());
			st.setString(9, customer.getDescription());
			st.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}finally{
			JdbcUtils.release(con, st, rs);
		}
		
		
	}
	
	
	
	/* (non-Javadoc)
	 * @see dao.impl.Daoitf#delete(java.lang.String)
	 */
	public void delete(String id){
	
		try {
			con = JdbcUtils.getConnection();
			String sql = "DELET FROM customer WHERE id=?";
			st = con.prepareStatement(sql);
			st.setString(1, id);
			st.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}finally{
			JdbcUtils.release(con, st, rs);
			
		}
		
		
	}
	
	
	/* (non-Javadoc)
	 * @see dao.impl.Daoitf#update(bean.Customer)
	 */
	public void update(Customer customer){

	try {
		con = JdbcUtils.getConnection();
		String sql = "UPDATE customer SET WHERE";
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		JdbcUtils.release(con, st, rs);	
	}
	
	}
	
	
	
	/* (non-Javadoc)
	 * @see dao.impl.Daoitf#find(java.lang.String)
	 */
	public Customer find(String id){
		
		
		try {
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM customer WHERE id=?";
			st = con.prepareStatement(sql);
			st.setString(1, id);
			st.executeQuery();
			rs = st.getResultSet();
			Customer cos = new Customer();
			if(rs.next()){
				cos.setId(rs.getString("id"));
				cos.setName(rs.getString("name"));
				cos.setGender(rs.getString("gender"));
				cos.setBirthday(rs.getDate("birthday"));
				cos.setCellphone(rs.getString("cellphone"));
				cos.setEmail(rs.getString("email"));
				cos.setPreference(rs.getString("preference"));
				cos.setType(rs.getString("type"));
				cos.setDescription(rs.getString("description"));
			}else{
				return null;
			}
			
			return cos;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}finally{
			JdbcUtils.release(con, st, rs);
		}
		

	}
	
	
	//得到所有的记录
	public List getAll(){
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = JdbcUtils.getConnection();
			String sql = "select * from customer";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			List<Customer> list = new LinkedList();
			while(rs.next()){
				Customer cos = new Customer();
				cos.setId(rs.getString("id"));
				cos.setName(rs.getString("name"));
				cos.setGender(rs.getString("gender"));
				cos.setBirthday(rs.getDate("birthday"));
				cos.setCellphone(rs.getString("cellphone"));
				cos.setEmail(rs.getString("email"));
				cos.setPreference(rs.getString("preference"));
				cos.setType(rs.getString("type"));
				cos.setDescription(rs.getString("description"));
				list.add(cos);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.release(con, st, rs);
		}
	}	
	
	
	//得到记录数，从pageindex开始，读出value条记录
	public List<Customer> pageData(int pageindex,int pagesize){
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "select * from customer limit ?,?";
			st = con.prepareStatement(sql);
			st.setInt(1, pageindex);
			st.setInt(2, pagesize);
			rs = st.executeQuery();
			List<Customer> list = new LinkedList();
			while(rs.next()){
				Customer cos = new Customer();
				cos.setId(rs.getString("id"));
				cos.setName(rs.getString("name"));
				cos.setGender(rs.getString("gender"));
				cos.setBirthday(rs.getDate("birthday"));
				cos.setCellphone(rs.getString("cellphone"));
				cos.setEmail(rs.getString("email"));
				cos.setPreference(rs.getString("preference"));
				cos.setType(rs.getString("type"));
				cos.setDescription(rs.getString("description"));
				list.add(cos);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally{
			JdbcUtils.release(con, st, rs);
		}
	}
	
	
	//得到数据库中的总记录数
	public int getTotleRecord(){
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "select count(*) from customer";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			int index = 0;
			while(rs.next()){
				index = rs.getInt(1);
			}
			return index;
		}catch(SQLException e){

			e.printStackTrace();
			throw new RuntimeException();
		}finally{
			JdbcUtils.release(con, st, rs);
		}
		
	}
	
}
