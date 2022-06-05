package hashMap;

import com.tcs.edu.domain.Message;
import com.tcs.edu.enums.Severity;
import com.tcs.edu.service.HashMapMessageRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FindMessageInHasMapTest {
    private static final HashMapMessageRepository mapMessageRepository = new HashMapMessageRepository();
    private static HashMap<UUID, Message> messageHashMap;
    private static UUID id;
    @BeforeAll
    static void createHashMap(){
        messageHashMap = mapMessageRepository.create(new Message(Severity.MAJOR, "Hello beautiful world"));
        id = UUID.randomUUID();
        messageHashMap.put(id, new Message(Severity.MINOR, "Hello beautiful life"));
    }

    @Test
    void checkFindAllElementsInHashMap(){
        var returnCollection = mapMessageRepository.findAll(messageHashMap);
        assertEquals(messageHashMap.size(), returnCollection.size(),
                "Не совпало ожидаемое количество сообщений в результате поиска всех элементов");
        for (var elementHashMap:messageHashMap.values()){
            assertEquals(1, returnCollection.stream().filter(hm->hm.getId().equals(elementHashMap.getId())).count(),
                    "Не нашли элемент с id из исходной коллекции");
        }
    }

    @Test
    void checkFindElementsByKey(){
        var currentMessage = mapMessageRepository.findByPrimaryKey(id);
        var expectedMessage = messageHashMap.get(id);
        assertEquals(expectedMessage, currentMessage, "Не совпал message по результатам поиска с ожидаемым значением");
    }

    @Test
    void checkFindBySeverity(){
        var currentMessage = mapMessageRepository.findBySeverity(Severity.MINOR);
        var expectedMessage = messageHashMap.values().stream().filter(hm->hm.getLevel().
                equals(Severity.MINOR)).collect(Collectors.toList());
        assertEquals(expectedMessage, currentMessage, "Не совпала коллекция message, полученная в результате поиска по severity");
    }
}
