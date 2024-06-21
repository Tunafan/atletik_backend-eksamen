package kea3.atletik_backend.template;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long>{
    Item findByName(String name);
}
