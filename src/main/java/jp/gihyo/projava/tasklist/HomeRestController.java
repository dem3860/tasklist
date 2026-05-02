package jp.gihyo.projava.tasklist;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class HomeRestController {
    record  TaskItem(String id,String task,String deadline,boolean done) {}
    private List<TaskItem> taskItems = new ArrayList<>();

    @GetMapping(value="/resthello")
    String hello() {
        return """
                Hello.
                Is works!
                現在時刻は%sです。
                """.formatted(LocalDateTime.now());
    }

    @PostMapping("/restadd")
    TaskItem addItem(@RequestParam("task") String task,
                   @RequestParam("deadline") String deadline) {
        String id = UUID.randomUUID().toString().substring(0,8);
        TaskItem item = new TaskItem(id,task,deadline,false);
        taskItems.add(item);

        return item;
    }

    @GetMapping("/restlist")
    String listItems() {
        return taskItems.stream()
                .map(TaskItem::toString)
                .collect(Collectors.joining(","));
    }
}
