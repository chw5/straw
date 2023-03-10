package design.adapter;

import design.adapter.extend.SupAdapter;
import design.adapter.interfac.InterfaceAdapter;
import design.adapter.interfac.Target;

/**
 * @Author : wzq
 * @Date : 2023/3/10
 * @Version : 1.0
 * @Description :
 **/
public class AdapterTest {

    public static void main(String[] args) {
        SupAdapter supAdapter = new SupAdapter();
        supAdapter.start();
        supAdapter.processing();
        supAdapter.end();

        InterfaceAdapter interfaceAdapter = new InterfaceAdapter(new Target());
        interfaceAdapter.start();
        interfaceAdapter.processing();
        interfaceAdapter.end();
    }
}
