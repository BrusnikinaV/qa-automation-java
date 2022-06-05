package hashMap;

import com.tcs.edu.domain.Message;
import com.tcs.edu.enums.Severity;
import com.tcs.edu.service.HashMapMessageRepository;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateHashMapMessageTests {
    HashMapMessageRepository mapMessageRepository = new HashMapMessageRepository();

    @Test
    void checkAddElementsInHashMap(){
        HashMap<UUID, Message> messageHashMap = mapMessageRepository.create(new Message(Severity.MAJOR, "Hello beautiful world"));
        assertEquals(1, messageHashMap.size(),
                "Не совпадает размер HashMap. Ожидали 1 элемент, получили: " + messageHashMap.size());
    }

    @Test
    void checkAddFewElemntsInHashMap(){
        HashMap<UUID, Message> messageHashMap = mapMessageRepository.create(new Message(Severity.MINOR, "Hello beautiful world"));
        assertEquals(1, messageHashMap.size(),
                "Не совпадает размер HashMap. Ожидали 1 элемент, получили: " + messageHashMap.size());
        messageHashMap.put(UUID.randomUUID(), new Message(Severity.REGULAR, "Hello beautiful life"));
        assertEquals(2, messageHashMap.size(),
                "Не совпадает размер HashMap. Ожидали 2 элемента, получили: " + messageHashMap.size());
    }
}
