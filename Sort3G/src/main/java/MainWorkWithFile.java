import java.io.IOException;

/**
 Created by ${Ruslan} on 03.01.17.
 */
public class MainWorkWithFile {
        private static WorkWithFile worker;
    public static void main(String []args) throws IOException {
        worker = new WorkWithFile("test.txt");
        worker.write("Give me the reason \n" +
                "Come on give me the reason \n" +
        "wuerfhuweqhefhqwuehfuih wequi uwqehf weu huwe h \n" +
        "wefiwnerfinweinfinwe joiwejfiwjqrifguiweqrhg wqeffgwqerrf"
                );
        System.out.println(worker.goTo(12));
        System.out.println("_________________________________________");
        System.out.println(worker.read());
        System.out.println("_________________________________________");
        System.out.println(worker.readFrom(10));
        System.out.println("_________________________________________");
    }
}
