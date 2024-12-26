package com.spring.core.database.spring.jdbc.entity;


    /*
    CREATE TABLE products (
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL COMMENT '상품명',
    price INT NOT NULL COMMENT '가격',
    stock_quantity INT NOT NULL COMMENT '재고수량',
    description TEXT COMMENT '상품설명',
    seller VARCHAR(50) NOT NULL COMMENT '판매자',
    status VARCHAR(20) DEFAULT 'ACTIVE' COMMENT '상품상태',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='상품';
     */

import com.spring.core.database.spring.repository.ProductRepository;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Setter@Getter@ToString
@EqualsAndHashCode(of = "id") //id가 같으면 같은 값이기 때문에 id만으로 비교하겠다는 의미에서 of가 추가적으로 들어감
@NoArgsConstructor
@AllArgsConstructor
@Builder //생성자 대체 방안 - 순서 상관없이 데이터 넣을 수 있음
//추천 사항: DB컬럼명과 이 클래스의 필드명을 똑같이 만들 것
public class Product {
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;
    private String description;
    private String seller;
    private String status;
    private LocalDateTime createdAt;

    public Product(ResultSet rs) throws SQLException{
        this.id = rs.getLong("id");
        this.name = rs.getString("name");
        this.price = rs.getInt("price");
        this.description = rs.getString("description");
        this.seller = rs.getString("seller");
        this.status = rs.getString("status");
        this.stockQuantity = rs.getInt("stock_quantity");
        this.createdAt = rs.getTimestamp("created_at").toLocalDateTime();

    }

}
