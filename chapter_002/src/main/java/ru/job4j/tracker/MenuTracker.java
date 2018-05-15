package ru.job4j.tracker;

import java.io.IOException;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = this.new CreateAction();
        this.actions[1] = new ShowAction();
        this.actions[2] = new EditActions();
        this.actions[3] = new DeleteAction();
        this.actions[4] = new FindByIdAction();
        this.actions[5] = new FindByNameAction();
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Реализация добавления новой заявки в хранилище.
     */
    public class CreateAction implements UserAction {

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
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
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }

        @Override
        public String info() {
            return "0. Add new Item";
        }
    }

    /**
     * Реализация отображения всех имеющихся в хранилище заявок.
     */
    public class ShowAction implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Вывод на экран списка имеющихся заявок --------------");
            Item[] result = tracker.findAll();
            for (Item items : result) {
                System.out.println(items.toString());
            }
        }

        @Override
        public String info() {
            return "1. Show all Items";
        }
    }

    /**
     * Реализация поиска заявки по name.
     */
    public class FindByNameAction implements UserAction {
        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по name --------------");
            String name = null;
            try {
                name = input.ask("Введите name заявки :");
            } catch (IOException e) {
                e.printStackTrace();
            }
            Item[] item = tracker.findByName(name);
            System.out.println("------------ Вывод на экран содержимого заявки: ");
            for (Item it : item) {
                System.out.println(it);
                System.out.println("");
            }
        }

        @Override
        public String info() {
            return "5. Find Item by name.";
        }
    }

    /**
     * Реализация удаления заявки по Id.
     */
    public static class DeleteAction implements UserAction {
        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки из хранилища --------------");
            String id = null;
            try {
                id = input.ask("Введите id заявки :");
            } catch (IOException e) {
                e.printStackTrace();
            }
            tracker.delete(id);
            System.out.println("------------ Заявка с Id : " + id + " удалена.");

        }

        @Override
        public String info() {
            return "3. Delete Item.";
        }
    }

    /**
     * Реализация возможности редактирования заявок.
     */
    public class EditActions implements UserAction {

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование содержимого заявки --------------");
            String oldId = null;
            try {
                oldId = input.ask("Введите id редактируемой заявки: ");
            } catch (IOException e) {
                e.printStackTrace();
            }
            Item reversoItem = new Item();
            if (oldId != null) {
                if (reversoItem == null) {
                    System.out.println("Указанного id не существует, введите корректный Id");
                }
                Item newItem = new Item();
                try {
                    newItem.setName(input.ask("Введите новое имя заявки: "));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String newDesc = null;
                try {
                    newDesc = input.ask("Введите новое desc заявки: ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                newItem.setDesc(newDesc);
                Long newCreated = null;
                try {
                    newCreated = Long.valueOf(input.ask("Введите новое created заявки: "));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                newItem.setCreated(newCreated);
                String[] newComments = new String[0];
                try {
                    newComments = new String[]{input.ask("Введите комментарий к новой заявке: ")};
                } catch (IOException e) {
                    e.printStackTrace();
                }
                newItem.setComments(newComments);
                tracker.replace(oldId, newItem);
                System.out.println("------------ Сохранение внесенных изменений... --------------");
                System.out.println("------------ Сохранение успешно завершено --------------");
            }
        }

        @Override
        public String info() {
            return "2. Edit Item.";
        }
    }
}

/**
 * Реализация поиска по Id заявки.
 */
class FindByIdAction implements UserAction {
    @Override
    public int key() {
        return 4;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по id --------------");
        String id = null;
        try {
            id = input.ask("Введите id заявки :");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Item item = tracker.findById(id);
        System.out.println("------------ Вывод на экран содержимого заявки: ");
        System.out.println("name: " + item.getName());
        System.out.println("desc: " + item.getDesc());
        System.out.println("created: " + item.getCreated());
        System.out.println("comments: " + item.getComments());
    }

    @Override
    public String info() {
        return "4. Find Item by Id.";
    }
}