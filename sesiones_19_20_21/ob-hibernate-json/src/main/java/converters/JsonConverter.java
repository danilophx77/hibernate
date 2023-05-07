package converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.util.Map;

public class JsonConverter implements AttributeConverter<Map<String, Object>, String> {
    @Override
    public String convertToDatabaseColumn(Map<String, Object> attribute) {

        ObjectMapper objectMapper = new ObjectMapper();//de java a json
        String json = null;
        try {
            json = objectMapper.writeValueAsString(attribute);//preescribe los datos
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String dbData) { //de json a java

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> result = null;

        try {
            result = objectMapper.readValue(dbData, Map.class);//lee los datoos
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return result;
    }
}
