package com.plantssoil.common.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Serialize Object to byte array and unserialize byte array to Object
 * 
 * @author danialdy
 * @Date 24 Nov 2024 9:41:52 pm
 */
public class ObjectByteArraySerializer {
	/**
	 * serialize Object to byte array
	 * 
	 * @param <T>    the object type need to serialize
	 * @param object the object to serialize
	 * @return serialized byte array
	 * @throws IOException
	 */
	public static <T extends java.io.Serializable> byte[] serialize(T object) throws IOException {
		try (ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(bytesOut)) {
			oos.writeObject(object);
			oos.flush();
			byte[] bytes = bytesOut.toByteArray();
			return bytes;
		}
	}

	/**
	 * unserialize byte array to Object
	 * 
	 * @param <T>        the object type need to unserialize
	 * @param serialized serialized byte array
	 * @return object unserialized
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static <T extends java.io.Serializable> T unserialize(byte[] serialized)
			throws IOException, ClassNotFoundException {
		try (ByteArrayInputStream bytesIn = new ByteArrayInputStream(serialized);
				ObjectInputStream ois = new ObjectInputStream(bytesIn)) {
			@SuppressWarnings("unchecked")
			T obj = (T) ois.readObject();
			return obj;
		}
	}

}
