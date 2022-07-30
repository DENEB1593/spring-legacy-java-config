import com.sinsa.palletpang.common.config.RootConfig;
import com.sinsa.palletpang.common.config.ServletConfig;
import com.sinsa.palletpang.domain.TestMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
public class TestMapperTest {

    @Autowired
    private TestMapper testMapper;

    @Test
    public void test() {
        String result = testMapper.select();
    }
}
