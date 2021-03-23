package jpabook.jpashop.service;


import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    @Transactional // 변경 감지 기능 사용
    public void updateItem(Long itemId, String name,  int price, int stockQuantity){ // parameter 가 많을 경우 DTO 를 만들어 사용
        Item findItem = itemRepository.findOne(itemId);
        findItem.setPrice(price); //실무에서는 set 함수를 사용하기보단, change 등의 메서드들을 만들어 entity 에서 끝낸다.ex) addStock 같은 함수.
        findItem.setName(name);
        findItem.setStockQuantity(stockQuantity);
    }
    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId){
        return itemRepository.findOne(itemId);
    }
}
