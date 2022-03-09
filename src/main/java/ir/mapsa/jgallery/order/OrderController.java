package ir.mapsa.jgallery.order;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/Order")
public class OrderController {

    private IOrderService orderService;
    private OrderMapper mapper;

    @Autowired
    public OrderController(IOrderService orderService, OrderMapper mapper) {
        this.orderService = orderService;
        this.mapper = mapper;
    }

    @PostMapping(value = "/save")
    public Order saveOrder(@RequestBody OrderDto orderDto) {
        Order order = mapper.toEntity(orderDto);
        return orderService.save(order);
    }

    @GetMapping(value = "/getAll")
    public List<OrderDto> getAll() {
        List<Order> orders = orderService.findAll();
        List<OrderDto> orderDtos = mapper.toDto(orders);
        return orderDtos;
    }

    @GetMapping(value = "/{id}")
    public OrderDto getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        OrderDto orderDto = mapper.toDto(order);
        return orderDto;
    }

    @ApiOperation(value = "Update an Order")
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> updateOrder(@PathVariable Long id,@RequestBody OrderDto orderDto){
        Order order=mapper.toEntity(orderDto);
        orderService.updateOrder(order,id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        orderService.delete(id);
    }
}

