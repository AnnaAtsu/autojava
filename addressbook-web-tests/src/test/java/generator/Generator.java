package generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.CommonFunctions;
import model.GroupData;

import java.util.ArrayList;

//Лекция 5 с генератором файлов
public class Generator {

    @Parameter (names={"--type", "-t"})
    String type;

    @Parameter (names={"--output", "-o"})
    String output;

    @Parameter (names={"--format", "-f"})
    String format;


    @Parameter (names={"--count", "-n"})
    int count;


    public static void main(String[] args) {
        var generator = new Generator();
        JCommander.newBuilder()
                .addObject(generator)
                .build()
                .parse(args);
        generator.run();
    }

    private void run() {
        var data = generate();
        save(data);
        
    }

    private void save(Object data) {
        ObjectMapper mapper = new ObjectMapper();
    }

    private Object generate() {
        if("groups".equals(type)){
            return generateGroups();
        } else if ("contacts".equals(type)) {
            return generateContacts();
        } else {
            throw new IllegalArgumentException("неизвестный тип данных" + type);
        }
    }

    private Object generateGroups() {
        var result = new ArrayList<GroupData>();
        for (int i = 0; i < count; i++) {
            result.add(new GroupData()
                    .withName(CommonFunctions.randomString(i * 2))
                    .withHeader(CommonFunctions.randomString(i * 2))
                    .withFooter(CommonFunctions.randomString(i * 2)));
        }
        return  result;
    }



    private Object generateContacts() {
        return null;
    }




}
