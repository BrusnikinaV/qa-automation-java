package hashMap;

import com.tcs.edu.domain.Message;
import com.tcs.edu.enums.Severity;
import com.tcs.edu.service.HashMapMessageRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapMessageRepositoryTests {
    private static final HashMapMessageRepository mapMessageRepository = new HashMapMessageRepository();
    private static HashMap<UUID, Message> messageHashMap = new HashMap<>();
    private static UUID id1;
    private static UUID id2;
    private static UUID id3;
    @BeforeAll
    static void createHashMap(){
        id1 = mapMessageRepository.addMessage(new Message(Severity.MAJOR, "A"));
        id2 = mapMessageRepository.addMessage(new Message(Severity.MINOR, "B"));
        id3 = mapMessageRepository.addMessage(new Message(Severity.MINOR, "B"));
        assertNotEquals(id1, id2, "Сгенерированы одинаковые id");
        assertNotEquals(id1, id3, "Сгенерированы одинаковые id");
        assertNotEquals(id2, id3, "Сгенерированы одинаковые id");
    }

    @Nested
    class FindAllMessages{
        @Test
        void checkFindAllElementsInHashMap(){
            var returnCollection = mapMessageRepository.findAll();
            assertEquals(3, returnCollection.size(),
                    "Не совпало ожидаемое количество сообщений в результате поиска всех элементов");
            var mes1 = returnCollection.stream().filter(hm->hm.getId().equals(id1)).findFirst().orElse(null);
            var mes2 = returnCollection.stream().filter(hm->hm.getId().equals(id2)).findFirst().orElse(null);
            var mes3 = returnCollection.stream().filter(hm->hm.getId().equals(id3)).findFirst().orElse(null);
            assertNotNull(mes1, "Не нашли message по id");
            assertNotNull(mes2, "Не нашли message по id");
            assertNotNull(mes3, "Не нашли message по id");
            assertEquals(Severity.MAJOR, mes1.getLevel(), "Не совпал Level");
            assertEquals(Severity.MINOR, mes2.getLevel(), "Не совпал Level");
            assertEquals(Severity.MINOR, mes3.getLevel(), "Не совпал Level");
            assertEquals("A", mes1.getBody(), "Не совпал body");
            assertEquals("B", mes2.getBody(), "Не совпал body");
            assertEquals("B", mes3.getBody(), "Не совпал body");
        }
    }

    @Nested
    class FindMessageByKey{
        @Test
        void checkFindElementsByKey(){
            var currentMessage = mapMessageRepository.findByPrimaryKey(id2);
            assertEquals(Severity.MINOR, currentMessage.getLevel(), "Не совпал level по результатам поиска");
            assertEquals("B", currentMessage.getBody(), "Не совпал body по результатам поиска");
        }

        @Test
        void checkFindElementsByKeyWhereKeyEmptyInHashMap(){
            var currentMessage = mapMessageRepository.findByPrimaryKey(UUID.randomUUID());
            assertNull(currentMessage, "В результате поиска по несуществующему id получили сообщение");
        }
    }

    @Nested
    class FindMeassagesBySeverity{
        @Test
        void checkFindBySeverity(){
            var returnCollection = mapMessageRepository.findBySeverity(Severity.MINOR);
            assertEquals(2, returnCollection.size(),
                    "Не совпало ожидаемое количество сообщений в результате поиска всех элементов");
            var mes1 = returnCollection.stream().filter(hm->hm.getId().equals(id2)).findFirst().orElse(null);
            var mes2 = returnCollection.stream().filter(hm->hm.getId().equals(id3)).findFirst().orElse(null);
            assertNotNull(mes1, "Не нашли message по id");
            assertNotNull(mes2, "Не нашли message по id");
            assertEquals(Severity.MINOR, mes1.getLevel(), "Не совпал Level");
            assertEquals(Severity.MINOR, mes2.getLevel(), "Не совпал Level");
            assertEquals("B", mes1.getBody(), "Не совпал body");
            assertEquals("B", mes2.getBody(), "Не совпал body");
        }

        @Test
        void checkFindBySeverityWhereSeverityEmpty(){
            var currentMessage = mapMessageRepository.findBySeverity(Severity.REGULAR);
            assertEquals(0, currentMessage.size(), "В результате поиска по несуществующему id получили сообщение");
        }
    }
}
