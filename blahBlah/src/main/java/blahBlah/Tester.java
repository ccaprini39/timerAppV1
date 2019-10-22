package blahBlah;
import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Tester {

	public static void main(String[] args) {
		
		System.out.println("This is working now");
		Timer t = new Timer("cat", 6, 3, 3);
		t.printTimerInfo();
		System.out.println();
		
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            Timer timer = mapper.readValue(new File("src/main/resources/timer.yaml"), Timer.class);
            timer.printTimerInfo();
            timer.executeTimer();
            //System.out.println(ReflectionToStringBuilder.toString(timer,ToStringStyle.MULTI_LINE_STYLE));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Timer t2 = new Timer("bat", 5, 3, 3);
        System.out.println();
        t.printTimerInfo();
        t.executeTimer();
        System.out.println();
        try {
			mapper.writeValue(new File("src/main/resources/timerOutput.yaml"), t);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
