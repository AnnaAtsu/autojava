package generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import common.CommonFunctions;
import model.DataContact;
import model.GroupData;

import java.io.File;
import java.io.IOException;
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


    public static void main(String[] args) throws IOException {
        var generator = new Generator();
        JCommander.newBuilder()
                .addObject(generator)
                .build()
                .parse(args);
        generator.run();
    }

    private void run() throws IOException {
        var data = generate();
        save(data);
        
    }

    private void save(Object data) throws IOException {
        if("json".equals(format)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(output), data);
        } else {
            throw new IllegalArgumentException("неизвестный формат данных " + format);
            }
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
        var result = new ArrayList<DataContact>();
        for (var i = 0; i < count; i++) {
            result.add(new DataContact()
                    .withFirstName(CommonFunctions.randomString(i * 2))
                    .withMiddleName(CommonFunctions.randomString(i * 2))
                    .withLastname(CommonFunctions.randomString(i * 2)));
        }

        return result;
    }

}
