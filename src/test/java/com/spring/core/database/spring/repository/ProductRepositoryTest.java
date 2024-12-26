package com.spring.core.database.spring.repository;

import com.spring.core.database.spring.jdbc.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void saveTest(){

        Product p = Product.builder()
                .name("청소기")
                .stockQuantity(3)
                .description("진공 청소기")
                .price(3000)
                .seller("청소왕")
                .status("ACTIVE")
                .build();

//        Product p = new Product(null,"에어컨",1500000,0,"휘센","윌리스 캐리어","SOLD OUT",null);
//        p.setName("세탁기");
//        p.setPrice(2000000);
//        p.setSeller("김또치");
//        p.setDescription("세상에서 제일 잘 세탁하는 기계");
//        p.setStockQuantity(13);
//        p.setStatus("ACTIVE");

        productRepository.save(p);

    }

    //생성자의 문제점
    //1. 자동입력되는 데이터에 null값 넣어줘야 함
    //2. 순서 지켜야 함
    //대체 방안 -> 빌더

    @Test
    void deleteTest(){
        Long id = 3L;
        productRepository.deleteById(id);
    }

    @Test
    void updatePriceTest(){
        productRepository.updatePrice(2L,9999);
    }

    @Test
    void findAllTest(){
        List<Product> productList = productRepository.findAll();
        productList.forEach(System.out::println);
    }

    @Test
    void findByIdTest(){
        Product foundProduct = productRepository.findById(2L);
        System.out.println("foundProduct = " + foundProduct);
    }
}