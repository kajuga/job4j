//package ru.job4j.tracker;
//
//import ru.job4j.tracker.actions.BaseAction;
//import ru.job4j.tracker.actions.UserAction;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Этот класс управляет объектом Tracker забинденными переменнными от 0 до 5.
// */
//public class MenuTracker {
//
//    private Input input;
//    private Tracker tracker;
////    private UserAction[] actions = new UserAction[6];
//    private List<UserAction> actions = new ArrayList<>();
//
//    public MenuTracker(Input input, Tracker tracker) {
//        this.input = input;
//        this.tracker = tracker;
//    }
//
//    public void fillActions() {
//        this.actions.get("0") = new CreateAction();
//        this.actions[1] = new ShowAction();
//        this.actions[2] = new EditActions();
//        this.actions[3] = new DeleteAction();
//        this.actions[4] = new FindByIdAction();
//        this.actions[5] = new FindByNameAction();
//    }
//
//    public void select(int key) throws IOException {
//        this.actions[key].execute(this.input, this.tracker);
//    }
//
//    public void show() {
//        for (UserAction action : this.actions) {
//            if (action != null) {
//                System.out.println(action.info());
//            }
//        }
//    }
//
//    /**
//     * Реализация добавления новой заявки в хранилище.
//     */
//    public class CreateAction extends BaseAction {
//
//        public CreateAction() {
//            super(0, "Add new Item.");
//        }
//
//        @Override
//        public void execute(Input input, Tracker tracker) {
//            System.out.println("------------ Добавление новой заявки --------------");
//            String desc = null;
//            String name = null;
//            try {
//                name = input.ask("Введите имя заявки :");
//                desc = input.ask("Введите desc заявки :");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Item item = new Item(name, desc);
//            tracker.add(item);
//            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
//        }
//    }
//
//    /**
//     * Реализация отображения всех имеющихся в хранилище заявок.
//     */
//    public class ShowAction extends BaseAction {
//
//        public ShowAction() {
//            super(1, "Show all Items.");
//        }
//
//        @Override
//        public void execute(Input input, Tracker tracker) {
//            System.out.println("------------ Вывод на экран списка имеющихся заявок --------------");
//            Item[] result = tracker.findAll();
//            for (Item items : result) {
//                System.out.println(items.toString());
//            }
//        }
//    }
//
//    /**
//     * Реализация возможности редактирования заявок.
//     */
//    public class EditActions extends BaseAction {
//
//        public EditActions() {
//            super(2, "Edit Item.");
//        }
//
//        @Override
//        public void execute(Input input, Tracker tracker) throws IOException {
//            System.out.println("------------ Редактирование содержимого заявки --------------");
//            String oldId = null;
//
//            oldId = input.ask("Введите id редактируемой заявки: ");
//
//            Item reversoItem = new Item();
//            if (oldId != null) {
//                if (reversoItem == null) {
//                    System.out.println("Указанного id не существует, введите корректный Id");
//                }
//                Item newItem = new Item();
//                newItem.setName(input.ask("Введите новое имя заявки: "));
//                String newDesc = null;
//                newDesc = input.ask("Введите новое desc заявки: ");
//                newItem.setDesc(newDesc);
//                Long newCreated = null;
//                newCreated = Long.valueOf(input.ask("Введите новое created заявки: "));
//                newItem.setCreated(newCreated);
//                String[] newComments = new String[0];
//                newComments = new String[]{input.ask("Введите комментарий к новой заявке: ")};
//                newItem.setComments(newComments);
//                tracker.replace(oldId, newItem);
//                System.out.println("------------ Сохранение внесенных изменений... --------------");
//                System.out.println("------------ Сохранение успешно завершено --------------");
//            }
//        }
//    }
//
//    /**
//     * Реализация удаления заявки по Id.
//     */
//    public static class DeleteAction extends BaseAction {
//        public DeleteAction() {
//            super(3, "Delete Item.");
//        }
//
//        @Override
//        public void execute(Input input, Tracker tracker) {
//            System.out.println("------------ Удаление заявки из хранилища --------------");
//            String id = null;
//            try {
//                id = input.ask("Введите id заявки :");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            tracker.delete(id);
//            System.out.println("------------ Заявка с Id : " + id + " удалена.");
//        }
//    }
//
//    /**
//     * Реализация поиска по Id заявки.
//     */
//    class FindByIdAction extends BaseAction {
//        public FindByIdAction() {
//            super(4, "Find Item by Id.");
//        }
//
//        @Override
//        public void execute(Input input, Tracker tracker) {
//            System.out.println("------------ Поиск заявки по id --------------");
//            String id = null;
//            try {
//                id = input.ask("Введите id заявки :");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Item item = tracker.findById(id);
//            System.out.println("------------ Вывод на экран содержимого заявки: ");
//            System.out.println("name: " + item.getName());
//            System.out.println("desc: " + item.getDesc());
//            System.out.println("created: " + item.getCreated());
//            System.out.println("comments: " + item.getComments());
//        }
//    }
//
//    /**
//     * Реализация поиска заявки по name.
//     */
//    public class FindByNameAction extends BaseAction {
//        public FindByNameAction() {
//            super(5, "Find Item by name.");
//        }
//
//        @Override
//        public void execute(Input input, Tracker tracker) {
//            System.out.println("------------ Поиск заявки по name --------------");
//            String name = null;
//            try {
//                name = input.ask("Введите name заявки :");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Item[] item = tracker.findByName(name);
//            System.out.println("------------ Вывод на экран содержимого заявки: ");
//            for (Item it : item) {
//                System.out.println(it);
//                System.out.println("");
//            }
//        }
//    }
//}