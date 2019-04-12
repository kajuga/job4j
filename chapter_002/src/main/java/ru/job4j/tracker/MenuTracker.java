package ru.job4j.tracker;

import ru.job4j.tracker.actions.BaseAction;
import ru.job4j.tracker.actions.UserAction;

import java.io.IOException;
import java.util.function.Consumer;

/**
 * Этот класс управляет объектом Tracker забинденными переменнными от 0 до 5.
 */
public class MenuTracker {
    private final Consumer<String> output;
    private Input input;
    private ITracker tracker;
    private UserAction[] actions = new UserAction[6];

    public MenuTracker(Input input, ITracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void fillActions() {
        this.actions[0] = new CreateAction();
        this.actions[1] = new ShowAction();
        this.actions[2] = new EditActions();
        this.actions[3] = new DeleteAction();
        this.actions[4] = new FindByIdAction();
        this.actions[5] = new FindByNameAction();
    }

    public void select(int key) throws IOException {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }

    /**
     * Реализация добавления новой заявки в хранилище.
     */
    public class CreateAction extends BaseAction {

        public CreateAction() {
            super(0, "Add new Item.");
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            output.accept("------------ Добавление новой заявки --------------");
            String desc = null;
            String name = null;
            try {
                name = input.ask("Введите имя заявки :");
                desc = input.ask("Введите desc заявки :");
            } catch (IOException e) {
                e.printStackTrace();
            }
            Item item = new Item(name, desc);
            tracker.add(item);
            output.accept("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }
    }

    /**
     * Реализация отображения всех имеющихся в хранилище заявок.
     */
    public class ShowAction extends BaseAction {

        public ShowAction() {
            super(1, "Show all Items.");
        }
        @Override
        public void execute(Input input, ITracker tracker) {
            for (Item item : tracker.findAll()) {
                output.accept(String.format("Name: %s| Desc: %s| Id: %s",
                        item.getName(), item.getDesc(), item.getId()));
            }
        }
    }

    /**
     * Реализация возможности редактирования заявок.
     */
    public class EditActions extends BaseAction {

        public EditActions() {
            super(2, "Edit Item.");
        }

        @Override
        public void execute(Input input, ITracker tracker) throws IOException {
            output.accept("------------ Редактирование содержимого заявки --------------");
            String oldId = null;

            oldId = input.ask("Введите id редактируемой заявки: ");

            Item reversoItem = new Item();
            if (oldId != null) {
                if (reversoItem == null) {
                    output.accept("Указанного id не существует, введите корректный Id");
                }
                Item newItem = new Item();
                newItem.setName(input.ask("Введите новое имя заявки: "));
                String newDesc = null;
                newDesc = input.ask("Введите новое desc заявки: ");
                newItem.setDesc(newDesc);
                Long newCreated = null;
                newCreated = Long.valueOf(input.ask("Введите новое created заявки: "));
                newItem.setCreated(newCreated);
                String[] newComments = new String[0];
                newComments = new String[]{input.ask("Введите комментарий к новой заявке: ")};
                newItem.setComments(newComments);
                tracker.replace(oldId, newItem);
                output.accept("------------ Сохранение внесенных изменений... --------------");
                output.accept("------------ Сохранение успешно завершено --------------");
            }
        }
    }

    /**
     * Реализация удаления заявки по Id.
     */
    public static class DeleteAction extends BaseAction {
        public DeleteAction() {
            super(3, "Delete Item.");
        }

        public void execute(Input input, ITracker tracker, Consumer<String> output) {
            output.accept("------------ Удаление заявки из хранилища --------------");
            String id = null;
            try {
                id = input.ask("Введите id заявки :");
            } catch (IOException e) {
                e.printStackTrace();
            }
            tracker.delete(id);
            output.accept("------------ Заявка с Id : " + id + " удалена.");
        }
    }

    /**
     * Реализация поиска по Id заявки.
     */
    class FindByIdAction extends BaseAction {
        public FindByIdAction() {
            super(4, "Find Item by Id.");
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            output.accept("------------ Поиск заявки по id --------------");
            String id = null;
            try {
                id = input.ask("Введите id заявки :");
            } catch (IOException e) {
                e.printStackTrace();
            }
            Item item = tracker.findById(id);
            output.accept("------------ Вывод на экран содержимого заявки: ");
            output.accept("name: " + item.getName());
            output.accept("desc: " + item.getDesc());
            output.accept("created: " + item.getCreated());
            output.accept("comments: " + item.getComments());
        }
    }

    /**
     * Реализация поиска заявки по name.
     */
    public class FindByNameAction extends BaseAction {
        public FindByNameAction() {
            super(5, "Find Item by name.");
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            output.accept("------------ Поиск заявки по name --------------");
            String name = null;
            try {
                name = input.ask("Введите name заявки :");
            } catch (IOException e) {
                e.printStackTrace();
            }
            Item[] item = tracker.findByName(name);
            output.accept("------------ Вывод на экран содержимого заявки: ");
            for (Item it : item) {
                System.out.println(it);
                output.accept("");
            }
        }
    }
}