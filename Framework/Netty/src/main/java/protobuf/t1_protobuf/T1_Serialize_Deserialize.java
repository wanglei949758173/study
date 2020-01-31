package protobuf.t1_protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

import protobuf.t1_protobuf.Student.StudentMessage;

/**
 * 测试序列化和反序列化
 * 
 * @author Administrator
 *
 */
public class T1_Serialize_Deserialize {
	public static void main(String[] args) throws InvalidProtocolBufferException {
		StudentMessage student = Student.StudentMessage.newBuilder().setName("张三")
				.setAge(20).setAddress("西安").build();
		
		// 序列化为byte[]
		byte[] data = student.toByteArray();
		
		
		// 反序列化
		StudentMessage student2 = Student.StudentMessage.parseFrom(data);
		System.out.println(student2.getName());
		System.out.println(student2.getAge());
		System.out.println(student2.getAddress());
	}
}
