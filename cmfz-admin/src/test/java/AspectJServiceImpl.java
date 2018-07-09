/**
 * @program: cmfz
 * @description:
 * @author: gutian
 * @create: 2018-07-09 17:07
 **/
public class AspectJServiceImpl implements AspectJService {
    @Override
    public String sayHello(String name) {
        return "Hello"+name;
    }
}
