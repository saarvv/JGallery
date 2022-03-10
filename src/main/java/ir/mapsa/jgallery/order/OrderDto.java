package ir.mapsa.jgallery.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrderDto {

    @ApiModelProperty(value = "order_id")
    private Long id;

    @ApiModelProperty(value = "price")
    private Integer price;

    @ApiModelProperty(value = "status")
    private String status;

    @ApiModelProperty(value = "artwork_id")
    private Long artworkid;
}

