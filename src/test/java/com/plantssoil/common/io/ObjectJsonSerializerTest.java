package com.plantssoil.common.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

public class ObjectJsonSerializerTest {
	public static void main(String[] args) throws JsonProcessingException {
		ObjectJsonSerializerTest test = new ObjectJsonSerializerTest();
		test.testSerialize();
	}

	@Test
	public void testSerialize() throws JsonProcessingException {
		for (int i = 0; i < 10; i++) {
			TestEventMessage om = new TestEventMessage("eventType" + i, "requestId" + i, "payload" + i);
			String string = ObjectJsonSerializer.getInstance().serialize(om);
			TestEventMessage un = ObjectJsonSerializer.getInstance().unserialize(string, TestEventMessage.class);
			assertEquals(om, un);
		}
	}
}
