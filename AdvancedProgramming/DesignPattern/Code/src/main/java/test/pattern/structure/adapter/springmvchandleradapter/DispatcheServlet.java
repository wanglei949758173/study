/*      
 * 模块编号  
 * 功能描述 
 * 文件名 DispatcheServerlet.java 
 * 作者 王磊 
 * 编写日期 2020年03月29日 
 */
package test.pattern.structure.adapter.springmvchandleradapter;

import java.util.ArrayList;
import java.util.List;

import test.pattern.structure.adapter.springmvchandleradapter.impl.AnnotationMethodHandlerAdapter;
import test.pattern.structure.adapter.springmvchandleradapter.impl.HttpRequestHandlerAdapter;
import test.pattern.structure.adapter.springmvchandleradapter.impl.SimpleControllerHandlerAdapter;

public class DispatcheServlet {
	private List<HandlerAdapter> handlerAdapters = new ArrayList<>();

	public DispatcheServlet() {
		handlerAdapters.add(new SimpleControllerHandlerAdapter());
		handlerAdapters.add(new AnnotationMethodHandlerAdapter());
		handlerAdapters.add(new HttpRequestHandlerAdapter());
	}

	public void doDispatch(Handler handler) {
		handlerAdapters.stream().forEach(handlerAdapter -> {
			if (handlerAdapter.support(handler)) {
				handlerAdapter.hanle(handler);
			}
		});
	}
}
