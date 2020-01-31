package protobuf.t3_multi_protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protobuf.t3_multi_protocol.AnimalMessage.Animal;
import protobuf.t3_multi_protocol.AnimalMessage.Animal.AnimalType;
import protobuf.t3_multi_protocol.AnimalMessage.Cat;
import protobuf.t3_multi_protocol.AnimalMessage.Dog;
import protobuf.t3_multi_protocol.AnimalMessage.Pig;

public class TestServerHandler extends SimpleChannelInboundHandler<Animal>{

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Animal animal) throws Exception {
		if (AnimalType.CatType.equals(animal.getAnimalType())) {
			Cat cat = animal.getCat();
			System.out.println(cat.getName());
			System.out.println(cat.getAge());
			System.out.println(cat.getColor());
		} else if (AnimalType.DogType.equals(animal.getAnimalType())) {
			Dog dog = animal.getDog();
			System.out.println(dog.getName());
			System.out.println(dog.getSkill());
		} else {
			Pig pig = animal.getPig();
			System.out.println(pig.getName());
			System.out.println(pig.getWeight());
		}
	}
}
