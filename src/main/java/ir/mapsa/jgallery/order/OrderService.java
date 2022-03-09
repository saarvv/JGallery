package ir.mapsa.jgallery.order;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public Order save(Order order){
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public void updateOrder(Order order, Long id) {
        order.setId(id);
        orderRepository.save(order);
    }


    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
