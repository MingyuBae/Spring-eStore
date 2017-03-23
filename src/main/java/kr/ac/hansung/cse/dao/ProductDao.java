package kr.ac.hansung.cse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.cse.model.Product;

@Repository
public class ProductDao {
	
	private JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public List<Product> getProducts(){
		String sqlStatement = "SELECT * FROM product";
		
		return jdbcTemplateObject.query(sqlStatement, new RowMapper<Product>(){

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Product product = new Product();
				
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setCategory(rs.getString("category"));
				product.setPrice(rs.getInt("price"));
				product.setManufacturer(rs.getString("manufacturer"));
				product.setUnitInStock(rs.getInt("unitInStock"));
				product.setDescription(rs.getString("description"));
				
				return product;
			}
			
		});
				
	}
	
	public Product getProductById(int id) {
		String sqlStatement = "SELECT * FROM product WHERE id = ?";
		
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[]{id},
				new RowMapper<Product>(){

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Product product = new Product();
				
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setCategory(rs.getString("category"));
				product.setPrice(rs.getInt("price"));
				product.setManufacturer(rs.getString("manufacturer"));
				product.setUnitInStock(rs.getInt("unitInStock"));
				product.setDescription(rs.getString("description"));
				
				return product;
			}
		});
	}

	public boolean addProduct(Product product) {
		String name = product.getName();
		String category = product.getCategory();
		int price = product.getPrice();
		String manufacturer = product.getManufacturer();
		int unitInStock = product.getUnitInStock();
		String description = product.getDescription();
		
		String sqlStatement = "INSERT "
				+ "INTO product(name, category, price, manufacturer, unitInStock, description) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		
		return (jdbcTemplateObject.update(sqlStatement, 
				new Object[] { name, category, price, manufacturer, unitInStock, description}) == 1);
	}

	public boolean deleteProduct(int id) {
		String sqlStatement = "DELETE FROM product WHERE id = ?";
		
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{id}) == 1);
	}

	public boolean editProduct(Product product) {
		String sqlStatement = "UPDATE product "
				+ "SET name=?, category=?, price=?, manufacturer=?, "
					+ "unitInStock=?, description=? "
				+ "WHERE id = ?";
		
		int id = product.getId();
		String name = product.getName();
		String category = product.getCategory();
		int price = product.getPrice();
		String manufacturer = product.getManufacturer();
		int unitInStock = product.getUnitInStock();
		String description = product.getDescription();
		
		return (jdbcTemplateObject.update(sqlStatement, 
				new Object[] { name, category, price, manufacturer, unitInStock, description, id }) == 1);
	}
}
