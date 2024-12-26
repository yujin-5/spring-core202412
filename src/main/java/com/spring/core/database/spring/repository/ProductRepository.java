package com.spring.core.database.spring.repository;


import com.spring.core.database.spring.jdbc.entity.Product;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor //final 필드만 골라내서 생성자 만듦
//@AllArgsConstructor
public class ProductRepository {

    //스프링의 JDBC를 수행하는 객체
    private final JdbcTemplate jdbcTemplate; //의존객체는 final처리
    //의존객체는 프로젝트 실행 중에 바뀌면 안 됨
    //의존객체는 불변해야 함

    //생성자가 단 1개면 자동 주입처리
//    @Autowired
//    public ProductRepository(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }

    //CRUD
    //insert
    public void save(Product product){
        String sql = """
                INSERT INTO products
                    (name, price, stock_quantity, description, seller, status)
                VALUES
                    (?,?,?,?,?,?) 
                """;
        jdbcTemplate.update(sql,
                product.getName(),product.getPrice(),product.getStockQuantity(),product.getDescription(),
                product.getSeller(),product.getStatus());
    }


    //delete
    public void deleteById(Long id){
        String sql = """
                DELETE FROM products
                WHERE id = ?
                """;

        jdbcTemplate.update(sql, id);
    }

    //update
    public void updatePrice(Long id, int newPrice){
        String sql = """
                UPDATE products
                SET price = ?
                WHERE id = ?
                """;
        jdbcTemplate.update(sql, newPrice, id);
    }

    //다중 SELECT
    public List<Product> findAll(){
//        String sql = """
//                SELECT * FROM products
//                """;
//        List<Product> productList = jdbcTemplate.query(sql, new ProductRowMapper());
//        return productList;
        String sql = """
                SELECT * FROM products
                """;
        List<Product> productList = jdbcTemplate.query(sql, new ProductRowMapper());
        return productList;
    }

    // 단일 SELECT
    public Product findById(Long id) {
        return jdbcTemplate.queryForObject("""
                SELECT * FROM products
                WHERE id = ?
                """,
                (rs, rowNum) -> new Product(rs),
                id
        );

    }
}







