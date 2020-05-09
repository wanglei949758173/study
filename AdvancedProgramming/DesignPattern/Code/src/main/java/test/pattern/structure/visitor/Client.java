/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java 
 * 作者 王磊 
 * 编写日期 2020年05月09日 
 */
package test.pattern.structure.visitor;

import test.pattern.structure.visitor.impl.Approve;
import test.pattern.structure.visitor.impl.Audience;
import test.pattern.structure.visitor.impl.NoVote;
import test.pattern.structure.visitor.impl.Oppose;

public class Client {
	public static void main(String[] args) {
		AbstractAudience audience1 = new Audience("男");
		AbstractAudience audience2 = new Audience("女");
		AbstractAudience audience3 = new Audience("女");
		AbstractAudience audience4 = new Audience("男");
		AbstractAudience audience5 = new Audience("男");
		
		audience1.vote(new Approve());
		audience2.vote(new Approve());
		audience3.vote(new Approve());
		audience4.vote(new Oppose());
		audience5.vote(new NoVote());
	}
}
