package start;

import moduls.Comment;
import moduls.Item;

import java.util.Date;

/**
  Created by Ruslan on 25.10.2016.
 */
class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction []actions = new UserAction[9];

    MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
//menu actions
    void fillAction(){
        this.actions[0] = this.new AddItem();
        this.actions[1] = this.new ShowItems();
        this.actions[2] = this.new Update();
        this.actions[3] = this.new SearchById();
        this.actions[4] = this.new Remove();
        this.actions[5] = this.new AddComment();
        this.actions[6] = this.new SearchItemByName();
        this.actions[7] = this.new SearchByDescription();
        this.actions[8] = this.new Exit();
    }
//selection menu
    void select(int key){
        this.actions[key].execute(this.input, this.tracker);
    }
    void show(){
        for (UserAction action:
                this.actions){
            if (action != null){
                System.out.println(action.info());
            }
        }
    }
//getting quantity of actions
    int []getAllActions(){
        int []actionsQuantity = new int[this.actions.length];
        int i = 0;
        for(int n = 0; n < actionsQuantity.length; n++){
            actionsQuantity[n] = i;
            i = i +1;
        }
        return actionsQuantity;
    }
//adding new task
    private class AddItem extends InfoAction{
        AddItem(){
            super("Adding new Item");
        }
        public int key(){
            return 0;
        }

        public void execute(Input input, Tracker tracker){
            String name = input.inputData("Input name please");
            String description = input.inputData("Input description please");
            Date date = new Date();
            tracker.addClient(new Item(name, date.getTime(), description));
        }

    }
//showing all tasks
    private class ShowItems extends InfoAction{
        ShowItems() {
            super("Showing all items");
        }

        public int key(){
            return 1;
        }

        public void execute(Input input, Tracker tracker){
            for (Item getItem:
                    tracker.getAll()) {
                if(getItem != null){

                    System.out.println();
                    System.out.println(getItem.toString());
                    System.out.println("_______________");
                    for (Comment comment:
                            getItem.getComments()){
                        if(comment != null){
                            System.out.println("-" + comment.getComment());
                        }
                    }
                }
            }
        }
    }
//updating task by id
    private class Update extends InfoAction{

        Update() {
            super("Updating Item by id");
        }

        public int key(){
            return 2;
        }

        public void execute(Input input, Tracker tracker){
            String id = input.inputData("Input client's Id");
            String newName = input.inputData("Input new name");
            String newDescription = input.inputData("Input new description");
            Date date = new Date();
            Item item = new Item(newName, date.getTime(), newDescription);
            item.setClientId(id);
            tracker.rename(item);
        }

    }
//searching task by id
    private class SearchById extends InfoAction{

        SearchById() {
            super("Searching Item by id");
        }

        public int key(){
            return 3;
        }

        public void execute(Input input, Tracker tracker){
            String id = input.inputData("Input client's Id");
            System.out.println(tracker.findById(id).toString());
        }

    }
//removing task by id
    private class Remove extends InfoAction{

        Remove() {
            super("Removing Item by id");
        }

        public int key(){
            return 4;
        }

        public void execute(Input input, Tracker tracker){
            String id = input.inputData("Input client's Id");
            tracker.remove(id);
        }

    }
//aading comments to task by id
    private class AddComment extends InfoAction{

        AddComment() {
            super("Adding comments to Item by id");
        }

        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            String commentary = input.inputData("Input comment");
            Comment comment = new Comment(commentary);
            String id = input.inputData("Input client'c Id to add comment");
            tracker.addComment(comment, id);
        }

    }
//searching task by name
    private class SearchItemByName extends InfoAction{

        SearchItemByName() {
            super("Searching Item by name");
        }

        public int key() {
            return 6;
        }

        public void execute(Input input, Tracker tracker) {
            String clientSearchName = input.inputData("Input client name, you are looking for");
            System.out.println();
            boolean flag2 = true;
            for (Item getItem :
                    tracker.getAll()) {
                if (getItem != null && getItem.getName().equals(clientSearchName)) {
                    System.out.println(getItem.toString());
                    for (Comment comment :
                            getItem.getComments()) {
                        if (comment != null) {
                            System.out.println("-" + comment.getComment());
                        }
                        flag2 = false;
                    }
                }
            }
                if (flag2) {
                    System.out.println("No mutches found");
                }
        }

    }
//searching task by description
    private class SearchByDescription extends InfoAction{

        SearchByDescription() {
            super("Searching Item by description");
        }

        public int key() {
            return 7;
        }

        public void execute(Input input, Tracker tracker) {
            String keyDescription = input.inputData("Input key for search description");
            System.out.println();
            boolean flag3 = false;
            for (Item item :
                    tracker.getAll()) {
                if (item != null && item.getDescription().contains(keyDescription)) {
                    System.out.println(item.toString());
                    for (Comment comment :
                            item.getComments()) {
                        if (comment != null) {
                            System.out.println("-" + comment.getComment());
                        }
                        flag3 = true;
                    }
                }
            }
                if (!flag3) {
                        System.out.println("No mutches found");
                    }
        }

    }
//Exit key
    private class Exit extends InfoAction{

        Exit() {
            super("Exit");
        }

        public int key(){
            return 8;
        }

        public void execute(Input input, Tracker tracker){
        }

    }
}
