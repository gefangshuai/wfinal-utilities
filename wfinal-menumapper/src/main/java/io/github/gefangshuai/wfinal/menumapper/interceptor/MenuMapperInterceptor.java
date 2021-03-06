package io.github.gefangshuai.wfinal.menumapper.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.log.Logger;
import io.github.gefangshuai.wfinal.menumapper.annotation.Menu;
import io.github.gefangshuai.wfinal.menumapper.core.MenuMapper;
import io.github.gefangshuai.wfinal.menumapper.plugin.MenuMapperPlugin;

import java.lang.reflect.Method;

/**
 * 菜单注入拦截器 {@link MenuMapperPlugin}
 * Created by gefangshuai on 2015/7/6.
 */
public class MenuMapperInterceptor implements Interceptor {
    protected final Logger log = Logger.getLogger(getClass());

    @Override
    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        Method method = inv.getMethod();
        String attr = MenuMapper.getInstance().getAttribute();
        Menu menu;
        if ((menu = method.getAnnotation(Menu.class)) != null) {
            controller.setAttr(attr, menu.mapper());
            log.debug("menu: " + menu.mapper());
        } else if((menu = controller.getClass().getAnnotation(Menu.class))!= null) {
            controller.setAttr(attr, menu.mapper());
            log.debug("menu: " + menu.mapper());
        }
        inv.invoke();
    }
}
