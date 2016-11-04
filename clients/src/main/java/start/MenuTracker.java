package start;

import moduls.Comment;
import moduls.Item;

import java.util.Date;

/**
 * Created by Ruslan on 25.10.2016.
 */
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction []actions = new UserAction[9];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillAction(){
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

    private class AddItem implements UserAction{

        public int key(){
            return 0;
        }

        public void execute(Input input, Tracker tracker){
            String name = input.inputData("Input name please");
            String description = input.inputData("Input description please");
            Date date = new Date();
            tracker.addClient(new Item(name, date.getTime(), description));
        }

        public String info(){
            return String.format("%s. %s", this.key(), "Adding new item");
        }
    }

    private class ShowItems implements UserAction{

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

        public String info(){
            return String.format("%s. %s", this.key(), "Showing all items");
        }
    }

    private class Update implements UserAction{

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

        public String info(){
            return String.format("%s. %s", this.key(), "Updating Item by id");
        }
    }

    private class SearchById implements UserAction{

        public int key(){
            return 3;
        }

        public void execute(Input input, Tracker tracker){
            String id = input.inputData("Input client's Id");
            System.out.println(tracker.findById(id).toString());
        }

        public String info(){
            return String.format("%s. %s", this.key(), "Searching Item by id");
        }
    }

    private class Remove implements UserAction{

        public int key(){
            return 4;
        }

        public void execute(Input input, Tracker tracker){
            String id = input.inputData("Input client's Id");
            tracker.remove(id);
        }

        public String info(){
            return String.format("%s. %s", this.key(), "Removing Item by id");
        }
    }

    private class AddComment implements UserAction{

        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            String commentary = input.inputData("Input comment");
            Comment comment = new Comment(commentary);
            String id = input.inputData("Input client'c Id to add comment");
            tracker.addComment(comment, id);
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Adding comments to Item by id");
        }
    }

    private class SearchItemByName implements UserAction{

        public int key() {
            return 6;
        }

        public void execute(Input input, Tracker tracker) {
            String clientSearchName = input.inputData("Input client name, you are looking for");
           // searchByName(clientSearchName);
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
                if (flag2) {
                    System.out.println("No mutches found");
                }
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Searching Item by name");
        }
    }

    private class SearchByDescription implements UserAction{

        public int key() {
            return 7;
        }

        public void execute(Input input, Tracker tracker) {
            String keyDescription = input.inputData("Input key for search description");
            //searchByDescription(keyDescription);
            System.out.println();
            boolean flag3 = false;
            for (Item item:
                    tracker.getAll())
                if (item != null && item.getDescription().contains(keyDescription)) {
                    System.out.println(item.toString());
                    for (Comment comment:
                            item.getComments()){
                        if(comment != null) {
                            System.out.println("-" + comment.getComment());
                        }
                        flag3 = true;
                    }
                    if(!flag3){
                        System.out.println("No mutches found");
                    }
                }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Searching Item by description");
        }
    }
    private class Exit implements UserAction{

        public int key(){
            return 8;
        }

        public void execute(Input input, Tracker tracker){
        }

        public String info(){
            return String.format("%s. %s", this.key(), "Exit");
        }
    }
}
