package ir.mapsa.jgallery.order;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order,Long> {

    Order getOrderById(Long id);
    List<Order> findAll();
}
