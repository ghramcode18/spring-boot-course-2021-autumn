package org.closure.course.dto;

import java.time.Instant;
import java.util.List;

import org.closure.course.model.BrandModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.With;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@With
@ToString
public class ProductDto {
    Integer id;
    String name;
    String totalPrice;
    Instant createDate;
    List<BrandModel> brand;

}

