import Action.GetCommands;
import Input.InputData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper obj = new ObjectMapper();
        File directory = new File("checker/resources/in/");
       // for ( File file : Objects.requireNonNull(directory.listFiles()) ) {
            InputData input = obj.readValue(new File(directory.getPath() +"/basic_3.json" /*file.getName()*/), InputData.class);
            ArrayNode output = obj.createArrayNode();
            GetCommands execute=new GetCommands();
            execute.action(input,output);
            ObjectWriter objectWriter = obj.writerWithDefaultPrettyPrinter();
            File out = new File("results.out");
            boolean iscreated = out.createNewFile();
            if ( iscreated )
                objectWriter.writeValue(new File("results.out"), output);
            else
                System.out.println("nu e creat bos");
            System.out.println(iscreated);
        }
    }

