package nio.channel;

import java.nio.ByteBuffer;

public class T5_ByteBuffer_Read_Write_Primitive {
	public static void main(String[] args) {
		// 使用ByteBuffer读取原生类型数据
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		buffer.putInt(5);
		buffer.putLong(2233344555L);
		buffer.putChar('a');
		buffer.putShort((short) 33);
		
		buffer.flip();
		System.out.println(buffer.getInt());
		System.out.println(buffer.getLong());
		System.out.println(buffer.getChar());
		System.out.println(buffer.getShort());
	}
}
