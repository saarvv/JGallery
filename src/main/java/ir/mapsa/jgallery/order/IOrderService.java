package ir.mapsa.jgallery.order;

import java.util.List;


public interface IOrderService {

    Order save(Order order);
    List<Order> findAll();
    Order getOrderById(Long id);
    void updateOrder(Order order,Long id);
    void delete(Long id);

}