package server;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 Created by ${Ruslan} on 23.01.17.
 */
@SuppressWarnings("Since15")
class ServerMenu {

    private File file = new File("TestDir1");
    String way = file.getAbsolutePath();
    private String newWay, root = way;
    private int bufferFile = 128;
    private int divTail, sends;
    private String separator = System.getProperty("file.separator");

    private DataInputStream in;
    private DataOutputStream out;


    private Map<String, ServerActions> serverActionsHashMap = new HashMap<>();

    ServerMenu(DataOutputStream out, DataInputStream in) {
        //this.path = Paths.get(System.getProperty("pathDir.dir"));
        this.in = in;
        this.out = out;
    }

    void fillServerActions(){
        this.serverActionsHashMap.put("cd", new EnterFolder());
        this.serverActionsHashMap.put("back", new ExitFolder());
        this.serverActionsHashMap.put("list", new ShowList());
        this.serverActionsHashMap.put("exit", new ExitApp());
        this.serverActionsHashMap.put("download", new Download());
        this.serverActionsHashMap.put("upload", new Upload());
    }

    void select(ToDo toDo) throws IOException {
        if (serverActionsHashMap.containsKey(toDo.getKeyToDo())){
            this.serverActionsHashMap.get(toDo.getKeyToDo()).execute(toDo);
        }
    }
//    public String getWay(){
//        return this.way;
//    }

    private class EnterFolder implements ServerActions{

        public String commandName() {
            return "cd";
        }

        public void execute(ToDo value) throws IOException {
            System.out.println(System.getProperty("os.name"));
            newWay = way.concat(separator).concat(value.getTarget());
                File file = new File(newWay);
            if (file.exists()){
                out.writeUTF(newWay);
                way = newWay;
                out.writeBoolean(true);
            }
            else {
                out.writeUTF(way);
                out.writeBoolean(false);
            }
        }

    }

    private class ExitFolder implements ServerActions {

        public String commandName() {
            return "back";
        }

        public void execute(ToDo value) throws IOException {
            File file1 = new File(way);
            boolean isExist = false;
            String parent = null;
            if (file1.getParentFile().exists() && !way.equals(root)){
                isExist = true;
                parent = file1.getParent();
            }
            out.writeBoolean(isExist);
            if (isExist){
                way = parent;
            }
            out.writeUTF(way);
        }
    }

    private class ExitApp implements ServerActions {

        public String commandName() {
            return "exit";
        }

        public void execute(ToDo value) throws IOException {

        }
    }

    private class ShowList implements ServerActions {
        public String commandName() {
            return "list";
        }

        public void execute(ToDo value) throws IOException {
            File fl = new File(way);
            boolean isDir;
            isDir = fl.isDirectory();
            out.writeBoolean(isDir);
            if (isDir) {
                File[] files = fl.listFiles();
                int quantity = 0;
                if (files != null) {
                    quantity = files.length;
                }
                out.writeInt(quantity);
                if (quantity != 0) {
                    for (File file1 :
                            files) {
                        out.writeUTF(file1.getName());
                        if (file1.isDirectory()) {
                            out.writeBoolean(true);
                        } else {
                            out.writeBoolean(false);
                        }
                    }
                }
            }
            out.writeUTF(way);
        }
    }

    private class Download implements ServerActions {
        public String commandName() {
            return "download";
        }

        public void execute(ToDo value) throws IOException {
            newWay = way.concat(separator).concat(value.getTarget());
            boolean isExist = false;
            if (new File(newWay).exists()){
                isExist = true;
                way = newWay;
            }
            out.writeBoolean(isExist);
            if (isExist) {
                out.writeUTF(way);

                File file = new File(way);
                boolean isFolder = false;
                if (file.isDirectory()) {
                    isFolder = true;
                }
                out.writeBoolean(isFolder);
                if (!isFolder) {
                    int fileSize = (int) file.length();
                    out.writeInt(fileSize);
                    if (fileSize > bufferFile) {
                        divTail = fileSize % bufferFile;
                        sends = (fileSize - divTail) / bufferFile;
                        out.writeInt(bufferFile);
                        out.writeInt(sends);
                        out.writeInt(divTail);
                        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))){
                                byte []buffer = new byte[bufferFile];
                            for (int i = 0; i < sends; i++){
                                bis.read(buffer, 0, buffer.length);
                                out.write(buffer, 0, buffer.length);
                            }
                            if (divTail != 0){
                                byte []tailBuffer = new byte[divTail];
                                bis.read(tailBuffer, 0, tailBuffer.length);
                                out.write(tailBuffer, 0, tailBuffer.length);
                            }
                            bis.close();
                        }
                        catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }
                    else {
                        //bufferFile = fileSize;
                        out.writeInt(fileSize);
                        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))){
                                byte []buffer = new byte[fileSize];
                                bis.read(buffer, 0, buffer.length);
                                out.write(buffer, 0, buffer.length);
                        }
                        catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private class Upload implements ServerActions {
        @Override
        public String commandName() {
            return "upload";
        }

        @Override
        public void execute(ToDo value) throws IOException {
            boolean isExist = in.readBoolean();
            if (isExist) {
                boolean isDirectory = in.readBoolean();
                if (!isDirectory){
                    File file = new File(value.getTarget());
                    out.writeInt(bufferFile);
                    int fileSize = in.readInt();
                    boolean oneSent = in.readBoolean();
                    if (!oneSent){
                        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))){
                            sends = in.readInt();
                            divTail = in.readInt();
                            byte []buffer = new byte[bufferFile];
                            for (int i = 0; i < sends; i++){
                                in.read(buffer, 0, buffer.length);
                                bos.write(buffer, 0, buffer.length);
                            }
                            if (divTail != 0){
                                byte []tailBuffer = new byte[divTail];
                                in.read(tailBuffer, 0, tailBuffer.length);
                                bos.write(tailBuffer, 0, tailBuffer.length);
                            }
                            bos.flush();
                        }
                        catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }
                    else {
                        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))){
                            byte []buffer = new byte[fileSize];
                            in.read(buffer, 0, buffer.length);
                            bos.write(buffer, 0, buffer.length);
                            bos.flush();
                        }
                        catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
