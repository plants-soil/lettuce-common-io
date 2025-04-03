package com.plantssoil.common.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class ObjectByteArraySerializerTest {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		ObjectByteArraySerializerTest test = new ObjectByteArraySerializerTest();
		test.testSerialize();
	}

	@Test
	public void testSerialize() throws IOException, ClassNotFoundException {
		for (int i = 0; i < 10; i++) {
			TestEventMessage om = new TestEventMessage("eventType" + i, "requestId" + i, "payload" + i);
			byte[] bytes = ObjectByteArraySerializer.serialize(om);
			TestEventMessage un = ObjectByteArraySerializer.unserialize(bytes);
			assertEquals(om, un);
		}
	}
}
