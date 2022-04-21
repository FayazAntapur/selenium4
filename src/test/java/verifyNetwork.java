import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Connection;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.testng.annotations.Test;

import java.util.Optional;

public class verifyNetwork {

    @Test
    public void OfflineTest(){
        //Need to test offline mode

        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.emulateNetworkConditions(true, 345 ,43545,
                34545, Optional.of(ConnectionType.BLUETOOTH)));
    }
}
