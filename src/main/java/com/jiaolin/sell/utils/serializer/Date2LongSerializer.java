package com.jiaolin.sell.utils.serializer;



import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 11:08 2018/5/2
 * @Modify By:
 */
public class Date2LongSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
		jsonGenerator.writeNumber(date.getTime() / 1000);
	}
}
