import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.stamping.Group;
import com.stamping.Signature;
import com.stamping.Task;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class GroupTest {

    private Task task1;
    private Task task2;
    private Signature signature1;
    private Signature signature2;
    private Group group;

    @BeforeEach
    void setUp() {
        // Створення реальних завдань
        task1 = new SimpleTask("Task1");
        task2 = new SimpleTask("Task2");
        
        // Створення підписів з реальними завданнями
        signature1 = new Signature(task1);
        signature2 = new Signature(task2);
        
        // Створення групи з двома підписами
        group = new Group(List.of(signature1, signature2), "group1");
    }

    @Test
    void testApplyShouldSetGroupIdAndExecuteTasks() {
        // Перевірка, чи вірно задається groupId і виконуються задачі
        group.apply();

        // Перевірка, чи були встановлені правильні groupId в обох підписах
        assertEquals("group1", signature1.getGroupId());
        assertEquals("group1", signature2.getGroupId());

        // Перевірка, чи виконуються методи execute() для кожного завдання
        assertTrue(((SimpleTask) task1).isExecuted());
        assertTrue(((SimpleTask) task2).isExecuted());
    }

    @Test
    void testApplyWithEmptySignatures() {
        // Перевірка групи з порожнім списком підписів
        Group emptyGroup = new Group(List.of(), "group2");
        
        emptyGroup.apply();
        
        // Тут не має бути жодних викликів execute(), тому перевірка відсутності виконання
        assertFalse(((SimpleTask) task1).isExecuted());
        assertFalse(((SimpleTask) task2).isExecuted());
    }

    @Test
    void testGroupIdShouldBeCorrect() {
        // Перевірка правильності groupId для групи
        assertEquals("group1", group.getGroupId());
    }

    @Test
    void testSignatureGroupIdShouldBeSet() {
        // Перевірка, чи groupId встановлюється в Signature при виклику apply()
        group.apply();
        
        // Перевірка groupId в кожному підписі після застосування групи
        assertEquals("group1", signature1.getGroupId());
        assertEquals("group1", signature2.getGroupId());
    }
}

class SimpleTask implements Task {
    private String name;
    private boolean executed;

    public SimpleTask(String name) {
        this.name = name;
        this.executed = false;
    }

    @Override
    public void execute() {
        this.executed = true;
        System.out.println("Executing " + name);
    }

    public boolean isExecuted() {
        return executed;
    }
}
