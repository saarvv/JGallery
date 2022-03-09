package ir.mapsa.jgallery.order;

import io.swagger.annotations.ApiModelProperty;

public class OrderDto {

    @ApiModelProperty(value = "order_id")
    private Long id;

    @ApiModelProperty(value = "price")
    private Integer price;

    @ApiModelProperty(value = "status")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

