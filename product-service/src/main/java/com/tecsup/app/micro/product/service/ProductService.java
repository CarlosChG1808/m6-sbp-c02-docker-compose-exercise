package com.tecsup.app.micro.product.service;

import com.tecsup.app.micro.product.client.User;
import com.tecsup.app.micro.product.client.UserClient;
import com.tecsup.app.micro.product.dto.Product;
import com.tecsup.app.micro.product.entity.ProductEntity;
import com.tecsup.app.micro.product.mapper.ProductMapper;
import com.tecsup.app.micro.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor

public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final UserClient userClient;

    public Product getProductById(Long id) {

        //Call PostgreSQL productdb
        ProductEntity productEntity = productRepository.findById(id).orElse(null);

        //Call microservicio users
        User user = userClient.getUserById(productEntity.getCreatedBy());
        log.info("User : {}", user.getName());

        return productMapper.toDomainWithUser(productEntity, user);
    }
}
