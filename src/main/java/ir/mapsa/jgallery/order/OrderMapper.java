package ir.mapsa.jgallery.order;

import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toEntity(OrderDto orderDto);
    OrderDto toDto(Order order);
    List<OrderDto> toDto(List<Order> order);
    List<Order> toEntity(List<OrderDto> orderDtos);
}
