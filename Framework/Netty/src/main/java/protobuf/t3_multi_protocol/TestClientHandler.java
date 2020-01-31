package protobuf.t3_multi_protocol;

import java.util.Random;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protobuf.t3_multi_protocol.AnimalMessage.Animal;
import protobuf.t3_multi_protocol.AnimalMessage.Animal.AnimalType;
import protobuf.t3_multi_protocol.AnimalMessage.Cat;
import protobuf.t3_multi_protocol.AnimalMessage.Dog;
import protobuf.t3_multi_protocol.AnimalMessage.Pig;

public class TestClientHandler extends SimpleChannelInboundHandler<Animal> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Animal msg) throws Exception {
	}

	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		int randomInt = new Random().nextInt(3);

		Animal animal = null;

		if (randomInt == 0) {
			animal = Animal.newBuilder().setAnimalType(AnimalType.CatType).setCat(
					Cat.newBuilder().setName("cat").setAge(20).setColor("灰色").build())
					.build();
		} else if (randomInt == 1) {
			animal = Animal.newBuilder().setAnimalType(AnimalType.DogType)
					.setDog(Dog.newBuilder().setName("dog").setSkill("看家").build())
					.build();
		} else {
			animal = Animal.newBuilder().setAnimalType(AnimalType.PigType)
					.setPig(Pig.newBuilder().setName("猪").setWeight("100kg").build())
					.build();
		}

		ctx.writeAndFlush(animal);
	};

}
