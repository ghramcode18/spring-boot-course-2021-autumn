package org.closure.course.mapper;

import org.closure.course.dto.ProductDto;
import org.closure.course.entity.Brand;
import org.closure.course.entity.Product;
import org.closure.course.model.BrandModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    public static ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "totalPrice", source = "price")
    @Mapping(target = "createDate", expression = "java(java.time.Instant.now())")
    public ProductDto ProductEntityToDto(Product product);

    public BrandModel BrandEntityToModel(Brand brand);
}
